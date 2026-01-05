package com.jewelrycatalog.catalog;

import java.util.ArrayList;
import java.util.List;

public class JewelryItem {
    private String name;
    private String category;
    private String subcategory;
    private String imageUrl;
    private List<PriceVariation> variations;

    public JewelryItem(String name, String category, String subcategory, String imageUrl) {
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
        this.imageUrl = imageUrl;
        this.variations = new ArrayList<>();
    }
    public void addVariation(String caratWeight, double price, String videoUrl) {
        this.variations.add(new PriceVariation(caratWeight, price, videoUrl));
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    private void setCategory(String category) {
        this.category = category;
    }
    public String getSubcategory() {
        return subcategory;
    }
    private void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    private void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public List<PriceVariation> getVariations() {
        return variations;
    }
    private void setVariations(List<PriceVariation> variations) {
        this.variations = variations;
    }
}

