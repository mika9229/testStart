package test.com.demostart.test.com.demostart.core.di.components

import android.content.Context
import dagger.Component
import test.com.demostart.core.di.modules.ApiModule
import test.com.demostart.core.di.storage.AuthStorage
import test.com.demostart.test.com.demostart.core.di.modules.StorageModule
import javax.inject.Singleton

@Component(modules = arrayOf(StorageModule::class))
interface DaoComponent {

    fun getAuthStorage(): AuthStorage


}