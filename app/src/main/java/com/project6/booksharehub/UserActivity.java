package com.project6.booksharehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class UserActivity extends AppCompatActivity {

    Button btnLogOut;
    TextView userDetails;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userDetails = findViewById(R.id.userDetails);
        auth = FirebaseAuth.getInstance();
        btnLogOut = findViewById(R.id.btnLogOut);
        user = auth.getCurrentUser();

        if(user == null){
            startActivity(new Intent(UserActivity.this, LoginActivity.class));
            finish();
        } else {
            userDetails.setText(user.getEmail());
        }

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserActivity.this, LoginActivity.class));
                finish();
            }
        });


    }
}