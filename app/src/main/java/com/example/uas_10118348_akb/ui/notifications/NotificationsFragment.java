//Nim :10118348
//Nama :Muhammad Novel Zalsastian
//Kelas :IF8
//Tanggal Pengerjaan : 11 Agustus 2021

package com.example.uas_10118348_akb.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uas_10118348_akb.R;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);

        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }
}