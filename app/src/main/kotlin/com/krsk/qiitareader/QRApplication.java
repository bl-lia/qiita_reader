package com.krsk.qiitareader;

import android.app.Application;

import com.krsk.qiitareader.presentation.internal.di.HasComponent;
import com.krsk.qiitareader.presentation.internal.di.component.ApplicationComponent;
import com.krsk.qiitareader.presentation.internal.di.component.DaggerApplicationComponent;
import com.krsk.qiitareader.presentation.internal.di.module.ApplicationModule;

/**
 * Created by bl-lia on 2/2/16.
 */
public class QRApplication extends Application implements HasComponent<ApplicationComponent> {

    private ApplicationComponent component;
    private ApplicationComponent component() {
        if (component == null) {
            component = DaggerApplicationComponent.builder()
                                                    .applicationModule(new ApplicationModule())
                                                    .build();
        }

        return component;
    }

    @Override
    public ApplicationComponent getComponent() {
        return component();
    }
}
