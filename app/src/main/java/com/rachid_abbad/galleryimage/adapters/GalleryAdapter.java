package com.rachid_abbad.galleryimage.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.rachid_abbad.galleryimage.R;
import com.rachid_abbad.galleryimage.activities.DetailsActivity;
import com.rachid_abbad.galleryimage.models.Image;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    Context context;
    List<Image> imageList;
    int res;

    public GalleryAdapter(Context context,int ressource,List<Image> list){
        this.context = context;
        this.imageList = list;
        this.res = ressource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(res,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titre.setText(imageList.get(position).getTitle());

        int imageId = context.getResources().getIdentifier(imageList.get(position).getImageName(), "drawable", context.getPackageName());
        holder.imageContainer.setImageDrawable(context.getDrawable(imageId));

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("image",imageList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titre;
        ShapeableImageView imageContainer;
        CardView container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.imageTitle);
            imageContainer = itemView.findViewById(R.id.imageContainer);
            container = itemView.findViewById(R.id.container);
        }
    }
}
