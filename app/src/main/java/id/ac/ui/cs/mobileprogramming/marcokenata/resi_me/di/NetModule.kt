package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ResiMeApplication
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.MealDBService
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
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
    fun providesHttpClient(application: ResiMeApplication) : OkHttpClient {
        interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
//                .addInterceptor(isOnline(application))
                .addInterceptor(requestInterceptor)
                .build()

    }


    external fun httpUrl() : String

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : MealDBService {
        Log.d("RETROFIT","CALLED")
        return Retrofit.Builder().client(okHttpClient).baseUrl(httpUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MealDBService::class.java)
    }

    @Provides
    @Singleton
    fun isOnline(application: ResiMeApplication) : Interceptor {
        val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo


            val netInterceptor = Interceptor {chain ->
                if (!(networkInfo != null && networkInfo.isConnected)){
                    throw NoConnectivityException()
                }
                return@Interceptor chain.proceed(chain.request())
            }
            return netInterceptor




    }
}