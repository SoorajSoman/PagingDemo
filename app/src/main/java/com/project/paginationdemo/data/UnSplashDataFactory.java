package com.project.paginationdemo.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.project.paginationdemo.data.UnSplashDataSource;
import com.project.paginationdemo.data.model.UnSplash;

/**
 * @author Sooraj Soman on 11/20/2018
 */
public class UnSplashDataFactory extends DataSource.Factory {

    MutableLiveData<PageKeyedDataSource<Integer, UnSplash>> unsplashLiveData = new MutableLiveData<>();

    @Override
    public DataSource<Integer, UnSplash> create() {
        UnSplashDataSource dataSource = new UnSplashDataSource();
        unsplashLiveData.postValue(dataSource);
        return dataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, UnSplash>> getUnsplashLiveData() {
        return unsplashLiveData;
    }
}
