package com.example.demo.controller;


import com.example.demo.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/ranking/{faculty}/{year}")
    public ResponseEntity getRank(@PathVariable String faculty, @PathVariable String year) {
        System.out.println(faculty);
        System.out.println(year);
        return ResponseEntity.ok().body(rankingService.getStudentsRank(faculty, Integer.valueOf(year)));

    }
}


