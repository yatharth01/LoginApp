package com.example.yatharthmishra.loginapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.google.android.gms.gcm.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class FirstFragment extends Fragment implements View.OnClickListener {
   private EditText email;
   private EditText password;
  ProgressDialog progressDialog;
   FirebaseAuth firebaseAuth2;




    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());



    }

    public void UserLogin(){
        String emailID;
        String pass;
        emailID = email.getText().toString().trim();
        pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(emailID))
        {
            Toast.makeText(getActivity(),"Email can't be Blank!",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass))
        {
            Toast.makeText(getActivity(),"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Signing In....");
        progressDialog.show();
        firebaseAuth2.signInWithEmailAndPassword(emailID,pass);
        com.google.android.gms.tasks.Task<AuthResult> task = FirebaseAuth.getInstance().signInWithEmailAndPassword(emailID,pass);
        task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Task completed successfully
                    progressDialog.dismiss();
                    // AuthResult result = task.getResult();
                    Toast.makeText(getActivity(),"You have successfully Signed in!!",Toast.LENGTH_SHORT).show();
                } else {
                    // Task failed with an exception
                    //Exception exception = task.getException();
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(),"Sorry can't Sign  ... Check your password and try again...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


// Inflate the layout for this fragment
        firebaseAuth2 = FirebaseAuth.getInstance();

        View view2 = inflater.inflate(R.layout.layout,container,false);



        email = view2.findViewById(R.id.email);
        password = view2.findViewById(R.id.pass);
        Button button = view2.findViewById(R.id.login);




        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserLogin();
            }
        };
        button.setOnClickListener(mListener);
        return view2;
    }

    @Override
    public void onClick(View view) {

    }
}


