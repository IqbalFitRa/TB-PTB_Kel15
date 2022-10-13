package com.kelompok_15.tb_ptb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.JadwalSeminardanSidang;

import java.util.ArrayList;

public class AdapterJadwal extends RecyclerView.Adapter<AdapterJadwal.JadwalViewHolder>{

    ArrayList<JadwalSeminardanSidang> ListJadwal = new ArrayList<>();
    ItemJadwalClickListener listener;

    public AdapterJadwal(ArrayList<JadwalSeminardanSidang> listJadwal) {
        ListJadwal = listJadwal;
    }


    public void setListener(ItemJadwalClickListener listener) {
        this.listener = listener;
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
        JadwalSeminardanSidang jadwal = ListJadwal.get(position);
        holder.imageMahasiswa.setImageResource(R.drawable.profil);
        holder.namaMahasiswa.setText(jadwal.getNama_mahasiswa());
        holder.nimMahasiswa.setText(jadwal.getNim());
        holder.tglSidang.setText(jadwal.getTanggal());
    }

    @Override
    public int getItemCount() {
        return ListJadwal.size();
    }

    public interface ItemJadwalClickListener{
        void onItemJadwalClick(JadwalSeminardanSidang jadwal);
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
            JadwalSeminardanSidang jadwal = ListJadwal.get(getAdapterPosition());
            listener.onItemJadwalClick(jadwal);
        }
    }
}
