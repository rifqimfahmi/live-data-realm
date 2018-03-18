package com.rifqimfahmi.livedataexample.ui.splash

import android.content.Intent
import android.os.Bundle
import com.rifqimfahmi.livedataexample.R
import com.rifqimfahmi.livedataexample.ui.base.BaseActivity
import com.rifqimfahmi.livedataexample.ui.home.HomeActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashMvpView {

    @Inject
    lateinit var mSplashPresenter: SplashMvpPresenter<SplashMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent.inject(this)
        mSplashPresenter.onAttach(this)

        startActivity(Intent(this, HomeActivity::class.java))
        finish()
        // do something here. eg. check for app update and open the next activity
    }

    override fun setup() {

    }

}

