package com.github.abdurahmanovart.itunesfinder.presenter;

import com.github.abdurahmanovart.itunesfinder.bean.TracksResponse;
import com.github.abdurahmanovart.itunesfinder.model.MainModel;
import com.github.abdurahmanovart.itunesfinder.view.MainView;

/**
 * Created by arturx on 20.11.17.
 */

public class MainPresenterImpl implements MainPresenter {

    private final MainView mMainView;
    private final MainModel mMainModel;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
        mMainModel = new MainModel(this);
    }

    @Override
    public void showProgress() {
        mMainView.showProgress();
    }

    @Override
    public void hideProgress() {
        mMainView.hideProgress();
    }

    @Override
    public void clearSearchViewFocus() {
        mMainView.clearSearchViewFocus();
    }

    @Override
    public void showNoConnectionError() {
        mMainView.showNoConnectionError();
    }

    @Override
    public void showServiceUnavailableError() {
        mMainView.showServiceUnavailableError();
    }

    @Override
    public void showTracksFragment(TracksResponse response) {
        mMainView.showTracksFragment(response);
    }

    @Override
    public void onCreate() {
        mMainView.setToolbar();
        mMainView.showSearchView();
        mMainView.setProgressColor();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return mMainModel.onQueryTextSubmit(query);
    }
}
