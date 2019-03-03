package com.example.horoscope.base_model.model;

import com.example.horoscope.base_model.BaseModel;
import com.example.horoscope.base_model.network.RestApi;

import io.reactivex.Observable;

public class Model extends BaseModel implements IPublisher {

    @Override
    public Observable<Zodiac> getTodayHoroscope(String sunSign) {
        return RestApi.getInstance().getEndPoint().getTodayHoroscope(sunSign);
    }

    @Override
    public Observable<Zodiac> getTomorrowHoroscope(String sunSign) {
        return RestApi.getInstance().getEndPoint().getTomorrowHoroscope(sunSign);
    }

    @Override
    public Observable<Zodiac> getYesterdayHoroscope(String sunSign) {
        return RestApi.getInstance().getEndPoint().getYesterdayHoroscope(sunSign);
    }
}
