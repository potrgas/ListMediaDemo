package com.portgas.listmediademo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/1/7 0007.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> implements View.OnClickListener {
    private Context context;
    private List<Entity.ItemsEntity> list;


    public VideoAdapter(Context context, List<Entity.ItemsEntity> list) {
        this.context = context;
        this.list = list;
    }

    public void addAll(Collection<? extends Entity.ItemsEntity> collection) {

        list.addAll(collection);
        notifyDataSetChanged();

    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        VideoViewHolder holder = new VideoViewHolder(view);
        holder.mPic.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        Entity.ItemsEntity item = list.get(position);
        holder.mTextContent.setText(item.getContent());
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setUri(item.getPic_url()).build();
        holder.mPic.setController(controller);
        holder.mPic.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
       int position= (int) v.getTag();

    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextContent;
        private final SimpleDraweeView mPic;
        private final SurfaceView mVideo;

        public VideoViewHolder(View itemView) {
            super(itemView);
            mTextContent = ((TextView) itemView.findViewById(R.id.item_content));
            mPic = ((SimpleDraweeView) itemView.findViewById(R.id.item_pic));
            mVideo = ((SurfaceView) itemView.findViewById(R.id.item_video));

            mPic.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
            mPic.setAspectRatio(1);

        }
    }
}
