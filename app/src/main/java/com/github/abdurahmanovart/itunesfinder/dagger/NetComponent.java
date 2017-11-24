package com.github.abdurahmanovart.itunesfinder.dagger;

import com.github.abdurahmanovart.itunesfinder.model.MainModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by arturx on 20.11.17.
 */


@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainModel model);


}
