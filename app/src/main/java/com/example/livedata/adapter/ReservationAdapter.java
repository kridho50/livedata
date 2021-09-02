package com.example.livedata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.livedata.R;
import com.example.livedata.models.Office;

import java.util.ArrayList;
import java.util.List;

public class ReservationAdapter extends ArrayAdapter<String> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    List<Office> reservationList = new ArrayList<>();
    private final int resource;

    public ReservationAdapter(@NonNull Context context, int resource, List items) {
        super(context, resource, 0, items);
        this.context = context;
        this.resource = resource;
        this.reservationList = items;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = layoutInflater.inflate(resource, parent, false);

        TextView tvOfficeName = view.findViewById(R.id.tv_name_office);
        TextView tvSizeQouta = view.findViewById(R.id.tv_size_qouta);
//      TextView tvUsedQouta =  view.findViewById(R.id.tv_used_qouta);

        Office offerData = reservationList.get(position);

        tvOfficeName.setText(offerData.getNamaMakanan());
        tvSizeQouta.setText(offerData.getBeratMakanan());

        return view;
    }
}
