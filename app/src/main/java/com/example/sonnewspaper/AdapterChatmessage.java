package com.example.sonnewspaper;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class AdapterChatmessage extends RecyclerView.Adapter<AdapterChatmessage.Viewholder>{
    public AdapterChatmessage(Context context, ArrayList<Chatmessage> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    Context context;
    ArrayList<Chatmessage> arrayList;
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_chat,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder viewholder, int i) {
        // random color
           Random rnd = new Random();
           int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
           viewholder.txtusername.setTextColor(color);
           viewholder.txtusername.setText(arrayList.get(i).getUsersend());
           viewholder.txttime.setText(arrayList.get(i).getTime());
           viewholder.txtcontent.setText(arrayList.get(i).getContent());
           viewholder.txttime.setVisibility(View.INVISIBLE);
           viewholder.txtcontent.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (viewholder.txttime.getVisibility() == View.VISIBLE) {
                       // Its visible
                       viewholder.txttime.setVisibility(View.INVISIBLE);
                   }else if(viewholder.txttime.getVisibility() == View.INVISIBLE){
                       viewholder.txttime.setVisibility(View.VISIBLE);
                   }
               }
           });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView txtusername,txttime,txtcontent;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txtusername = (TextView) itemView.findViewById(R.id.textviewusername);
            txtcontent = (TextView) itemView.findViewById(R.id.textviewcontent);
            txttime = (TextView) itemView.findViewById(R.id.textviewtime);
        }
    }
}
