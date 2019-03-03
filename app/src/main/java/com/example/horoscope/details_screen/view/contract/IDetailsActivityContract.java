package com.example.horoscope.details_screen.view.contract;

import com.example.horoscope.base_view.IView;

public interface IDetailsActivityContract {

    interface Presenter {

        void loadHoroscope(String sunSign, String tabId);

    }

    interface View extends IView {

        void updateTodayUi(String text);

        void updateTomorrowUi(String text);

        void updateYesterdayUi(String text);

    }
}
