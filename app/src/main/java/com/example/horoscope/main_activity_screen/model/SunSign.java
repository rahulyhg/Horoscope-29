package com.example.horoscope.main_activity_screen.model;

public class SunSign {
    private int id;

    private String sunSign;

    private String date;

    private int imageUrl;

    public SunSign(int id, String name, String date, int imageUrl) {
        this.id = id;
        this.sunSign = name;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSunSign() {
        return sunSign;
    }

    public void setSunSign(String name) {
        this.sunSign = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "LanguageItem{" +
                "id=" + id +
                ", name='" + sunSign + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
