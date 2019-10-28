package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.MealDBService
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.httpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    val requestInterceptor = Interceptor {chain ->

        var url = chain.request()
            .url
            .newBuilder()
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)

    }

    val interceptor = HttpLoggingInterceptor()

    @Provides
    @Singleton
    fun providesHttpClient() : OkHttpClient {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(requestInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : MealDBService {
        Log.d("RETROFIT","CALLED")
        return Retrofit.Builder().client(okHttpClient).baseUrl(httpUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MealDBService::class.java)
    }
}