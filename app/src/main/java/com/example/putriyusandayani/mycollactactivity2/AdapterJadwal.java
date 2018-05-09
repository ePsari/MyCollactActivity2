package com.example.putriyusandayani.mycollactactivity2;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * Created by Putri Yus Andayani on 09/05/2018.
 */

public class AdapterJadwal extends ArrayAdapter<Jadwal> {
    public AdapterJadwal(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
