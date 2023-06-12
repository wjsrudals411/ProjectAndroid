package com.sample.projectandroidapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    private Button homeButton, diaryButton, testButton, plusbtn;
    private ImageButton imageButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Intent intent = new Intent(TestActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(TestActivity.this, TestActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(TestActivity.this,  MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu4:
                Intent intent4 = new Intent(TestActivity.this,  PetListActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu5:
                Intent intent5 = new Intent(TestActivity.this,  TestListActivity.class);
                startActivity(intent5);
                break;

        }
        return super.onOptionsItemSelected(item);
    }




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        homeButton = findViewById(R.id.home);
        diaryButton = findViewById(R.id.diary);
        testButton = findViewById(R.id.test);
        plusbtn = findViewById(R.id.plusbtn);

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HomeActivity
                Intent intent = new Intent(TestActivity.this, TestInsertActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HomeActivity
                Intent intent = new Intent(TestActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        diaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to DiaryActivity
                Intent intent = new Intent(TestActivity.this, DiaryActivity.class);
                startActivity(intent);
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to TestActivity
                Intent intent = new Intent(TestActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });


    }
}
