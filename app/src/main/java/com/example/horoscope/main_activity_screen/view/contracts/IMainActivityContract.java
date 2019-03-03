package com.example.horoscope.main_activity_screen.view.contracts;

import com.example.horoscope.base_view.IView;

public interface IMainActivityContract {

    interface Presenter {

        void loadSunSign();

    }

    interface View extends IView {

    }
}
