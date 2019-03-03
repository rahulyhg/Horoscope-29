package com.example.horoscope.base_model.network;

import com.example.horoscope.base_model.model.Zodiac;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IEndPoint {

    @GET("api/horoscope/{sunsign}/today")
    Observable<Zodiac> getTodayHoroscope(@Path("sunsign") String sunSign);

    @GET("api/horoscope/{sunsign}/tomorrow")
    Observable<Zodiac> getTomorrowHoroscope(@Path("sunsign") String sunSign);

    @GET("api/horoscope/{sunsign}/yesterday")
    Observable<Zodiac> getYesterdayHoroscope(@Path("sunsign") String sunSign);
}
