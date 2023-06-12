package com.sample.projectandroidapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PetInsertRequest extends StringRequest {

    // 서버 URL 설정 (php 파일 연동)
    private static final String URL = "http://wjsrudals411.dothome.co.kr/Insert.php";
    private final Map<String, String> parameters;

    public PetInsertRequest(String name, String age, String type, String gender, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        // 요청 파라미터 설정
        parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("age", age);
        parameters.put("type", type);
        parameters.put("gender", gender);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
