package org.hltic.sms_androidfrontend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import android.os.Bundle;
import org.hltic.sms_androidfrontend.R;
import org.hltic.sms_androidfrontend.StudentRegistration.StudentDetailsFragment;
import org.hltic.sms_androidfrontend.domaine.dto.RegistrationDto;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsRecyclerViewAdapter extends RecyclerView.Adapter<StudentsRecyclerViewAdapter.RegistrationViewHolder> {

    private List<RegistrationDto> listRegistrations;
    private Context context;

    public StudentsRecyclerViewAdapter(Context context, List<RegistrationDto> listRegistrations) {
        this.context = context;

        this.listRegistrations = listRegistrations;
    }

    @Override
    public RegistrationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_liste_registration_recycler_view, parent, false);

        return new RegistrationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RegistrationViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final RegistrationDto current = listRegistrations.get(position);

                holder.registrationRef.setText(current.getRegisterRef());

                //Toast.makeText(context, "Card view clicked", Toast.LENGTH_SHORT).show();

                StudentDetailsFragment studentDetails  = new StudentDetailsFragment();

                Bundle bundle = new Bundle();

                bundle.putString("studentRef", current.getRegisterRef());

                studentDetails.setArguments(bundle);
                FragmentManager manager =  ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, studentDetails).commit();
            }
        });


        RegistrationDto registrationDto = listRegistrations.get(position);
        holder.bind(registrationDto);

    }

    @Override
    public int getItemCount() {
        if (listRegistrations == null) {
            return 0;
        }
        return listRegistrations.size();
    }


    public void setListeDesRegistrations(List<RegistrationDto> listeDesRegistrations) {
        this.listRegistrations = listeDesRegistrations;
        notifyDataSetChanged();
    }

    class RegistrationViewHolder extends RecyclerView.ViewHolder{

        private ImageView photoView;
        private TextView registrationRef;
        private TextView firstName;
        private CardView cardView;

        public RegistrationViewHolder(View itemView) {
            super(itemView);

            photoView = itemView.findViewById(R.id.img_student);
            registrationRef = itemView.findViewById(R.id.tv_student_reference);
            firstName = itemView.findViewById(R.id.tv_student_first_name);
            cardView = (CardView) itemView.findViewById(R.id.cdv_student_list);
        }


        public void bind(RegistrationDto registrationDto){

            registrationRef.setText(registrationDto.getRegisterRef());
            firstName.setText("Name : " + registrationDto.getStudent().getFirstName()
            + " " + registrationDto.getStudent().getLastName());

            Picasso.get().load(registrationDto.getUrlImage()).placeholder(R.mipmap.image_profile_01)
                    .into(photoView);


        }

    }
}