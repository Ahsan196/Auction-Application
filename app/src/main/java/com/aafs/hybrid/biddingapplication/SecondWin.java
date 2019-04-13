package com.aafs.hybrid.biddingapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SecondWin extends AppCompatActivity {
    private Button sign_up;

    private EditText UserName;
    private EditText UserContactNo;
    private EditText UserAddress;
    private EditText UserEmail;
    private EditText UserPassword;

    //private StorageReference storageReference;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


   // private  FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_win);
        //storageReference= FirebaseStorage.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");


        sign_up=(Button) findViewById(R.id.SignUp);
        UserName=(EditText) findViewById(R.id.name);
        UserContactNo=(EditText) findViewById(R.id.contactNo);
        UserAddress=(EditText) findViewById(R.id.address);
        UserEmail=(EditText) findViewById(R.id.UsId);
        UserPassword=(EditText) findViewById(R.id.Password);


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    private void register() {
        final String user_name=UserName.getText().toString().trim();
        final String user_contact_no=UserContactNo.getText().toString().trim();
        final String user_address=UserAddress.getText().toString().trim();
        final String useremail=UserEmail.getText().toString().trim();
        String userpassword=UserPassword.getText().toString().trim();

        if(!TextUtils.isEmpty(useremail) && !TextUtils.isEmpty(userpassword))
        {
                        System.out.println("hellooo");
        firebaseAuth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful())
            {
                             System.out.println("hellgagagaooo");
                String User_Id=firebaseAuth.getInstance().getUid();
                DatabaseReference current_user_db=databaseReference.child(User_Id);
                current_user_db.child("Name").setValue(user_name);
                current_user_db.child("Contact No").setValue(user_contact_no);
                current_user_db.child("Address").setValue(user_address);
                current_user_db.child("Email").setValue(useremail);
                sendEmailVerification();
            }
            }
        });

        }
    }
    private void sendEmailVerification() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        System.out.println("h222");
        if (user!=null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SecondWin.this,"Check your Email for verification",Toast.LENGTH_SHORT).show();
//                        FirebaseAuth.getInstance().signOut();
                    }
                }
            });
        }
    }
}
