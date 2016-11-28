package com.example.a5alumno.adaptadoresdatos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a5alumno.adaptadoresdatos.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnQueryDb = (Button) findViewById(R.id.btn_query_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnAddDb = (Button) findViewById(R.id.btn_add_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnDeleteDb = (Button) findViewById(R.id.btn_delete_db);
        btnQueryDb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
