package com.mingnong.xizangphone.runnable.download;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ljd on 3/29/16.
 */
public interface DownloadApi {

    @GET("Version/shouyaodb.db")
    Call<ResponseBody> downloadDb();

    @GET("Version/YunNanApk.apk")
    Call<ResponseBody> downloadApk();
}
