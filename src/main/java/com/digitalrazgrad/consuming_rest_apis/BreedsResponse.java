package com.digitalrazgrad.consuming_rest_apis;

import java.util.List;

public class BreedsResponse {
    private int currentPage;
    private List<CatBreed> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<CatBreed> getData() {
        return data;
    }

    public void setData(List<CatBreed> data) {
        this.data = data;
    }
}
