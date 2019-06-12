package com.example.sonnewspaper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Messenger_fragment extends Fragment {
    ArrayList<Chatmessage> arrayList;
    String nameusser;
    EditText edtuser;
    RecyclerView recyclerView;
    EditText edtcontent;
    ImageView imgsend;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, h:mm a");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_messenger,container,false);
        Log.d("vongdoi","oncreatView_Mess");
        // ánh xạ
        imgsend = (ImageView) view.findViewById(R.id.imagesend);
        edtcontent = (EditText) view.findViewById(R.id.edtittext);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        edtuser = (EditText) view.findViewById(R.id.edtittextuser);
        // getActivity
        final Activity activity = getActivity();
        // ẩn bottom navigation khi cuộn
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && activity.findViewById(R.id.bottomnavigation).isShown()) {
                    activity.findViewById(R.id.bottomnavigation).setVisibility(View.GONE);
                } else if (dy < 0 ) {
                    activity.findViewById(R.id.bottomnavigation).setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        imgsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                edtuser.setBackgroundColor(color);
                */
                if(edtuser.getText().toString().trim().isEmpty())
                {
                    nameusser = "Vô danh";
                }else{
                    nameusser = edtuser.getText().toString();
                }
                String date = df.format(Calendar.getInstance().getTime());
                Log.d("timesontit",date.substring(date.length()-8));
                myRef.push().setValue(new Chatmessage(nameusser,edtcontent.getText()+"",date.substring(date.length()-8)));
                edtcontent.setText("");
            }
        });
        // set up rerycler view
        arrayList = new ArrayList<>();
        final AdapterChatmessage adaper = new AdapterChatmessage(getContext(),arrayList);
        recyclerView.setAdapter(adaper);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        // lắng nghe có sự thay đổi gì từ database ko ?
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                arrayList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    arrayList.add(new Chatmessage(ds.child("usersend").getValue().toString() + ": ",ds.child("content").getValue().toString(),ds.child("time").getValue().toString()));
                    // arrayList.add(ds.child("usersend").getValue().toString() + "(" + ds.child("time").getValue().toString() + ")" + " :  " +ds.child("content").getValue().toString());
                }
                adaper.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("vongdoi","oncreat_Mess");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("vongdoi","onStart_Mess");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("vongdoi","onresume_Mess");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("vongdoi","oncreatPause_Mess");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("vongdoi","onstop_Mess");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("vongdoi","ondestroyView_Mess");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("vongdoi","ondestroy_Mess");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("vongdoi","ondetach_Mess");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("vongdoi","onAtacK_Mess");
    }
}
