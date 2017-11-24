package com.github.abdurahmanovart.itunesfinder.view;

import com.github.abdurahmanovart.itunesfinder.bean.TracksResponse;

/**
 * Created by arturx on 20.11.17.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setToolbar();

    void showSearchView();

    void clearSearchViewFocus();

    void showNoConnectionError();

    void showServiceUnavailableError();

    void showTracksFragment(TracksResponse response);

    void setProgressColor();

}
