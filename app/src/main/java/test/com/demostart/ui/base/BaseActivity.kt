package test.com.demostart.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import test.com.demostart.ui.base.mvp.BasePresenter

abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected var presenterBase: BasePresenter<BaseView>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenterBase = bindPresenter()
        if (presenterBase != null) presenterBase?.bindView(this)

    }

    protected abstract fun bindPresenter(): BasePresenter<BaseView>

}