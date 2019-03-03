package com.example.horoscope.main_activity_screen.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.horoscope.main_activity_screen.model.SunSign;
import com.example.zodiac.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacAdapter.PostViewHolder> {

    private List<SunSign> mSunSigns;
    private IOnItemClickListener mListener;

    public ZodiacAdapter(List<SunSign> sunSigns, @Nullable IOnItemClickListener listener) {
        mSunSigns = sunSigns;
        mListener = listener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horoscope, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(mSunSigns.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mSunSigns.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        private ImageView mZodiacImage;
        private TextView mZodiacTitle;
        private TextView mZodiacDate;

        PostViewHolder(@NonNull View itemView) {
            super(itemView);

            mZodiacImage = itemView.findViewById(R.id.zodiac_image);
            mZodiacTitle = itemView.findViewById(R.id.zodiac_title);
            mZodiacDate = itemView.findViewById(R.id.zodiac_date);
        }

        void bind(final SunSign sunSign, IOnItemClickListener listener) {
            setImage(sunSign, mZodiacImage);

            mZodiacTitle.setText(sunSign.getSunSign());
            mZodiacDate.setText(sunSign.getDate());

            itemView.setOnClickListener(v -> listener.onItemClick(sunSign.getId()));
        }

        private void setImage(SunSign sunSign, ImageView targetImageView) {
            Glide
                    .with(targetImageView.getContext())
                    .load(sunSign.getImageUrl())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_leo))
                    .into(targetImageView);
        }
    }
}
