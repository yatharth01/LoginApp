package com.example.yatharthmishra.loginapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.concurrent.Executor;


public class SecondFragment extends Fragment implements OnClickListener {
    public EditText editTextemail;
    public EditText editTextpersonName;
    public EditText editTextpassword;
    Button signupbutton;
    private FirebaseAuth firebaseAuth;

    ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     progressDialog = new ProgressDialog(getActivity());



    }


   public void UserSignup(){

       String email = editTextemail.getText().toString().trim();
       String password = editTextpassword.getText().toString().trim();
       String Name = editTextpersonName.getText().toString().trim();


        if(TextUtils.isEmpty(Name))
        {
            Toast.makeText(getActivity(),"Name can't be Blank",Toast.LENGTH_LONG).show();
            return;
        }



        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(getActivity(),"Email can't be Blank",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(getActivity(),"Choose a Password",Toast.LENGTH_LONG).show();
            return;
        }
       if (password.length() < 6) {
           Toast.makeText(getActivity(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
           return;
       }

      progressDialog.setMessage("Registering... Please wait>>");
        progressDialog.show();
      firebaseAuth.createUserWithEmailAndPassword(email,password);

       Task<AuthResult> task = FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password);
       task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()) {
                   // Task completed successfully
                   progressDialog.dismiss();
                  // AuthResult result = task.getResult();
                   Toast.makeText(getActivity(),"You are successfully registered!!",Toast.LENGTH_SHORT).show();
               } else {
                   // Task failed with an exception
                   //Exception exception = task.getException();
                   progressDialog.dismiss();
                   Toast.makeText(getActivity(),"Sorry can't register ... try again...",Toast.LENGTH_SHORT).show();
               }
           }
       });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
         firebaseAuth = FirebaseAuth.getInstance();

         View rootview = inflater.inflate(R.layout.signup, container, false);

          signupbutton = rootview.findViewById(R.id.button1);

        editTextemail = rootview.findViewById(R.id.emailID);
        editTextpersonName = rootview.findViewById(R.id.personName);
        editTextpassword= rootview.findViewById(R.id.password);


        View.OnClickListener mListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UserSignup();
            }
        };
        signupbutton.setOnClickListener(mListener1);



        return rootview;

    }

    @Override
    public void onClick(View view) {

    }
}
