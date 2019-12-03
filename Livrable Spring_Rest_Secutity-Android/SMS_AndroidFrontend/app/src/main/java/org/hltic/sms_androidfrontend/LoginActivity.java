package org.hltic.sms_androidfrontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import org.hltic.sms_androidfrontend.api.RegistrationApiRestService;
import org.hltic.sms_androidfrontend.domaine.dto.LoginDto;
import org.hltic.sms_androidfrontend.domaine.dto.TokenDto;
import org.hltic.sms_androidfrontend.utils.Utility;

public class LoginActivity extends AppCompatActivity {

    private Toolbar tlbMainPage;

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tlbMainPage = findViewById(R.id.tlb_main_page);
        setSupportActionBar(tlbMainPage);
        getSupportActionBar().setTitle("School Management");
        edtUserName = findViewById(R.id.edt_login_username);
        edtPassword = findViewById(R.id.edt_login_password);
        btnConnect = findViewById(R.id.btn_login_connect);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if(isOnline()){

                    if (edtUserName.getText().toString().matches("") ||
                            edtPassword.getText().toString().matches("") ) {

                        Toast.makeText(getApplicationContext(), "All Fields are required!!", Toast.LENGTH_LONG).show();

                    } else {

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(Utility.BASE_URL_USERS)
                                .client(Utility.getClientHttpForAll(getApplicationContext()))
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        RegistrationApiRestService service = retrofit.create(RegistrationApiRestService.class);

                        LoginDto loginDto = new LoginDto(userName, password);
                        service.login(loginDto).enqueue(new Callback<TokenDto>() {
                            @Override
                            public void onResponse(Call<TokenDto> call, Response<TokenDto> response) {

                                if (response.isSuccessful()) {

                                    TokenDto responseTokenDto = response.body();

                                    Utility.setPreferredToken(getApplicationContext(),responseTokenDto.getTokenDto());

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);

                                    Toast.makeText(getApplicationContext(), responseTokenDto.getTokenDto(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Bad response!!!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<TokenDto> call, Throwable t) {

                                //Snackbar.make(findViewById(R.id.rootLayout), "No Internet connection, Please set ON Internet connection!!!", Snackbar.LENGTH_SHORT).show();

                                Toast.makeText(getApplicationContext(), "Impossible to connect to the server !", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                }
                else{

                    Toast.makeText(getApplicationContext(), "No Internet connection, Please set ON Internet connection!!!", Toast.LENGTH_SHORT).show();
                    /*Snackbar.make(View, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/
                }
            }
        });
    }


    public boolean isOnline() {
        boolean status=false;
        try{
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState()== NetworkInfo.State.CONNECTED) {
                status= true;
            }else {
                netInfo = cm.getNetworkInfo(1);
                if(netInfo!=null && netInfo.getState()== NetworkInfo.State.CONNECTED)
                    status= true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return status;
    }
}
