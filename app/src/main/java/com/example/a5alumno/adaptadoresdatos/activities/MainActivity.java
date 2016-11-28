package com.example.a5alumno.adaptadoresdatos.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a5alumno.adaptadoresdatos.R;
import com.example.a5alumno.adaptadoresdatos.data.MyContentProvider;
import com.example.a5alumno.adaptadoresdatos.data.MyDBHelper;
import com.example.a5alumno.adaptadoresdatos.data.ParamsDB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private EditText mEdtName;
    private EditText mEdtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mEdtName = (EditText) findViewById( R.id.edtTxtName);
        this.mEdtAge = (EditText) findViewById( R.id.edtTxtAge);

        final Button btnQueryDb = (Button) findViewById(R.id.btn_query_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnAddDb = (Button) findViewById(R.id.btn_add_db);
        btnQueryDb.setOnClickListener(this);
        final Button btnDeleteDb = (Button) findViewById(R.id.btn_delete_db);
        btnQueryDb.setOnClickListener(this);

        MyDBHelper myDBHelper = new MyDBHelper(this);
        myDBHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_query_db){

            Cursor queryCursor = getContentResolver().query(MyContentProvider.CONTENT_URI, null, null, null, null);
            StringBuilder dbContent = new StringBuilder();
            while(queryCursor.moveToNext()){
                dbContent.append("\n");
                dbContent.append(queryCursor.getString(0));
                dbContent.append(" ");
                dbContent.append(queryCursor.getInt(1));
            }
            Toast.makeText(this, dbContent.toString(), Toast.LENGTH_LONG).show();
            queryCursor.close();

        }else if(view.getId() == R.id.btn_add_db){
            ContentValues insertValues = new ContentValues();
            insertValues.put(ParamsDB.STUDENT_NAME, this.mEdtName.getText().toString());
            insertValues.put(ParamsDB.STUDENT_AGE, this.mEdtAge.getText().toString());

            Uri insertUri = getContentResolver().insert(MyContentProvider.CONTENT_URI, insertValues);



        }else if(view.getId() == R.id.btn_delete_db){

        }
    }
}
