package com.uit.danangfinancialtower.controller.rest;

import com.uit.danangfinancialtower.dto.FaceDto;
import com.uit.danangfinancialtower.service.face.FaceSearchByBodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BodyController
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BodyController {

    private final FaceSearchByBodyService faceSearchByBodyService;

    @GetMapping("body/{bodyId}")
    public List<FaceDto> getFacesByBodyId(@PathVariable String bodyId) {
        return faceSearchByBodyService.setInput(bodyId).execute();
    }
}
