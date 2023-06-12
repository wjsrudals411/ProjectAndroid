package com.sample.projectandroidapp;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class KaKaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KakaoSdk.init(this, "0d4f4b6b7c032d592819a004104ef3d5");
    }
}
