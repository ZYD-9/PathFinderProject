package com.example.pathfinder;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    AssessmentFragment assessmentFragment = new AssessmentFragment();
    TrackResultsFragment trackResultsFragment = new TrackResultsFragment();
    Confirmsignout confirmsignoutFragment = new Confirmsignout();
    FirebaseAuth payoAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayer);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        payoAuth = FirebaseAuth.getInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,assessmentFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.assessment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,assessmentFragment).commit();
                        return true;
                    case R.id.track_results:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,trackResultsFragment).commit();
                        return true;
                    case R.id.sign_out:
                       getSupportFragmentManager().beginTransaction().replace(R.id.container,confirmsignoutFragment).commit();
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser user = payoAuth.getCurrentUser();
//        if(user == null ){
//            startActivity(new Intent(MainActivity.this,SignIn.class));
//        }
    }



    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
}