package com.krsk.qiitareader.presentation.internal.di.module;

import android.app.Fragment;

import com.krsk.qiitareader.presentation.internal.di.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bl-lia on 2/2/16.
 */
@Module
public class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides @PerFragment
    Fragment provideFragment() {
        return this.fragment;
    }
}
