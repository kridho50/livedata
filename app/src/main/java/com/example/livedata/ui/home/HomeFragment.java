package com.example.livedata.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.livedata.R;
import com.example.livedata.adapter.OfficeAdapter;
import com.example.livedata.models.Office;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    OfficeAdapter officeAdapter;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView rvList = root.findViewById(R.id.rvMakanan);
        final SwipeRefreshLayout swipeRefreshLayout = root.findViewById(R.id.swapRefresh);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(layoutManager);
        officeAdapter = new OfficeAdapter(getContext());
        rvList.setAdapter(officeAdapter);

        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_green_dark, android.R.color.holo_blue_dark,
                android.R.color.holo_orange_dark, android.R.color.holo_red_dark);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                homeViewModel.getDataMakanan();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        homeViewModel.getOffices().observe(getViewLifecycleOwner(), new Observer<List<Office>>() {
            @Override
            public void onChanged(List<Office> offices) {
                setDataMakanan(offices);
            }
        });

        return root;
    }

    public void setDataMakanan(List<Office> offices) {
        officeAdapter.setData(offices);
    }
}