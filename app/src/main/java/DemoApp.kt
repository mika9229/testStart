package test.com.demostart


import android.app.Application
import com.facebook.stetho.Stetho
import test.com.demostart.core.di.components.AppComponent
import test.com.demostart.core.di.components.DaggerApiComponent
import test.com.demostart.core.di.components.DaggerAppComponent
import test.com.demostart.core.di.modules.ApiModule
import test.com.demostart.test.com.demostart.core.di.components.DaggerDaoComponent
import test.com.demostart.test.com.demostart.core.di.components.DaggerInteractComponent
import test.com.demostart.test.com.demostart.core.di.modules.InteractorModule
import test.com.demostart.test.com.demostart.core.di.modules.StorageModule
import test.start.com.demostart.BuildConfig

class DemoApp : Application() {

    private var app: Application? = null

    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        app = this
        super.onCreate()

        if (BuildConfig. DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

        addDependencyInjection()
    }

     private fun addDependencyInjection() {
         val apiComponent = DaggerApiComponent.builder()
             .apiModule(ApiModule(baseContext))
             .build()

         val daoComponent = DaggerDaoComponent.builder()
             .storageModule(StorageModule(baseContext))
             .build()


        val interactorComponent = DaggerInteractComponent.builder()
            .daoComponent(daoComponent)
            .apiComponent(apiComponent)
            .interactorModule(InteractorModule())
            .build()

        appComponent = DaggerAppComponent
            .builder()
            .interactComponent(interactorComponent)
            .build()
    }

}
