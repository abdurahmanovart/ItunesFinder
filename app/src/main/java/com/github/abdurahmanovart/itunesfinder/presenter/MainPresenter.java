package com.github.abdurahmanovart.itunesfinder.presenter;

import com.github.abdurahmanovart.itunesfinder.bean.TracksResponse;

/**
 * Created by arturx on 20.11.17.
 */

public interface MainPresenter {

    void showProgress();

    void hideProgress();

    void clearSearchViewFocus();

    void showNoConnectionError();

    void showServiceUnavailableError();

    void showTracksFragment(TracksResponse response);

    void onCreate();

    boolean onQueryTextSubmit(String query);


}
