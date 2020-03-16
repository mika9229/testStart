package test.com.demostart.core.di.interactor

import io.reactivex.Single
import test.com.demostart.core.api.request.TestRequest
import test.com.demostart.test.com.demostart.core.api.response.TestResponse


interface AuthInteractor {

    fun getUser(body: TestRequest): Single<List<String>>

}

