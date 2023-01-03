package com.kelompok_15.tb_ptb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok_15.tb_ptb.R;
import com.kelompok_15.tb_ptb.models.Logbook;
import com.kelompok_15.tb_ptb.models.Mahasiswa;
import com.kelompok_15.tb_ptb.retrofit.ListLogbook;
import com.kelompok_15.tb_ptb.retrofit.LogbooksItem;

import java.util.ArrayList;
import java.util.List;

public class AdapterLogbook extends RecyclerView.Adapter<AdapterLogbook.LogbookViewHolder> {
    private List<LogbooksItem> itemList = new ArrayList<>();
    private ClickedItem clickedItem;

    public AdapterLogbook(ClickedItem clickedItem){
        this.clickedItem = clickedItem;
    }

    public AdapterLogbook() {

    }

    public void setItemList(List<LogbooksItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    /*ArrayList<Logbook> listLogbook = new ArrayList<>();
    AdapterLogbook.ItemLogbookClickListener listenerIL;

    public AdapterLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public AdapterLogbook(ArrayList<Logbook> listLogbook, ItemLogbookClickListener listenerIL) {
        this.listLogbook = listLogbook;
        this.listenerIL = listenerIL;
    }

    public void setListenerIL(ItemLogbookClickListener listenerIL) {

        this.listenerIL = listenerIL;
    }
    */

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_logbook, parent, false);
        return new LogbookViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {
      LogbooksItem logbooks = itemList.get(position);
        holder.agendaLogbook.setText(logbooks.getProgress());
        holder.tanggalLogbook.setText(logbooks.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clickedItem.ClickedLogbook(logbooks);
            }
        });
       /* Logbook logbook = listLogbook.get(position);
        holder.agendaLogbook.setText(logbook.getAgenda());
        holder.tanggalLogbook.setText(logbook.getTanggal());
       */
    }

    public interface ClickedItem{
       public void ClickedLogbook(LogbooksItem logbooks);
    }

    @Override
    public int getItemCount() {
        return itemList.size();

    }



    /*public interface ItemLogbookClickListener {
        void onItemLogbookClick(Logbook logbook);
    }*/

    public class LogbookViewHolder extends RecyclerView.ViewHolder {

        public TextView agendaLogbook;
        public TextView tanggalLogbook;


        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);

            agendaLogbook = itemView.findViewById(R.id.agenda_logbook);
            tanggalLogbook = itemView.findViewById(R.id.tanggal_logbook);

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Logbook logbook = listLogbook.get(getBindingAdapterPosition());
                    listenerIL.onItemLogbookClick(logbook);
                }
            });
            */
        }
    }
}
