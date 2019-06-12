package com.example.sonnewspaper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Notification_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        Log.d("vongdoi","oncreatviewNotification");
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("vongdoi","oncreatNotificition");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("vongdoi","onStartNotificition");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("vongdoi","onresumeNotificition");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("vongdoi","oncreatPauseNotificition");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("vongdoi","onstopNotificition");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("vongdoi","ondestroyViewNotificition");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("vongdoi","ondestroyNotificition");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("vongdoi","ondetachNotificition");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("vongdoi","onActivitycreatNotificition");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("vongdoi","onAtaclHOme");
    }
}
