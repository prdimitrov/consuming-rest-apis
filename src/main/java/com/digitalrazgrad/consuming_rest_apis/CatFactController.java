package com.digitalrazgrad.consuming_rest_apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CatFactController {
    private final CatFactService catFactService;
    private final CatClient catClient;

    @Autowired
    public CatFactController(CatFactService catFactService, CatClient catClient) {
        this.catFactService = catFactService;
        this.catClient = catClient;
    }

    @GetMapping("/catfact")
    public ResponseEntity<CatFact> getCatFact() throws IOException {
        CatFact catFact = catClient.getCatsInfo();
        return ResponseEntity.ok(catFact);
    }

    @PostMapping("/post")
    public String postCatFact(@RequestBody CatFact catFact) throws IOException {
        return catFactService.postCatFact(catFact);
    }

    @GetMapping("/breed")
    public ResponseEntity<BreedsResponse> getCatBreeds() {
        BreedsResponse catBreed = catClient.getCatsBreeds();
        return ResponseEntity.ok(catBreed);
    }
}
