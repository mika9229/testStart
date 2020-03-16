package test.com.demostart.ui.base.mvp

import android.os.Looper
import androidx.annotation.CallSuper
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposables
import test.com.demostart.DemoApp
import test.com.demostart.core.di.components.AppComponent

abstract class Presenter<V> : BasePresenter<V> {

    init {
        inject(DemoApp.appComponent)
    }

    @Nullable
    @Volatile
    private var view: V? = null
    protected var disposables =  CompositeDisposable()

    override fun isBindView(): Boolean {
        return view != null
    }

    protected val isMainThread: Boolean
        get() = Looper.getMainLooper().thread === Thread.currentThread()



    @CallSuper
    override fun bindView(@NonNull view: V) {
        val previousView = this.view

        if (previousView != null)
            throw IllegalStateException("Previous view is not unbounded! previousView = $previousView")

        this.view = view
    }


    @Nullable
    protected fun view(): V? {
        return view
    }

    @CallSuper
    override fun unbindView(@NonNull view: V) {
        val previousView = this.view
        if (previousView === view) {
            this.view = null
        } else {
            throw IllegalStateException("Unexpected view! previousView = $previousView, view to unbind = $view")
        }
    }

    override fun onDestroy() {
        disposables.dispose()
    }

    abstract fun inject(component: AppComponent?)
}