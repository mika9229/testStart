package test.com.demostart.test.com.demostart.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import test.com.demostart.core.di.storage.AuthStorage
import test.com.demostart.core.di.storage.AuthStorageImpl
import javax.inject.Singleton


@Module
class StorageModule(var context: Context) {

    @Provides
    fun provideStorage(context: Context): AuthStorage {
        return AuthStorageImpl(context)
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

}