package com.sample.projectandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PetInsertActivity extends AppCompatActivity {

    private EditText et_name, et_age, et_type;
    private RadioGroup radioGroup;
    private Button btn_register, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petinsert);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_type = findViewById(R.id.et_type);
        radioGroup = findViewById(R.id.radioGroup);
        btn_register = findViewById(R.id.btn_register);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PetInsertActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                String type = et_type.getText().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                String gender = "";
                if (selectedId == R.id.radioMale) {
                    gender = "수컷";
                } else if (selectedId == R.id.radioFemale) {
                    gender = "암컷";
                }

                Response.Listener<String> resStringListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //회원가입 성공시
                            if (success) {

                                Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(PetInsertActivity.this, HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

            PetInsertRequest petInsertRequest = new PetInsertRequest(name, age,  type, gender, resStringListener );
            RequestQueue queue = Volley.newRequestQueue(PetInsertActivity.this);
            queue.add(petInsertRequest);
            }


        });

    }
}