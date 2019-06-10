package com.example.sonnewspaper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewpostAdapter extends RecyclerView.Adapter<NewpostAdapter.Viewholder> {
    Context context;
    ArrayList<NewPost> arrayList;
    public NewpostAdapter(Context context, ArrayList<NewPost> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemview = inflater.inflate(R.layout.item_row,viewGroup,false);
        return new Viewholder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        final int chiso = i;
            viewholder.txttitle.setText(arrayList.get(i).getTittle());
            viewholder.txttime.setText(arrayList.get(i).getTime().substring(11,19));
            Picasso.get().load(arrayList.get(i).getImage()).into(viewholder.img);

            viewholder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DetailPost.class);
                    intent.putExtra("link",arrayList.get(chiso).getLinkbaiviet());
                    context.startActivity(intent);
                }
            });
            viewholder.txttime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, arrayList.get(i).getTime(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txttitle,txttime;
        LinearLayout ll;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.thumbnail);
            txttitle = (TextView) itemView.findViewById(R.id.textviewtitle);
            txttime = (TextView) itemView.findViewById(R.id.textviewminuteago);
            ll = (LinearLayout) itemView.findViewById(R.id.linearlayout);
        }
    }
    
}
