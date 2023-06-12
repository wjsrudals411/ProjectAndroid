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




public class TestListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> testResults;


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
                Intent intent = new Intent(TestListActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(TestListActivity.this, TestActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(TestListActivity.this,  MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu4:
                Intent intent4 = new Intent(TestListActivity.this,  PetListActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu5:
                Intent intent5 = new Intent(TestListActivity.this,  TestListActivity.class);
                startActivity(intent5);
                break;

        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlist);

        listView = findViewById(R.id.list_view);
        testResults = new ArrayList<>();

        // 서버에서 검사 결과 데이터 가져오기
        fetchTestResults();

        // 리스트 아이템 클릭 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedResult = testResults.get(position);

                // 선택한 검사 결과에 대한 동작 구현
                // 예를 들어, 세부 정보를 보여주는 액티비티로 이동할 수 있습니다.

            }
        });
    }

    private void fetchTestResults() {
        // 서버 URL 설정 (API 또는 PHP 파일 경로)
        String url = "http://wjsrudals411.dothome.co.kr/TestList.php";

        // Volley를 사용하여 서버에 데이터 요청
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // 서버 응답 처리
                        try {
                            JSONArray resultsArray = response.getJSONArray("results");

                            // JSON 데이터 파싱 및 사용
                            for (int i = 0; i < resultsArray.length(); i++) {
                                JSONObject resultObject = resultsArray.getJSONObject(i);
                                String date = resultObject.getString("date");
                                String hospital = resultObject.getString("hospital");
                                String note = resultObject.getString("note");

                                // 가져온 데이터를 리스트에 추가
                                testResults.add("날짜: " + date + " ,병원명: " + hospital + ", 노트: " + note);
                            }

                            // 리스트 어댑터 설정
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(TestListActivity.this,
                                    android.R.layout.simple_list_item_1, testResults);
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
                        Toast.makeText(TestListActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();
                    }
                });

        // RequestQueue에 요청 추가
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
