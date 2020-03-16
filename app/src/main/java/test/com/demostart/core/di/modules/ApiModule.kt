package test.com.demostart.core.di.modules

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import test.com.demostart.test.com.demostart.core.api.comunicator.AuthCommunicator
import test.com.demostart.test.com.demostart.core.api.comunicator.AuthCommunicatorImpl
import test.com.demostart.test.com.demostart.core.api.services.TestService
import test.com.demostart.test.com.demostart.core.di.scope.ApiScope
import test.start.com.demostart.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule(var context: Context) {

    @ApiScope
    @Provides
    fun provideAuthCommunicator(apiService: TestService): AuthCommunicator {
        return AuthCommunicatorImpl(
            apiService
        )
    }

    @Provides
    @ApiScope
    fun provideService(retrofit: Retrofit): TestService {
        return retrofit.create(TestService::class.java)
    }


    @Provides
    @ApiScope
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @Provides
    @ApiScope
    fun provideRetrofitBuilder(): Retrofit.Builder {
        val builder = OkHttpClient.Builder()
                .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)

        val gson = GsonBuilder()
                .setLenient()
                .create()

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpLoggingInterceptor)
                    .addNetworkInterceptor(StethoInterceptor())
        }

        return Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    }

    companion object {
        const val API_URL: String = "https://schematic-ipsum.herokuapp.com/"
    }

}