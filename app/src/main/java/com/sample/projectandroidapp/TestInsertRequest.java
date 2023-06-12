package com.sample.projectandroidapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TestInsertRequest extends StringRequest {

    // 서버 URL 설정 (php 파일 연동)
    final static private String URL = "http://wjsrudals411.dothome.co.kr/TestInsert.php";
    private Map<String, String> map;

    public TestInsertRequest(String date, String hospital, String note, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("date", date);
        map.put("hospital", hospital);
        map.put("note", note);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
