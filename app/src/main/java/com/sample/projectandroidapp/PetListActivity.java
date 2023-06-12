package com.sample.projectandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> petList;


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
                Intent intent = new Intent(PetListActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(PetListActivity.this, TestActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(PetListActivity.this,  MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu4:
                Intent intent4 = new Intent(PetListActivity.this,  PetListActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu5:
                Intent intent5 = new Intent(PetListActivity.this,  TestListActivity.class);
                startActivity(intent5);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petlist);

        listView = findViewById(R.id.list_view);
        petList = new ArrayList<>();

        // 서버에서 펫 리스트 데이터 가져오기
        fetchPetList();

        // 리스트 아이템 클릭 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPet = petList.get(position);

                // DiaryActivity로 이동
                Intent intent = new Intent(PetListActivity.this, DiaryActivity.class);
                intent.putExtra("petName", selectedPet);
                startActivity(intent);
            }
        });

    }

    private void fetchPetList() {


        // 서버 URL 설정 (API 또는 PHP 파일 경로)
        String url = "http://wjsrudals411.dothome.co.kr/PetList.php";


        // Volley를 사용하여 서버에 데이터 요청
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // 서버 응답 처리
                        try {
                            JSONArray petArray = response.getJSONArray("pets");

                            // JSON 데이터 파싱 및 사용
                            for (int i = 0; i < petArray.length(); i++) {
                                JSONObject petObject = petArray.getJSONObject(i);
                                String petName = petObject.getString("name");
                                String petAge = petObject.getString("age");
                                String petType = petObject.getString("type");
                                String petGender = petObject.getString("gender");

                                // 가져온 데이터를 리스트에 추가
                                petList.add(petName + " (" + petAge + ", " + petType + ", " + petGender + ")");
                            }

                            // 리스트 어댑터 설정
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(PetListActivity.this,
                                    android.R.layout.simple_list_item_1, petList);
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 데이터 요청 실패 시 처리할 로직 작성
                        error.printStackTrace();
                        Toast.makeText(PetListActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();
                    }
                });

        // RequestQueue에 요청 추가
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}

