package com.rachid_abbad.galleryimage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.rachid_abbad.galleryimage.R;
import com.rachid_abbad.galleryimage.models.Image;

public class DetailsActivity extends AppCompatActivity {

    TextView titre,details;
    ShapeableImageView imageContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Image img = (Image) getIntent().getSerializableExtra("image");

        titre = findViewById(R.id.title);
        imageContainer = findViewById(R.id.imagecontainer);
        details = findViewById(R.id.details);

        titre.setText(img.getTitle());
        details.setText(img.getDescription());

        int imageId = getResources().getIdentifier(img.getImageName(), "drawable", getPackageName());
        imageContainer.setImageDrawable(getDrawable(imageId));
    }
}