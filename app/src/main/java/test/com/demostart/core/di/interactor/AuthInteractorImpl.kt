package test.com.demostart.core.di.interactor

import android.annotation.SuppressLint
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import test.com.demostart.core.api.request.TestRequest
import test.com.demostart.core.di.storage.AuthStorage
import test.com.demostart.test.com.demostart.core.api.comunicator.AuthCommunicator
import javax.inject.Inject

@SuppressLint("CheckResult")
class AuthInteractorImpl

@Inject
constructor(val authCommunicator: AuthCommunicator,
            val authDatabase: AuthStorage): AuthInteractor {


    override fun getUser(body: TestRequest): Single<List<String>> {
       return authCommunicator.sendReqest(body)
           .map { authDatabase.saveUserName(it.name)
                  return@map authDatabase.getUserName()}
           .observeOn(AndroidSchedulers.mainThread())

    }

}
