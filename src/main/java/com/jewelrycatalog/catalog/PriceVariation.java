package com.jewelrycatalog.catalog;

public class PriceVariation {
    private String caratWeight;
    private double price;
    private String videoUrl;

    public PriceVariation(String caratWeight, double price, String videoUrl) {
        this.caratWeight = caratWeight;
        this.price = price;
        this.videoUrl = videoUrl;
    }
    public String getCaratWeight() {
        return caratWeight;
    }
    public void setCaratWeight(String caratWeight) {
        this.caratWeight = caratWeight;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
