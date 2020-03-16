package test.com.demostart.ui.loginActivity

import test.com.demostart.ui.base.BaseView
import test.com.demostart.ui.base.mvp.BasePresenter

interface LoginContract {

    interface View : BaseView {

        fun showSuccess(name: String)

        fun showError()

    }

    interface Presenter : BasePresenter<View> {

        fun sendRequest()

    }

}