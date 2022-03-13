package com.rachid_abbad.galleryimage.models;

import java.io.Serializable;

public class Image implements Serializable {
    String title,imageName,description;

    public Image(String title, String imageName, String description) {
        this.title = title;
        this.imageName = imageName;
        this.description = description;
    }

    public Image() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
