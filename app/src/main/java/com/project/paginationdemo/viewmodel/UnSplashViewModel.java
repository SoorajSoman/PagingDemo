package com.project.paginationdemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.project.paginationdemo.data.model.UnSplash;
import com.project.paginationdemo.repository.UnSplashRespository;

import java.util.List;

/**
 * @author Sooraj Soman on 11/20/2018
 */
public class UnSplashViewModel extends AndroidViewModel {

    LiveData<PagedList<UnSplash>> unSplashList;
    UnSplashRespository unSplashRespository;

    public UnSplashViewModel(@NonNull Application application) {
        super(application);
        unSplashRespository = new UnSplashRespository(application);
        unSplashList = unSplashRespository.getUnSplashedPagedListLiveData();

    }

    public LiveData<PagedList<UnSplash>> getUnSplashList() {
        return unSplashList;
    }
}
