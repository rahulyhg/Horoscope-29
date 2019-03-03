package com.example.horoscope.base_presenter;


import com.example.horoscope.base_model.model.Model;
import com.example.horoscope.base_view.IView;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<MODEL extends IView> implements IPresenter<MODEL> {

    private MODEL view;
    protected Model mModel;
    protected CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(MODEL view) {
        this.view = view;
        mModel = new Model();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        view = null;
        mModel = null;
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void destroyView() {

    }

    protected MODEL getView() {
        return view;
    }
}
