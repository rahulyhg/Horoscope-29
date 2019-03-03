package com.example.horoscope.base_model.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {
    private final static String BASE_URL = "http://sandipbgt.com/theastrologer/";
    private static final int TIMEOUT_IN_SECOND = 2;

    private static RestApi sRestApi;
    private static IEndPoint sEndPoint;

    private RestApi() {
        OkHttpClient okHttpClient = buildOkHttpClient();
        Retrofit sRetrofit = buildRetrofit(okHttpClient);

        sEndPoint = sRetrofit.create(IEndPoint.class);
    }

    public static synchronized RestApi getInstance() {
        if (sRestApi == null) {
            sRestApi = new RestApi();
        }
        return sRestApi;
    }

    public IEndPoint getEndPoint() {
        return sEndPoint;
    }

    private OkHttpClient buildOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
                .build();
    }

    private Retrofit buildRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
