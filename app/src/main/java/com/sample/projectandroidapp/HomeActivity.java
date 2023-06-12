package com.sample.projectandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button homeButton, diaryButton, testButton, plusbtn;

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
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(HomeActivity.this, TestActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(HomeActivity.this,  MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu4:
                Intent intent4 = new Intent(HomeActivity.this,  PetListActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu5:
                Intent intent5 = new Intent(HomeActivity.this,  TestListActivity.class);
                startActivity(intent5);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);




        homeButton = findViewById(R.id.home);
        diaryButton = findViewById(R.id.diary);
        testButton = findViewById(R.id.test);
        plusbtn = findViewById(R.id.plusbtn);




        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HomeActivity
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        diaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to DiaryActivity
                Intent intent = new Intent(HomeActivity.this, DiaryActivity.class);
                startActivity(intent);
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to TestActivity
                Intent intent = new Intent(HomeActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PetInsertActivity.class);
                startActivity(intent);
            }
        });
    }


}
