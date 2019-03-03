package com.example.horoscope.details_screen.presenter;

import com.example.horoscope.base_model.model.Model;
import com.example.horoscope.base_model.model.Zodiac;
import com.example.horoscope.base_presenter.BasePresenter;
import com.example.horoscope.details_screen.view.contract.IDetailsActivityContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsActivityPresenter extends BasePresenter<IDetailsActivityContract.View>
        implements IDetailsActivityContract.Presenter {

    private Model mModel;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(IDetailsActivityContract.View view) {
        super.attachView(view);
        mModel = new Model();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void viewIsReady() {

    }

    @Override
    public void detachView() {
        super.detachView();

        mModel = null;
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void loadHoroscope(String sunSign, String tabId) {
        Disposable disposable;
        switch (tabId) {
            case "today_tab":
                disposable = mModel.getTodayHoroscope(sunSign)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::updateTodayUi);

                mCompositeDisposable.add(disposable);
                break;
            case "tomorrow_tab":
                disposable = mModel.getTomorrowHoroscope(sunSign)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::updateTomorrowUi);

                mCompositeDisposable.add(disposable);
                break;
            case "yesterday_tab":
                disposable = mModel.getYesterdayHoroscope(sunSign)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::updateYesterdayUi);

                mCompositeDisposable.add(disposable);
                break;
        }


    }

    private void updateTodayUi(Zodiac zodiac) {
        getView().updateTodayUi(zodiac.getHoroscope());
    }

    private void updateTomorrowUi(Zodiac zodiac) {
        getView().updateTomorrowUi(zodiac.getHoroscope());
    }

    private void updateYesterdayUi(Zodiac zodiac) {
        getView().updateYesterdayUi(zodiac.getHoroscope());
    }
}
