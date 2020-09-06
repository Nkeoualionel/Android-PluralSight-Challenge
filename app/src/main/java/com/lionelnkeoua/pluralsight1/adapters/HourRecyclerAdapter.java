package com.lionelnkeoua.pluralsight1.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lionelnkeoua.pluralsight1.R;
import com.lionelnkeoua.pluralsight1.model.Hour;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context mCtx;
    List<Hour> hourList;

    public RecyclerAdapter(Context mCtx, List<Hour> hourList) {
        this.mCtx = mCtx;
        this.hourList = hourList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item, parent, false);

        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Hour hour = hourList.get(position);

        Glide.with(mCtx)
                .load(hour.getImageUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.mProgressBar.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.mProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.imageView);

        holder.mName.setText(hour.getName());
        holder.mHour.setText(hour.getHour());
        holder.mCountry.setText(hour.getCountry());

    }

    @Override
    public int getItemCount() {
        return hourList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mImageBadge)
        ImageView imageView;

        @BindView(R.id.mNom)
        TextView mName;

        @BindView(R.id.mHour)
        TextView mHour;

        @BindView(R.id.mCountry)
        TextView mCountry;

        @BindView(R.id.prograss_load_photo)
        ProgressBar mProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
