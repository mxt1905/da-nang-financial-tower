package com.uit.danangfinancialtower.controller.rest;

import com.uit.danangfinancialtower.dto.FaceDto;
import com.uit.danangfinancialtower.service.face.FaceSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FaceController
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FaceController {

    private final FaceSearchService faceSearchService;

    @GetMapping("/faces")
    public List<FaceDto> faces() {
        return faceSearchService.execute();
    }
}
