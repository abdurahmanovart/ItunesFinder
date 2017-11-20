package com.github.abdurahmanovart.itunesfinder;

import android.app.Application;

import com.github.abdurahmanovart.itunesfinder.dagger.AppModule;
import com.github.abdurahmanovart.itunesfinder.dagger.DaggerNetComponent;
import com.github.abdurahmanovart.itunesfinder.dagger.NetComponent;
import com.github.abdurahmanovart.itunesfinder.dagger.NetModule;

/**
 * Created by arturx on 20.11.17.
 */

public class ItunesApp extends Application {

    private static final String BASE_URL = "https://itunes.apple.com/";
    private static NetComponent sNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BASE_URL))
                .build();
    }

    public static NetComponent getNetComponent() {
        return sNetComponent;
    }
}
