package org.hltic.sms_androidfrontend.StudentRegistration;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import org.hltic.sms_androidfrontend.R;
import org.hltic.sms_androidfrontend.adapter.StudentsRecyclerViewAdapter;
import org.hltic.sms_androidfrontend.api.RegistrationApiRestService;
import org.hltic.sms_androidfrontend.domaine.dto.RegistrationDto;
import org.hltic.sms_androidfrontend.utils.Utility;

import java.util.Collections;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentListFragment extends Fragment{


    private View studentsView;
    private RecyclerView recyclerView;
    private StudentsRecyclerViewAdapter studentsRecyclerViewAdapter;
    private List<RegistrationDto> listRegistrations = Collections.emptyList();
    private FragmentActivity listener;

    public StudentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        studentsView = inflater.inflate(R.layout.fragment_student_list, container, false);

        recyclerView = studentsView.findViewById(R.id.rcv_list_students);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Context context = studentsView.getContext();

        studentsRecyclerViewAdapter = new StudentsRecyclerViewAdapter(context, listRegistrations);
        recyclerView.setAdapter(studentsRecyclerViewAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utility.BASE_URL_REGISTRATIONS)
                .client(Utility.getClientHttpForAll(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegistrationApiRestService service = retrofit.create(RegistrationApiRestService.class);

        service.getRegistrations("Bearer " + Utility.getPreferredToken(context)).enqueue(new Callback<List<RegistrationDto>>() {
            @Override
            public void onResponse(Call<List<RegistrationDto>> call, Response<List<RegistrationDto>> response) {

                if (response.body()!= null){
                    listRegistrations = response.body();
                    studentsRecyclerViewAdapter.setListeDesRegistrations(listRegistrations);

                }else {
                    Toast.makeText(getContext(), "Noone Register !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RegistrationDto>> call, Throwable t) {

                Toast.makeText(getContext(), "Cannot find Backend Server !!!", Toast.LENGTH_SHORT).show();

            }
        });



        FloatingActionButton fab = studentsView.findViewById(R.id.btn_asset_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SearchStudentFragment searchStudent = new SearchStudentFragment();

                Bundle bundle = new Bundle();

                searchStudent.setArguments(bundle);
                MainStudentRegistration.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, searchStudent, null)
                        .addToBackStack(null).commit();

                /*Snackbar.make(view, "Hi You clock Floating button. Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        return studentsView;
    }
}
