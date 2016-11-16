package com.example.administrator.myapplication;

import android.graphics.Bitmap;

public class Light {
    private Bitmap image;
    private Bitmap imageLarge;
    private String imageFileName;
    private String imageLargeFileName;
    private String title;
    private String content;

    public Light(Bitmap image, Bitmap imageLarge, String title, String content) {
        this.image = image;
        this.imageLarge = imageLarge;
        this.title = title;
        this.content = content;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageLargeFileName() {
        return imageLargeFileName;
    }

    public void setImageLargeFileName(String imageLargeFileName) {
        this.imageLargeFileName = imageLargeFileName;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImageLarge() { return imageLarge; }

    public void setImageLarge(Bitmap imageLarge) { this.imageLarge = imageLarge; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
