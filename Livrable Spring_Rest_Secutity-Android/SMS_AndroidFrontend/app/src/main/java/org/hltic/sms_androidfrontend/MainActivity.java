package org.hltic.sms_androidfrontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.hltic.sms_androidfrontend.StudentRegistration.MainStudentRegistration;

public class MainActivity extends AppCompatActivity {



    private Toolbar tlbMainPage;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlbMainPage = findViewById(R.id.tlb_main_page);
        setSupportActionBar(tlbMainPage);
        getSupportActionBar().setTitle("School Management");


        drawer = findViewById(R.id.drw_main_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, tlbMainPage, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView leftNavigationView = findViewById(R.id.nav_main_left_view);
        leftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Left navigation view item clicks here.
                int id = item.getItemId();

                switch (id){

                    case R.id.nav_student:{

                        Intent intent = new Intent(getApplicationContext(), MainStudentRegistration.class);
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this, "Left Drawer - Student Registration", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    case R.id.nav_student_marks:{


                        /*Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                        startActivity(intent);
                        drawer.closeDrawer(GravityCompat.START);*/
                        Toast.makeText(MainActivity.this, "Left Drawer - Student Marks", Toast.LENGTH_SHORT).show();

                        return true;

                    }

                    case R.id.nav_receipt:{


                        Toast.makeText(MainActivity.this, "Left Drawer - Receipt", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    case R.id.nav_teacher:{

                        /*Intent intent = new Intent(getApplicationContext(), MainRecruitmentActivity.class);
                        startActivity(intent);*/
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    case R.id.nav_share:{

                        Toast.makeText(MainActivity.this, "Left Drawer - Share", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }


                }

                return true;

            }
        });

        NavigationView rightNavigationView = findViewById(R.id.nav_main_left_right);
        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Left navigation view item clicks here.
                int id = item.getItemId();

                switch (id){

                    case R.id.nav_create_password:{

                       /* Intent intent = new Intent(getApplicationContext(), MainStudentRegistration.class);
                        startActivity(intent);*/
                        Toast.makeText(MainActivity.this, "Right Drawer - Create Password", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    case R.id.edit_password:{


                        /*Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                        startActivity(intent);
                        drawer.closeDrawer(GravityCompat.START);*/
                        Toast.makeText(MainActivity.this, "Right Drawer - Student Marks", Toast.LENGTH_SHORT).show();

                        return true;

                    }

                    case R.id.nav_delete_password:{


                        Toast.makeText(MainActivity.this, "Right Drawer - Receipt", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    case R.id.nav_logout:{

                        /*Intent intent = new Intent(getApplicationContext(), MainRecruitmentActivity.class);
                        startActivity(intent);*/
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                }

                return true;

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer.isDrawerOpen(GravityCompat.END)) {  /*Closes the Appropriate Drawer*/
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_icon_right, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            drawer.openDrawer(GravityCompat.END); /*Opens the Right Drawer*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
