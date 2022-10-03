package com.kelompok_15.tb_ptb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.Logbook;

import java.util.ArrayList;

public class AdapterLogbook extends RecyclerView.Adapter<AdapterLogbook.LogbookViewHolder> {
    ArrayList<Logbook> listLogbook = new ArrayList<>();

    public AdapterLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_logbook, parent, false);
        return new LogbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {
    Logbook logbook = listLogbook.get(position);
    holder.agendaLogbook.setText(logbook.getAgenda());
    holder.tanggalLogbook.setText(logbook.getTanggal());

    }

    @Override
    public int getItemCount() {
        return listLogbook.size();
    }

    public class LogbookViewHolder extends RecyclerView.ViewHolder {

        public TextView agendaLogbook;
        public TextView tanggalLogbook;


        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);
            agendaLogbook = itemView.findViewById(R.id.agenda_logbook);
            tanggalLogbook = itemView.findViewById(R.id.tanggal_logbook);
        }
    }
}
