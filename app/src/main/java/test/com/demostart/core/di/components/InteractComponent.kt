package test.com.demostart.test.com.demostart.core.di.components

import dagger.Component
import test.com.demostart.core.di.components.ApiComponent
import test.com.demostart.core.di.interactor.AuthInteractor
import test.com.demostart.core.di.modules.ApiModule
import test.com.demostart.test.com.demostart.core.api.comunicator.AuthCommunicator
import test.com.demostart.test.com.demostart.core.di.modules.InteractorModule
import test.com.demostart.test.com.demostart.core.di.scope.InteractorScope
import javax.inject.Singleton

@InteractorScope
@Component(
    modules = [InteractorModule::class],
    dependencies = [ApiComponent::class, DaoComponent::class]
)
interface InteractComponent {

    fun getAuthRepository(): AuthInteractor


}