package com.mahmoudrabie.sql;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<model,MyAdapter.myviewholder> {
    public MyAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.title.setText(String.valueOf(model.getName()));
        holder.desc.setText(String.valueOf(model.getDesc()));
        holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.i.getContext(),View_pdf.class);
                intent.putExtra("filename",model.getName());
                intent.putExtra("fileurl",model.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.i.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_desingn,parent,false);
        return new  myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView i;
        TextView title,desc;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.custom_book_iv_book);
            title=itemView.findViewById(R.id.custom_book_tv_name);
            desc=itemView.findViewById(R.id.custom_book_tv_description);
        }
    }
}
