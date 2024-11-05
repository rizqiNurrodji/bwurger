package com.example.bwurgerp2_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.widget.Button;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btRoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRoti = findViewById(R.id.btRoti);
        btRoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PilihanBahanActivity.class);

                startActivity(intent);
                }
        });
    }
}