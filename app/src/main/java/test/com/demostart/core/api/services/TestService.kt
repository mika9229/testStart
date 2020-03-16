package test.com.demostart.test.com.demostart.core.api.services

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import test.com.demostart.core.api.request.TestRequest
import test.com.demostart.test.com.demostart.core.api.response.TestResponse


interface TestService {

    // TODO  @Query("n") count: Int - test only
        @POST("?n=1")
    fun getTestLogin(@Body body: TestRequest): Single<TestResponse>


}