package com.example.horoscope.base_presenter;

import com.example.horoscope.base_view.IView;

public interface IPresenter<MODEL extends IView> {

    void attachView(MODEL view);

    void viewIsReady();

    void detachView();

    void destroyView();
}
