package com.kelompok_15.tb_ptb.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.Mahasiswa;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ThesesItem;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter <AdapterMahasiswa.MahasiswaViewHolder>{

    private ArrayList<ThesesItem> listMahasiswa = new ArrayList<>();

    public void setListenerIM(ItemMahasiswaClickListener listenerIM) {
        this.listenerIM = listenerIM;
    }

    ItemMahasiswaClickListener listenerIM;

    public void setListMahasiswa(ArrayList<ThesesItem> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
        notifyDataSetChanged();
    }

    public AdapterMahasiswa() {
        this.listenerIM = listenerIM;

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

        ThesesItem mahasiswa = listMahasiswa.get(position);
        holder.nama.setText(mahasiswa.getStudent().getName());
        holder.nim.setText(mahasiswa.getStudent().getNim());
        holder.imageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listenerIM.onItemMahasiswaClick(mahasiswa);
            }
        });

    }

    @Override
    public int getItemCount() {

        return listMahasiswa.size();
    }

    public interface ItemMahasiswaClickListener{
        void onItemMahasiswaClick(ThesesItem mahasiswa);
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageProfil;
        public TextView nama, nim;


        public MahasiswaViewHolder (@NonNull View itemView) {
            super(itemView);

            imageProfil = itemView.findViewById(R.id.imageViewMahasiswa);
            nama = itemView.findViewById(R.id.textViewMahasiswaList);
            nim = itemView.findViewById(R.id.textView2nimMahasiswaList);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            ThesesItem thesesItem = listMahasiswa.get(getBindingAdapterPosition());
            listenerIM.onItemMahasiswaClick(thesesItem);

        }
        //  @Override
       // public void onClick(View view) {

           // Mahasiswa mahasiswa = listMahasiswa.get(getAdapterPosition());
          //  listenerIM.onItemMahasiswaClick(mahasiswa);
        //}
    }
}
