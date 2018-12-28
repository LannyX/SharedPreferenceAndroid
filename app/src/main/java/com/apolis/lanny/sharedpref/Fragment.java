package com.apolis.lanny.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment extends android.support.v4.app.Fragment {

    TextView tv, tv2, tv3, tv4, tv5, tv6;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container,false);
        tv = v.findViewById(R.id.tvResult);
        tv2 = v.findViewById(R.id.tvResult2);
        tv3 = v.findViewById(R.id.tvResult3);
        tv4 = v.findViewById(R.id.tvResult4);
        tv5 = v.findViewById(R.id.tvResult5);
        tv6 = v.findViewById(R.id.tvResult6);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle b = getArguments();
        //String result = b.getString("key");

        ArrayList<String> values = b.getStringArrayList("arrayList");


        SharedPreferences pref = this.getActivity().getSharedPreferences("formPrefs", Context.MODE_PRIVATE);

//        tv.setText(values.get(0));
//        tv2.setText(values.get(1));
//        tv3.setText(values.get(2));
//        tv4.setText(values.get(3));
//        tv5.setText(values.get(4));
//        tv6.setText(values.get(5));

        tv.setText(pref.getString("username", "empty"));
        tv2.setText(pref.getString("password", "empty"));
        tv3.setText(pref.getString("carOrNot", "empty"));
        tv4.setText(pref.getString("Gender", "empty"));
        tv5.setText(pref.getString("country", "empty"));
        tv6.setText(pref.getString("time", "empty"));
    }
}
