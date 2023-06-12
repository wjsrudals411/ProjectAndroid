package com.sample.projectandroidapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class TestInsertActivity extends AppCompatActivity {

    private EditText et_date, et_hospital, et_note;
    private Button btn_select_date, btn_register, btn_back;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testinsert);

        et_date = findViewById(R.id.et_date);
        et_hospital = findViewById(R.id.et_hospital);
        et_note = findViewById(R.id.et_note);
        btn_select_date = findViewById(R.id.btn_select_date);
        btn_register = findViewById(R.id.btn_register);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = et_date.getText().toString();
                String hospital = et_hospital.getText().toString();
                String note = et_note.getText().toString();

                // Send data to the server
                sendTestDataToServer(date, hospital, note);
            }
        });
    }

    private void showDatePickerDialog() {
        // Get current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Create a new DatePickerDialog instance
        DatePickerDialog datePickerDialog = new DatePickerDialog(TestInsertActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Update the EditText with the selected date
                        et_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }

    private void sendTestDataToServer(String date, String hospital, String note) {
        // Create a new response listener
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TestInsertActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        // Create a new TestInsertRequest instance and add it to the request queue
        TestInsertRequest testInsertRequest = new TestInsertRequest(date, hospital, note, responseListener);
        RequestQueue queue = Volley.newRequestQueue(TestInsertActivity.this);
        queue.add(testInsertRequest);
    }
}
