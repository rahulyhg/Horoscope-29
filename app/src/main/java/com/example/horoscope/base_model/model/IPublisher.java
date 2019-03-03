package com.example.horoscope.base_model.model;

import io.reactivex.Observable;

public interface IPublisher {

    Observable<Zodiac> getTodayHoroscope(String sunSign);

    Observable<Zodiac> getTomorrowHoroscope(String sunSign);

    Observable<Zodiac> getYesterdayHoroscope(String sunSign);

}
