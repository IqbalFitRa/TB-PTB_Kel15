package com.kelompok_15.tb_ptb;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    Context context;
    ArrayList<mahasiswaCard> mahasiswacard;

    public CardAdapter (Context context, ArrayList<mahasiswaCard>mahasiswacard ){
        this.context = context;
        this.mahasiswacard = mahasiswacard;
    }

    @NonNull
    @Override
    public CardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new CardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.MyViewHolder holder, int position) {
        holder.namamahasiswa.setText(mahasiswacard.get(position).getNamaMahasiswa());
        holder.nimmahasiswa.setText(mahasiswacard.get(position).getNimMahasiswa());
        holder.fotomahasiswa.setImageResource(mahasiswacard.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mahasiswacard.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView fotomahasiswa;
        TextView namamahasiswa, nimmahasiswa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fotomahasiswa = itemView.findViewById(R.id.fotomahasiswa);
            namamahasiswa = itemView.findViewById(R.id.namamahasiswa);
            nimmahasiswa = itemView.findViewById(R.id.nimmahasiswa);
        }
    }
}
