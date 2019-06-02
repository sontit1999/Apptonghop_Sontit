package com.example.sonnewspaper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    Fragment fragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Home_fragment();
                    loadfragment(fragment);
                    return true;
                case R.id.navigation_notification:
                    fragment = new Notification_fragment();
                    loadfragment(fragment);
                    return true;
                case R.id.navigation_messenger:
                    fragment = new Messenger_fragment();
                    loadfragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    fragment = new Profile_fragment();
                    loadfragment(fragment);
                    return true;
            }
            return true;
        }
    };
    private void anhxa() {
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomnavigation);
        frameLayout = (FrameLayout) findViewById(R.id.framecontainer);

    }
    private void loadfragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framecontainer,fragment);
        fragmentTransaction.commit();
    }

}
