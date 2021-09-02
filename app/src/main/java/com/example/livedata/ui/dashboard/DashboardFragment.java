package com.example.livedata.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.livedata.R;
import com.example.livedata.adapter.ReservationAdapter;
import com.example.livedata.models.Office;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private Spinner spinnerOfferType;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        Button button = root.findViewById(R.id.btn_push);
        spinnerOfferType = root.findViewById(R.id.spinnerOfferType);

        dashboardViewModel.getOffices().observe(getViewLifecycleOwner(), new Observer<List<Office>>() {
            @Override
            public void onChanged(List<Office> offices) {
                getListOffice(offices);
            }
        });

        dashboardViewModel.getData().observe(getViewLifecycleOwner(), new Observer<Office>() {
            @Override
            public void onChanged(Office office) {
                textView.setText(office.getNamaMakanan());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardViewModel.refresh();
            }
        });

        return root;
    }

    public void getListOffice(final List<Office> offices) {
        ReservationAdapter adapter = new ReservationAdapter(getContext(),
                R.layout.item_view_zona, offices);
        spinnerOfferType.setAdapter(adapter);
        spinnerOfferType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                dashboardViewModel.setSelectedOffice(offices.get(pos));
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}