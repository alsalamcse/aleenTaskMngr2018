package com.nassra.aleen.aleentaskmngr2018;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logInActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btnSignUp,btnSignIn,btnGoogle,btnFacebook;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnSignIn=findViewById(R.id.btnSignIn);
        btnGoogle=findViewById(R.id.btnGoogle);
        btnFacebook=findViewById(R.id.btnFacebook);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(logInActivity.this,signUpActivity.class);
                startActivity(intent);
            }
        });
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();




    }

    private void dataHandler()
    {
        boolean isok=true;
        String email=etEmail.getText().toString();
        String pass=etPassword.getText().toString();
        if (email.length()<4||email.indexOf('@')<0||email.indexOf('.')<0){
            etEmail.setError("wrong email");
            isok=false;

        }
        if ((pass.length())<8){
            etPassword.setError("wrong password");
            isok=false;
        }
        if (isok){

        }


    }
    private void signIn (String Email,String pass){
        auth.signInWithEmailAndPassword(Email,pass).addOnCompleteListener(logInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(logInActivity.this, "sign in seccessful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(logInActivity.this,MainTabsActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(logInActivity.this, "", Toast.LENGTH_SHORT).show();

                }

            }



        });
    }
}
