package com.example.sonnewspaper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class Messenger_fragment extends Fragment {
    EditText edtname,edtcontent;
    Button btnsend;
    ListView lvchat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_messenger,container,false);
        // ánh xạ
        edtname = (EditText) view.findViewById(R.id.edittextusername);
        edtcontent = (EditText) view.findViewById(R.id.edittextcontent);
        btnsend = (Button) view.findViewById(R.id.buttonsend);
        lvchat = (ListView) view.findViewById(R.id.listviewchat);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtcontent.setText("");
                Toast.makeText(getActivity(), "Đã gửi", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
