package org.hltic.sms_androidfrontend.StudentRegistration;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import org.hltic.sms_androidfrontend.R;
import org.hltic.sms_androidfrontend.api.RegistrationApiRestService;
import org.hltic.sms_androidfrontend.domaine.dto.RegistrationDto;
import org.hltic.sms_androidfrontend.utils.Utility;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentDetailsFragment extends Fragment {


    private ImageView photoView;

    private TextView refeView;
    private TextView firstNameView;
    private TextView genderView;
    private TextView adressView;
    private TextView ageView;
    private TextView classroomView;
    private TextView feesView;
    private TextView dateView;
    private TextView yearView;
    private Button btnEdit;
    private Button btnDelete;

    String studentRef 		;

    public StudentDetailsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState = getArguments();
        if (savedInstanceState != null)
        {
            studentRef = getArguments().getString("studentRef");

            Toast.makeText(getContext(), studentRef.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View studentDetails = inflater.inflate(R.layout.fragment_student_details, container, false);


        photoView = studentDetails.findViewById(R.id.img_student);
        refeView = studentDetails.findViewById(R.id.tv_student_reference);
        firstNameView = studentDetails.findViewById(R.id.tv_student_first_name);
        genderView = studentDetails.findViewById(R.id.tv_student_gender);
        adressView = studentDetails.findViewById(R.id.tv_student_address);
        ageView = studentDetails.findViewById(R.id.tv_student_Age);
        classroomView = studentDetails.findViewById(R.id.tv_student_Classroom);
        feesView = studentDetails.findViewById(R.id.tv_student_Fees);
        dateView = studentDetails.findViewById(R.id.tv_student_Date);
        yearView = studentDetails.findViewById(R.id.tv_student_Year);
        btnEdit = studentDetails.findViewById(R.id.btn_student_edit);
        btnDelete = studentDetails.findViewById(R.id.btn_student_delete);

        btnEdit.setVisibility(View.INVISIBLE);
        btnDelete.setVisibility(View.INVISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utility.BASE_URL_REGISTRATIONS)
                .client(Utility.getClientHttpForAll(getContext()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegistrationApiRestService service = retrofit.create(RegistrationApiRestService.class);

        service.findRegistrationByRef("Bearer " + Utility.getPreferredToken(getContext()), studentRef).enqueue(new Callback<RegistrationDto>() {
            @Override
            public void onResponse(Call<RegistrationDto> call, Response<RegistrationDto> response) {

                if (response.body()!= null){


                    RegistrationDto registrationDto = response.body();
                    refeView.setText("Student Reference: " + studentRef);
                    firstNameView.setText("Name: " + registrationDto.getStudent().getFirstName()
                    + " " + registrationDto.getStudent().getLastName());
                    genderView.setText("Gender: " + registrationDto.getStudent().getGender());
                    adressView.setText("Address:" + registrationDto.getStudent().getAdress());
                    ageView.setText("Age: " + registrationDto.getStudent().getAge());
                    classroomView.setText("Classroom: " + registrationDto.getStudent().getClassRoom());
                    feesView.setText("Fees: "+ registrationDto.getFees());
                    dateView.setText("Date: " + registrationDto.getDate());
                    yearView.setText("Year: " + registrationDto.getYear());

                    Picasso.get().load(registrationDto.getUrlImage()).placeholder(R.mipmap.image_profile_01)
                            .into(photoView);

                    btnEdit.setVisibility(View.VISIBLE);
                    btnDelete.setVisibility(View.VISIBLE);

                }else {
                    Toast.makeText(getContext(), "Cannot find Registration !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistrationDto> call, Throwable t) {

                Toast.makeText(getContext(), "Cannot find Server !!!", Toast.LENGTH_SHORT).show();

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent updateIntent = new Intent(getContext(), UpdateRegistrationActivity.class);
                updateIntent.putExtra("studentRef", studentRef);

                startActivity(updateIntent);*/

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Intent updateIntent = new Intent(getContext(), DeleteRegistrationActivity.class);
                updateIntent.putExtra("studentRef", studentRef);

                startActivity(updateIntent);*/
            }
        });

        return studentDetails;
    }
}
