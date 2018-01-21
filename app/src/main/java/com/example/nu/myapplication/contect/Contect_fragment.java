package com.example.nu.myapplication.contect;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nu.myapplication.R;
import com.example.nu.myapplication.webview.Web_med_Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class Contect_fragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    TextView website;



    public Contect_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_connect, container, false);
        website = view.findViewById(R.id.text_web1);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.med.nu.ac.th/"));
                startActivity(intent);
//                Web_med_Fragment web_med_fragment = new Web_med_Fragment();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.show,web_med_fragment,web_med_fragment.getTag()).commit();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in med
        LatLng med = new LatLng(16.748900, 100.189409);
        mMap.addMarker(new MarkerOptions().position(med).title("โรงพยาบาลมหาวิทยาลัยนเรศวล"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(med, 17));

    }
}
