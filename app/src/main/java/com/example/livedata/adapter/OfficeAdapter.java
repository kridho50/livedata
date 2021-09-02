package com.example.livedata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livedata.R;
import com.example.livedata.models.Office;

import java.util.ArrayList;
import java.util.List;

public class OfficeAdapter extends RecyclerView.Adapter<OfficeAdapter.ViewHolder> {

    private Context context;
    List<Office> officeList = new ArrayList<>();

    public OfficeAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Office> officeList) {
        this.officeList = officeList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_makanan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Office office = officeList.get(position);
        holder.namaMakanan.setText(office.getNamaMakanan());
        holder.beratMakanan.setText(office.getBeratMakanan());

    }

    @Override
    public int getItemCount() {
        return officeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaMakanan, beratMakanan;
         ViewHolder(View itemView) {
            super(itemView);
            namaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            beratMakanan = itemView.findViewById(R.id.tvBerat);

        }
    }
}
