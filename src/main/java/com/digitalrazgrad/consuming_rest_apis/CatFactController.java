package com.digitalrazgrad.consuming_rest_apis;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CatFactController {
    private final CatFactService catFactService;

    public CatFactController(CatFactService catFactService) {
        this.catFactService = catFactService;
    }

    @GetMapping("/catfact")
    public String getCatFact() throws IOException {
        return catFactService.getCatFact();
    }

    @PostMapping("/post")
    public String postCatFact(@RequestBody CatFact catFact) throws IOException {
        return catFactService.postCatFact(catFact);
    }
}
