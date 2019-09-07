package com.gunawan.multiple.image.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gunawan.multiple.image.R;

import java.io.File;
import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private ArrayList<File> photoFile;
    private Activity activity;
    private Context context;

    public PhotoAdapter(Activity activity, ArrayList<File> photoFile) {
        this.photoFile = photoFile;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.row_photo, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PhotoAdapter.ViewHolder viewHolder, final int position) {
        Glide.with(viewHolder.ivPhoto.getContext()).load(photoFile.get(position)).apply(new RequestOptions().centerCrop().placeholder(R.drawable.camera)).into(viewHolder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return (null != photoFile ? photoFile.size() : 0);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto, ivDelete;
        private View cardView;

        public ViewHolder(View view) {
            super(view);
            ivPhoto = (ImageView) view.findViewById(R.id.ivPhoto);
            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
        }
    }

}
