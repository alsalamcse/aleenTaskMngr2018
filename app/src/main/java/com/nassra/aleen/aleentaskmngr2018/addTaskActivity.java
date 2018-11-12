package com.nassra.aleen.aleentaskmngr2018;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nassra.aleen.aleentaskmngr2018.data.MyTask;

import java.util.Calendar;
import java.util.Date;

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

    private void dataHadler() {
        boolean isok = true;
        String title = etTitle.getText().toString();
        String task = etTask.getText().toString();
        String date=etDate.getText().toString();

        String importent = tvImportent.getText().toString();
        String necessary = tvNecessary.getText().toString();
        int sImportent = skbrImportent.getProgress();
        int snecessary = skbrNecessary.getProgress();
        if (title.length() == 0) {
            etTitle.setError("you have to write a title ");
            isok=false;


        }
        if (task.length()==0){
            etTask.setError("yo have to write a task");
            isok=false;
        }
        if (isok)
        {
            MyTask task1=new MyTask();
            task1.setCreatDate(new Date());
            task1.setDueDate(new Date(date));
            task1.setTitle(title);
            task1.setTesk(task);
            task1.setImportent(sImportent);
            task1.setNexessary(snecessary);
            FirebaseAuth auth=FirebaseAuth.getInstance();
            task1.setOwner(auth.getCurrentUser().getEmail());
            DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
            String key=reference.child("my taskd").push().getKey();
            task1.setKey(key);
            reference.child("my tasks").child(key).setValue(task1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task1) {
                    if (task1.isSuccessful()){
                        Toast.makeText(addTaskActivity.this, "add successed", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(addTaskActivity.this, "add failed"+task1.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
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
