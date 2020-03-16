package test.com.demostart.test.com.demostart.core.api.comunicator


import io.reactivex.Single
import test.com.demostart.core.api.request.TestRequest
import test.com.demostart.test.com.demostart.core.api.response.TestResponse


interface AuthCommunicator {

    fun sendReqest(body: TestRequest): Single<TestResponse>

}