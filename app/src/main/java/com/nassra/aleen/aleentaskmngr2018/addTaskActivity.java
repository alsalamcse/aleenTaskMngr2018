package com.nassra.aleen.aleentaskmngr2018;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

public class addTaskActivity extends AppCompatActivity {
    private EditText etTitle,etTask,etDate;
    private TextView tvImportent,tvNecessary;
    private SeekBar skbrImportent,skbrNecessary;
    private Button btnDatePicker,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle=findViewById(R.id.etTitle);
        etTask=findViewById(R.id.etTask);
        etDate=findViewById(R.id.etDate);
        tvImportent=findViewById(R.id.tvImportetn);
        tvNecessary=findViewById(R.id.tvNecessary);
        skbrImportent=findViewById(R.id.skbrImportent);
        skbrNecessary=findViewById(R.id.skbrNecessary);
        btnDatePicker=findViewById(R.id.btnDatePicker);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






            }
        });


    }

}
