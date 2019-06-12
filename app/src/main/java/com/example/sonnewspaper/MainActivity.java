package com.example.sonnewspaper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
    // sontit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("vongdoi","OncreatMain");
        anhxa();
        loadFragment(new Home_fragment(),"home");
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        fragment = new Home_fragment();
                        loadFragment(fragment,"home");
                        break;

                    case R.id.navigation_messenger:
                        fragment = new Messenger_fragment();
                        loadFragment(fragment,"mess");
                        break;
                    case R.id.navigation_notification:
                        fragment = new Notification_fragment();
                        loadFragment(fragment,"notifi");
                        break;
                    case R.id.navigation_profile:
                        fragment = new Profile_fragment();
                        loadFragment(fragment,"profile");
                        break;
                }
                return true;
            }
        });
    }

    private void anhxa() {
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomnavigation);
        frameLayout = (FrameLayout) findViewById(R.id.framecontainer);

    }
    private void loadFragment(Fragment fragment,String key) {
        // load fragment
        Fragment frg = getSupportFragmentManager().findFragmentByTag(key);
        if(frg!=null){
            getSupportFragmentManager().popBackStack(key,0);
        }else{
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.framecontainer,fragment,key);
            fragmentTransaction.addToBackStack(key);
            fragmentTransaction.commit();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("vongdoi","OnStartMain");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("vongdoi","OnresumeMain");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("vongdoi","OnPauseMain");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("vongdoi","OnStopMain");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("vongdoi","OnrestartMain");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("vongdoi","OnDestroyMain");
    }
}
