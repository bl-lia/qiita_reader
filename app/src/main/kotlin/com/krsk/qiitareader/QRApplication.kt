package com.krsk.qiitareader

import android.app.Application

import com.facebook.stetho.Stetho
import com.krsk.qiitareader.presentation.internal.di.HasComponent
import com.krsk.qiitareader.presentation.internal.di.component.ApplicationComponent
import com.krsk.qiitareader.presentation.internal.di.component.DaggerApplicationComponent
import com.krsk.qiitareader.presentation.internal.di.module.ApplicationModule

/**
 * Created by bl-lia on 2/2/16.
 */
class QRApplication : Application(), HasComponent<ApplicationComponent> {

    private val _component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule()).build()
    }

    override val component: ApplicationComponent
        get() = _component

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
