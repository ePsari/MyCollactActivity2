package com.example.putriyusandayani.mycollactactivity2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ArrayList<Jadwal> list_jadwal = new ArrayList<Jadwal>();
    TextView tvhari;
    ListView listviewJadwal ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number
        int position = getArguments().getInt("position");

        String[] menus = getResources().getStringArray(R.array.menus);

        // Creating view corresponding to the fragment
        View v = inflater.inflate(R.layout.jadwalfragment_layout, container, false);
        listviewJadwal = (ListView) v.findViewById(R.id.listViewJadwal);
        // Updating the action bar title
        getActivity().getActionBar().setTitle(menus[position]);
        initData();
        showJadwal(menus[position]);
        return v;
    }

    public void showJadwal(String hari) {
        Log.d("TAGS","hari:"+hari);
        //	tvhari.setText("Hari " + hari);
        ArrayList<Jadwal> jadwal_terpilih = new ArrayList<Jadwal>();
        for (int i = 0; i < list_jadwal.size(); i++) {
            Jadwal jadwal = list_jadwal.get(i);
            if (jadwal.hari.equals(hari)) {
                jadwal_terpilih.add(jadwal);
            }
        }

        AdapterJadwal adapterjadwal = new AdapterJadwal(getActivity(), 0,
                jadwal_terpilih);
        listviewJadwal.setAdapter(adapterjadwal);

    }

    public void initData() {
        list_jadwal.add(new Jadwal("Senin","08:00-10:00","Matematika"));
        list_jadwal.add(new Jadwal("Senin","10:00-12:00","Agama Islam"));
        list_jadwal.add(new Jadwal("Senin","12:00-13:00","Istirahat"));
        list_jadwal.add(new Jadwal("Senin","13:00-15:00","Fisika"));
        list_jadwal.add(new Jadwal("Selasa","08:00-10:00","Bahasa Indonesia"));
        list_jadwal.add(new Jadwal("Selasa","10:00-12:00","Kimia"));
        list_jadwal.add(new Jadwal("Selasa","12:00-13:00","Istirahat"));
        list_jadwal.add(new Jadwal("Selasa","13:00-15:00","Biologi"));
        list_jadwal.add(new Jadwal("Rabu","08:00-10:00","Matematika"));
        list_jadwal.add(new Jadwal("Rabu","10:00-12:00","Seni Rupa"));
        list_jadwal.add(new Jadwal("Rabu","12:00-13:00","Istirahat"));
        list_jadwal.add(new Jadwal("Rabu","13:00-15:00","Bahasa Inggris"));
        list_jadwal.add(new Jadwal("Kamis","08:00-10:00","Fisika"));
        list_jadwal.add(new Jadwal("Kamis","10:00-12:00","Penjaskes"));
        list_jadwal.add(new Jadwal("Kamis","12:00-13:00","Istirahat"));
        list_jadwal.add(new Jadwal("Kamis","13:00-15:00","Geografi"));
        list_jadwal.add(new Jadwal("Jumat","08:00-10:00","Pemrograman Java"));
        list_jadwal.add(new Jadwal("Jumat","10:00-12:00","Pemrograman Android"));
        list_jadwal.add(new Jadwal("Jumat","12:00-13:00","Istirahat"));
        list_jadwal.add(new Jadwal("Jumat","13:00-15:00","Logika Algoritma"));
    }
}
