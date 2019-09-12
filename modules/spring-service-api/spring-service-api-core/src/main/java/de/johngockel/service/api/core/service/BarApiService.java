package de.johngockel.service.api.core.service;

import de.johngockel.service.api.core.dto.BarDto;

import java.util.Collection;

public interface BarApiService {

    BarDto getBar(Long barId);
    Collection<BarDto> getBars();

    BarDto createBar(BarDto barDto);

    void saveBar(BarDto bar);

    void deleteBar(Long barId);
    void deleteBars(Collection<Long> barIds);
}
