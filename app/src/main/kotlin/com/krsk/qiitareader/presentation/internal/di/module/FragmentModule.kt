package com.krsk.qiitareader.presentation.internal.di.module

import android.app.Fragment

import com.krsk.qiitareader.presentation.internal.di.PerFragment

import dagger.Module
import dagger.Provides

/**
 * Created by bl-lia on 2/2/16.
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @PerFragment
    internal fun provideFragment(): Fragment {
        return this.fragment
    }
}
