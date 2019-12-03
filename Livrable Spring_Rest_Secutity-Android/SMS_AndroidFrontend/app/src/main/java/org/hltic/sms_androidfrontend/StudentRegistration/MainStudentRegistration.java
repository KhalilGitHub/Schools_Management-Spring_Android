package org.hltic.sms_androidfrontend.StudentRegistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import org.hltic.sms_androidfrontend.MainActivity;
import org.hltic.sms_androidfrontend.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainStudentRegistration extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student_registration);

        toolbar = findViewById(R.id.tlb_main_page);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.dwl_main_students);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null){

                return;
            }

            FragmentManager fragmentManager = MainStudentRegistration.this.getSupportFragmentManager();
            StudentListFragment fragment =new StudentListFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }


        NavigationView rightNavigationView = findViewById(R.id.nav_main_left_right);
        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                switch (id){

                    case R.id.itm_list_student:{

                        FragmentManager fragmentManager = MainStudentRegistration.this.getSupportFragmentManager();
                        StudentListFragment fragment =new StudentListFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, fragment);
                        fragmentTransaction.commit();
                        //Toast.makeText(MainActivity.this, "Right Drawer - Create Password", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.END);
                        return true;
                    }

                    case R.id.itm_new_registration:{


                        /*Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.END);*/
                        Toast.makeText(MainStudentRegistration.this, "Right Drawer - New Student Registration", Toast.LENGTH_SHORT).show();

                        return true;

                    }

                    case R.id.itm_search_student:{


                        Toast.makeText(MainStudentRegistration.this, "Right Drawer - search student", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.END);
                        return true;
                    }

                }

                return true;

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_icon_right, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_settings:
                drawerLayout.openDrawer(GravityCompat.END);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}

