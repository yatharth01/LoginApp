package com.example.yatharthmishra.loginapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.text.TextUtilsCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;

public class FirstFragment extends Fragment implements View.OnClickListener {







    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment

        View view2 = inflater.inflate(R.layout.layout,container,false);

        Button button = view2.findViewById(R.id.login);


        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        };
        button.setOnClickListener(mListener);
        return view2;
    }

    @Override
    public void onClick(View view) {

    }
}


