package com.uit.danangfinancialtower.service.face;

import com.uit.danangfinancialtower.dto.FaceDto;
import com.uit.danangfinancialtower.entity.FaceEntity;
import com.uit.danangfinancialtower.mapper.FaceDtoMapper;
import com.uit.danangfinancialtower.repository.FaceRepository;
import com.uit.danangfinancialtower.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FaceSearchService
 */
@Service
@RequiredArgsConstructor
public class FaceSearchService extends BaseService<Void, List<FaceDto>> {

    private final FaceRepository faceRepository;
    private final FaceDtoMapper faceDtoMapper;

    @Override
    protected List<FaceDto> setOutput() {
        List<FaceEntity> faces = faceRepository.findAll();
        return faceDtoMapper.toDtoList(faces);
    }
}
