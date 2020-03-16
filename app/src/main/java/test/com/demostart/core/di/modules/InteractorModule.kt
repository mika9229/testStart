package test.com.demostart.test.com.demostart.core.di.modules

import dagger.Module
import dagger.Provides
import test.com.demostart.core.di.storage.AuthStorage
import test.com.demostart.test.com.demostart.core.api.comunicator.AuthCommunicator
import test.com.demostart.core.di.interactor.AuthInteractor
import test.com.demostart.core.di.interactor.AuthInteractorImpl
import test.com.demostart.test.com.demostart.core.di.scope.InteractorScope


@Module
class InteractorModule {

    @Provides
    @InteractorScope
    fun provideAuthInteractor(authCommunicator: AuthCommunicator, authDatabase: AuthStorage): AuthInteractor {
        return AuthInteractorImpl(authCommunicator, authDatabase)
    }


}
