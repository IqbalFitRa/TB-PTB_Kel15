package com.kelompok_15.tb_ptb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.JadwalMahasiswaSeminar;

import java.util.ArrayList;

public class AdapterJadwal2 extends RecyclerView.Adapter<AdapterJadwal2.JadwalViewHolder>{

    ArrayList<JadwalMahasiswaSeminar> ListJadwal2 = new ArrayList<>();
    ItemJadwalClickListener listener2;

    public AdapterJadwal2(ArrayList<JadwalMahasiswaSeminar> listJadwal2) {
        ListJadwal2 = listJadwal2;
    }

    public void setListener(ItemJadwalClickListener listener2) {
        this.listener2 = listener2;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jadwal_seminar_dan_sidang, parent, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        JadwalMahasiswaSeminar jadwal2 = ListJadwal2.get(position);
        holder.imageMahasiswa.setImageResource(R.drawable.profil);
        holder.namaMahasiswa.setText(jadwal2.getNama_mahasiswa());
        holder.nimMahasiswa.setText(jadwal2.getNim());
        holder.tglSidang.setText(jadwal2.getTanggal());
    }

    @Override
    public int getItemCount() {
        return ListJadwal2.size();
    }

    public interface ItemJadwalClickListener{
        void onItemJadwalClick(JadwalMahasiswaSeminar jadwal2);
    }

    public class JadwalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageMahasiswa;
        public TextView namaMahasiswa, nimMahasiswa, tglSidang;

        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMahasiswa = itemView.findViewById(R.id.imageMahasiswa);
            namaMahasiswa = itemView.findViewById(R.id.namaMahasiswa);
            nimMahasiswa = itemView.findViewById(R.id.nimMahasiswa);
            tglSidang = itemView.findViewById(R.id.tglSidang);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            JadwalMahasiswaSeminar jadwal2 = ListJadwal2.get(getAdapterPosition());
            listener2.onItemJadwalClick(jadwal2);
        }
    }
}
