package com.project.paginationdemo.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.paginationdemo.R;
import com.project.paginationdemo.data.model.UnSplash;
import com.project.paginationdemo.view.adapter.RecyclerItemadapter;
import com.project.paginationdemo.viewmodel.UnSplashViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
  UnSplashViewModel unSplashViewModel;
    private RecyclerItemadapter recyclerItemadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        unSplashViewModel= ViewModelProviders.of(this).get(UnSplashViewModel.class);
        recyclerItemadapter=new RecyclerItemadapter(this);
        unSplashViewModel.getUnSplashList().observe(this, new Observer<PagedList<UnSplash>>() {
            @Override
            public void onChanged(@Nullable PagedList<UnSplash> unSplashes) {
                recyclerItemadapter.submitList(unSplashes);
            }
        });
        recyclerview.setAdapter(recyclerItemadapter);
    }
}
