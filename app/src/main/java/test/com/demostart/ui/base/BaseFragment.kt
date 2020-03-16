package test.com.demostart.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import test.com.demostart.ui.base.mvp.BasePresenter

abstract class BaseFragment : Fragment(), BaseView {

    protected var presenterBase: BasePresenter<BaseView>? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenterBase = bindPresenter()
        if (presenterBase != null) presenterBase?.bindView(this)

    }

    protected abstract fun bindPresenter(): BasePresenter<BaseView>

}