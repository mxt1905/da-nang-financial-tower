package com.uit.danangfinancialtower.service.building;

import com.uit.danangfinancialtower.dto.BuildingDto;
import com.uit.danangfinancialtower.mapper.BuildingDtoMapper;
import com.uit.danangfinancialtower.repository.BuildingRepository;
import com.uit.danangfinancialtower.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BuildingSearchService
 */
@Service
@RequiredArgsConstructor
public class BuildingSearchService extends BaseService<Void, List<BuildingDto>> {

    private final BuildingRepository buildingRepository;
    private final BuildingDtoMapper buildingDtoMapper;

    @Override
    protected List<BuildingDto> setOutput() {
        return buildingDtoMapper.toDtoList(buildingRepository.findAll());
    }
}
