package test.com.demostart.ui.loginActivity


import test.com.demostart.core.api.request.NameRequest
import test.com.demostart.core.api.request.TestRequest
import test.com.demostart.core.di.components.AppComponent
import test.com.demostart.core.di.interactor.AuthInteractor
import test.com.demostart.ui.base.mvp.Presenter
import javax.inject.Inject


class LoginPresenter : Presenter<LoginContract.View>(), LoginContract.Presenter {

    @Inject
    protected lateinit var authauthInteractor: AuthInteractor


    override fun sendRequest() {
        disposables.add(authauthInteractor.getUser(generateRequest())
            .subscribe({
                if(isBindView())
                    view()?.showSuccess(it.toString())
            }, { throwable ->
                run {
                    if (isBindView())
                        view()?.showError()
                    throwable.printStackTrace()
                }
            }))
    }

    override fun inject(component: AppComponent?) {
        component.let {
            it?.inject(this)
        }
    }

    ///TODO test only
    private fun generateRequest(): TestRequest{
        val request  = TestRequest()
        request.properties = TestRequest.Properties()

        val nameRequest = NameRequest()
        nameRequest.ipsum = "name"
        nameRequest.type = "string"

        request.properties?.items = nameRequest
        request.type = "object"

        return request
    }
}
