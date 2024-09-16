package com.digitalrazgrad.consuming_rest_apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cat-service", url = "https://catfact.ninja/")
public interface CatClient {

    @GetMapping("/fact")
    CatFact getCatsInfo();

    @GetMapping("/breeds")
    BreedsResponse getCatsBreeds();
}
