package test.com.demostart.core.di.components

import dagger.Component
import test.com.demostart.core.di.modules.ApiModule
import test.com.demostart.test.com.demostart.core.api.comunicator.AuthCommunicator
import test.com.demostart.test.com.demostart.core.di.scope.ApiScope
import test.com.demostart.test.com.demostart.core.di.scope.InteractorScope
import javax.inject.Singleton

@ApiScope
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {

    fun getAuthCommunicator(): AuthCommunicator


}