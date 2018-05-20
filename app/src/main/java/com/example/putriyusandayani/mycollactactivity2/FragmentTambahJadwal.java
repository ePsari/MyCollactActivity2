package com.example.putriyusandayani.mycollactactivity2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTambahJadwal extends Fragment {
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragement_tambah_jadwal, container, false);
        return v;
    }

}
