package test.com.demostart.test.com.demostart.core.api.comunicator

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import test.com.demostart.core.api.request.TestRequest
import test.com.demostart.test.com.demostart.core.api.response.TestResponse
import test.com.demostart.test.com.demostart.core.api.services.TestService


class AuthCommunicatorImpl(private val apiTestService: TestService) :
    AuthCommunicator {

    override fun sendReqest(body: TestRequest): Single<TestResponse> {
        return apiTestService.getTestLogin( body)
                .subscribeOn(Schedulers.io())
    }

}

