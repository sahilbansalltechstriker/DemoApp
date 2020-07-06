package com.example.demoapp.serviceHandlers

import com.example.demoapp.serviceHandler.MyApi
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object RetrofitClient {


    private val httpClient = OkHttpClient()




    private var retrofit: Retrofit? = null
    const val BASE_URL: String = "https://developers.zomato.com/api/v2.1/"
    val service: MyApi
        get() {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!.create(MyApi::class.java)
        }

    var gson = GsonBuilder()
        .setLenient()
        .create()


    var okClient = OkHttpClient.Builder()
        .addInterceptor(
            object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response? {
                    val original: Request = chain.request()

                    // Request customization: add request headers
                    val requestBuilder: Request.Builder = original.newBuilder()

                        .method(original.method(), original.body())
                    val request: Request = requestBuilder.build()
                    return chain.proceed(request)
                }
            })
        .build()
}