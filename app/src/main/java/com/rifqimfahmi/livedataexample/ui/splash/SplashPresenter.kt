package com.rifqimfahmi.livedataexample.ui.splash

import com.rifqimfahmi.livedataexample.data.DataManager
import com.rifqimfahmi.livedataexample.ui.base.BasePresenter
import com.rifqimfahmi.livedataexample.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter<V: SplashMvpView> @Inject constructor(dataManager: DataManager,
                                        schedulerProvider: SchedulerProvider,
                                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), SplashMvpPresenter<V> {

}