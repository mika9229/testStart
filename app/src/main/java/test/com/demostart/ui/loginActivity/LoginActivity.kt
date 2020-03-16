package test.com.demostart.ui.loginActivity


import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import test.com.demostart.ui.base.BaseActivity
import test.com.demostart.ui.base.BaseView
import test.com.demostart.ui.base.helper.toast
import test.com.demostart.ui.base.mvp.BasePresenter
import test.start.com.demostart.R

class LoginActivity : BaseActivity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUi()
    }

    private fun initUi(){
        start_button.setOnClickListener { presenter.sendRequest() }
    }

    override fun showSuccess(name: String) {
        toast(getString(R.string.success_mask, name))
    }

    override fun showError() {
        toast(getString(R.string.error))
    }

    override fun bindPresenter(): BasePresenter<BaseView> {
        presenter = LoginPresenter()
        return presenter as BasePresenter<BaseView>
    }
}
