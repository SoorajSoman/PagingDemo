package com.project.paginationdemo.data;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.project.paginationdemo.data.model.UnSplash;
import com.project.paginationdemo.data.rest.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Sooraj Soman on 11/20/2018
 */
public class UnSplashDataSource extends PageKeyedDataSource<Integer,UnSplash> {

    public  static final int FIRST_PAGE = 1;
    private static final String CLIENT_TOKEN = "8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8";
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, UnSplash> callback) {
        RestClient.RestApiInterface restApiInterface= RestClient.getClient();
        restApiInterface.getListUnSplash(CLIENT_TOKEN,FIRST_PAGE).enqueue(new Callback<List<UnSplash>>() {
            @Override
            public void onResponse(Call<List<UnSplash>> call, Response<List<UnSplash>> response) {
                if(response.body()!=null){
                    callback.onResult(response.body(),null,FIRST_PAGE+1);

                }

            }

            @Override
            public void onFailure(Call<List<UnSplash>> call, Throwable t) {
            }
        });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, UnSplash> callback) {
        RestClient.RestApiInterface restApiInterface= RestClient.getClient();

        restApiInterface.getListUnSplash(CLIENT_TOKEN,params.key).enqueue(new Callback<List<UnSplash>>() {
            @Override
            public void onResponse(Call<List<UnSplash>> call, Response<List<UnSplash>> response) {
                Integer adjacencyKey=(params.key>1)?params.key-1:null;
                if(response.body()!=null){
                    callback.onResult(response.body(),adjacencyKey);

                }

            }

            @Override
            public void onFailure(Call<List<UnSplash>> call, Throwable t) {
            }
        });
    }

    @Override
    public void loadAfter(@NonNull  final LoadParams<Integer> params, @NonNull final  LoadCallback<Integer, UnSplash> callback) {
        RestClient.RestApiInterface restApiInterface= RestClient.getClient();

        restApiInterface.getListUnSplash(CLIENT_TOKEN,params.key).enqueue(new Callback<List<UnSplash>>() {
            @Override
            public void onResponse(Call<List<UnSplash>> call, Response<List<UnSplash>> response) {
                Integer key=(params.key>1)?params.key+1:null;
                if(response.body()!=null){
                    callback.onResult(response.body(),key);

                }

            }

            @Override
            public void onFailure(Call<List<UnSplash>> call, Throwable t) {
            }
        });
    }
}
