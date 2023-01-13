package com.example.thejepits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thejepits.room.Akun;
import com.example.thejepits.room.AkunDao;
import com.example.thejepits.room.AppDatabase;
import com.example.thejepits.room.RecoveryDatabase;

public class ProfileActivity extends AppCompatActivity {

    ImageButton btnBacktoHome;
    TextView tvEmail;

    AkunDao db;
    RecoveryDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBacktoHome = findViewById(R.id.btnBacktoHome);
        tvEmail = findViewById(R.id.tvEmail);

        btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(backtohome);
            }
        });
    }
}