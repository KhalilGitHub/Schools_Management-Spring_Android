package org.hltic.sms_androidfrontend.StudentRegistration;


import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.hltic.sms_androidfrontend.R;
import org.hltic.sms_androidfrontend.domaine.dto.RegistrationDto;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchStudentFragment extends Fragment {

    private Toolbar tlbMainPage;

    private EditText refEdt;
    private Button   btnFind;



    public SearchStudentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_student, container, false);

        tlbMainPage = view.findViewById(R.id.tlb_main_page);
        //setSupportActionBar(tlbMainPage);

        refEdt    = view.findViewById(R.id.edt_find_student);
        btnFind = view.findViewById(R.id.btn_find_student);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StudentDetailsFragment studentDetails  = new StudentDetailsFragment();

                final String studentRef = refEdt.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("studentRef", studentRef);

                studentDetails.setArguments(bundle);
                FragmentManager manager =  ((AppCompatActivity)getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, studentDetails).commit();
            }
        });

        return view;
    }

}
