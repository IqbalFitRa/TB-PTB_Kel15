package com.kelompok_15.tb_ptb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.Mahasiswa;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter <AdapterMahasiswa.MahasiswaViewHolder>{

    ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

    public AdapterMahasiswa(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }


    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {

        Mahasiswa mahasiswa = listMahasiswa.get(position);
        holder.nama.setText(mahasiswa.getNama());
        holder.nim.setText(mahasiswa.getNim());
        holder.imageProfil.setImageResource(R.drawable.profil);

    }

    @Override
    public int getItemCount() {

        return listMahasiswa.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageProfil;
        public TextView nama, nim;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProfil = itemView.findViewById(R.id.imageViewMahasiswa);
            nama = itemView.findViewById(R.id.textViewMahasiswaList);
            nim = itemView.findViewById(R.id.textView2nimMahasiswaList);
        }
    }
}
