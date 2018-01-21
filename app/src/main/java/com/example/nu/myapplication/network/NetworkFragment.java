package com.example.nu.myapplication.network;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nu.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NetworkFragment extends Fragment {
    CardView net_one;


    public NetworkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_network, container, false);

        net_one = view.findViewById(R.id.net_one);





//        Onclick
        net_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"1",Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
