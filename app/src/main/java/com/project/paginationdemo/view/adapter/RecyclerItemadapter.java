package com.project.paginationdemo.view.adapter;

import android.arch.paging.PagedList;
import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.project.paginationdemo.R;
import com.project.paginationdemo.data.model.UnSplash;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sooraj Soman on 11/20/2018
 */
public class RecyclerItemadapter extends PagedListAdapter<UnSplash, RecyclerItemadapter.RecyclerItemViewHolder> {

    private Context context;
    private List<UnSplash> items;


    public RecyclerItemadapter( Context context) {
        super(DIFF_CALLBACK);

        this.context = context;
    }


    private static DiffUtil.ItemCallback<UnSplash> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<UnSplash>() {
                @Override
                public boolean areItemsTheSame(@NonNull UnSplash oldItem, @NonNull UnSplash newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull UnSplash oldItem, @NonNull UnSplash newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new RecyclerItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, int position) {
        UnSplash item = getItem(position);
        holder.set(item);
    }



    public  class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imagebanner)
        ImageView imagebanner;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.proilepic)
        ImageView proilepic;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.divSectiontwo)
        LinearLayout divSectiontwo;
        public RecyclerItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void set(UnSplash unSplash) {
            //UI setting code
            if (!checkNull(unSplash.getUser().getUsername())) {
                username.setText(unSplash.getUser().getUsername());
            } else
                username.setText("Lorem Ipsum");

            if (!checkNull(unSplash.getUser().getBio())) {
                description.setText(unSplash.getUser().getBio().toString());
            } else
                description.setText("Lorem Ipsum");


            if (!checkNull(unSplash.getUser().getProfileImage().getLarge())) {
                Glide.with(context).load(unSplash.getUser().getProfileImage().getLarge()).apply(new RequestOptions().transform(new RoundedCorners(16))).into(proilepic);
            }
            if (!checkNull(unSplash.getUrls().getFull())) {
                Glide.with(context).load(unSplash.getUrls().getFull()).apply(new RequestOptions().override(600, 200)).into(imagebanner);
            }
        }
    }
    public  boolean checkNull(String input) {
        if (TextUtils.isEmpty(input)) {
            return true;

        }
        return false;
    }


}