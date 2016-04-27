package com.krsk.qiitareader.presentation.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.krsk.qiitareader.R
import com.krsk.qiitareader.presentation.fragment.ItemListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = ItemListFragment.newInstance()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(android.R.id.content, fragment)
            fragmentTransaction.commit()
        }
    }
}
