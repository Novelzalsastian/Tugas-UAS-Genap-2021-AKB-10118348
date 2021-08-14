//Nim :10118348
//Nama :Muhammad Novel Zalsastian
//Kelas :IF8
//Tanggal Pengerjaan : 11 Agustus 2021

package com.example.uas_10118348_akb.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uas_10118348_akb.R;

public class DashboardFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
}