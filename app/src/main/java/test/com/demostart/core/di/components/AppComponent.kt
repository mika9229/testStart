package test.com.demostart.core.di.components

import dagger.Component
import test.com.demostart.test.com.demostart.core.di.components.InteractComponent
import test.com.demostart.test.com.demostart.core.di.scope.ManagerScope
import test.com.demostart.ui.loginActivity.LoginPresenter

@ManagerScope
@Component(dependencies = [InteractComponent::class])
interface AppComponent {

    fun inject(presenter: LoginPresenter)

}