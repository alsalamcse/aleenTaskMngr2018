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
    private int mYear, mMonth, mDay;

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
                dataHadler();


            }
        });


            }

    private void dataHadler()
    {
        boolean isok=true;
        String title=etTitle.getText().toString();
        String task=etTask.getText().toString();
        String importent=tvImportent.getText().toString();
        String necessary=tvNecessary.getText().toString();
        int sImportent=skbrImportent.getProgress();
        int snecessary=skbrNecessary.getProgress();
        //if (title.length()<0||)



    }

    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            etDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


}
