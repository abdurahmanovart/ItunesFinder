package com.github.abdurahmanovart.itunesfinder.view;

/**
 * Created by arturx on 25.11.17.
 */

public interface PlayerView {

    void setSeekBarMax(int max);

    void setSeekBarProgress(int progress);

    void setPlayButtonEnabled(boolean enabled);

    void setPauseButtonEnabled(boolean enabled);
}