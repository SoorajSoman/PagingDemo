package com.project.paginationdemo.data.rest;

import com.project.paginationdemo.data.model.UnSplash;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Sooraj Soman on 11/20/2018
 */
public class RestClient {
    public static RestApiInterface apiInterface;
 static String baseapi="https://api.unsplash.com/";
    public static RestApiInterface getClient() {

        if (apiInterface == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            //logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);


            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(logging);
            builder.addInterceptor(logging);
            OkHttpClient httpClient = builder.build();


            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseapi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
            apiInterface = client.create(RestApiInterface.class);
        }
        return apiInterface;
    }

    public interface RestApiInterface {

        @GET("photos/")
        Call<List<UnSplash>> getListUnSplash(@Query("client_id") String user,@Query("page") int page);

        //@GET("photos/?options")
        // Call<List<UnSplash>> getListUnSplash(@Path("options") Map<String, String> options, @Query());
    }
}
