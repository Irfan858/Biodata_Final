package com.iktech.latihanlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TambahMhsActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mhs_activity);

        button = (Button) findViewById(R.id.btnTambahData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Data Berhasil Disimpan",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TambahMhsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}