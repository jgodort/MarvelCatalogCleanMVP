package com.software.jgodort.marvelheroes.threading.impl

import com.software.jgodort.marvelheroes.threading.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class UIThread @Inject internal constructor() : PostExecutionThread {

  override val scheduler: Scheduler
    get() = AndroidSchedulers.mainThread()
}