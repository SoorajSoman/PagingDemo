package com.project.paginationdemo.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.project.paginationdemo.data.UnSplashDataFactory;
import com.project.paginationdemo.data.UnSplashDataSource;
import com.project.paginationdemo.data.model.UnSplash;

import java.util.List;

/**
 * @author Sooraj Soman on 11/20/2018
 */
public class UnSplashRespository {

    LiveData<PagedList<UnSplash>> unSplashedPagedListLiveData;
    LiveData<PageKeyedDataSource<Integer, UnSplash>> pageKeyedDataSource;


    public UnSplashRespository(Application application) {
        UnSplashDataFactory dataSource = new UnSplashDataFactory();
        pageKeyedDataSource = dataSource.getUnsplashLiveData();
        PagedList.Config pConfig = (new PagedList.Config.Builder()).setEnablePlaceholders(false).setPageSize(10).build();
        unSplashedPagedListLiveData =
                (new LivePagedListBuilder(dataSource, pConfig)).build();
    }

    public LiveData<PagedList<UnSplash>> getUnSplashedPagedListLiveData() {
        return unSplashedPagedListLiveData;
    }
}
