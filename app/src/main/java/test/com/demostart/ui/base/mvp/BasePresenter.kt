package test.com.demostart.ui.base.mvp

import androidx.annotation.NonNull

interface BasePresenter<V> {

    fun isBindView(): Boolean

    fun bindView(@NonNull view: V)

    fun unbindView(@NonNull view: V)

    fun onDestroy()


}