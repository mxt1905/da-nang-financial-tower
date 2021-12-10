package com.uit.danangfinancialtower.service.face;

import com.uit.danangfinancialtower.dto.FaceDto;
import com.uit.danangfinancialtower.mapper.FaceDtoMapper;
import com.uit.danangfinancialtower.repository.FaceRepository;
import com.uit.danangfinancialtower.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FaceSearchByBodyService
 */
@Service
@RequiredArgsConstructor
public class FaceSearchByBodyService extends BaseService<String, List<FaceDto>> {

    private final FaceRepository faceRepository;
    private final FaceDtoMapper faceDtoMapper;

    @Override
    protected List<FaceDto> setOutput() {
        return faceDtoMapper.toDtoList(faceRepository.findByBodyId(input));
    }
}
