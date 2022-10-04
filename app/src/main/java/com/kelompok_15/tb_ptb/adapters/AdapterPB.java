package com.kelompok_15.tb_ptb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.PermintaanBimbingan;

import java.util.ArrayList;

public class AdapterPB extends RecyclerView.Adapter <AdapterPB.PBViewHolder>{

    ArrayList<PermintaanBimbingan> perBim = new ArrayList<>();

    public AdapterPB (ArrayList<PermintaanBimbingan> perBim){

        this.perBim = perBim;
    }

    @NonNull
    @Override
    public PBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_permintaanbimbingan, parent, false);
        return new PBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PBViewHolder holder, int position) {

        PermintaanBimbingan pb = perBim.get(position);
        holder.namaPB.setText(pb.getNama());
        holder.nimPB.setText(pb.getNim());
        holder.imageProfilPB.setImageResource(R.drawable.profil);

    }

    @Override
    public int getItemCount() {
        return perBim.size();
    }


    public class PBViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageProfilPB;
        public TextView namaPB, nimPB;

        public PBViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProfilPB = itemView.findViewById(R.id.imageViewPB);
            namaPB = itemView.findViewById(R.id.textViewPB);
            nimPB = itemView.findViewById(R.id.textView2PB);

        }
    }
}
