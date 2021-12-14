package com.uit.danangfinancialtower.service.body;

import com.uit.danangfinancialtower.dto.BodyDto;
import com.uit.danangfinancialtower.mapper.BodyDtoMapper;
import com.uit.danangfinancialtower.repository.BodyRepository;
import com.uit.danangfinancialtower.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BodySearchByBuildingService
 */
@Service
@RequiredArgsConstructor
public class BodySearchByBuildingService extends BaseService<String, List<BodyDto>> {

    private final BodyRepository bodyRepository;
    private final BodyDtoMapper bodyDtoMapper;

    @Override
    protected List<BodyDto> setOutput() {
        return bodyDtoMapper.toDtoList(bodyRepository.findByBuildingId(input));
    }
}
