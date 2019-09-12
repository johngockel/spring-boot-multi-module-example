package de.johngockel.service.api.core.dto;

import de.johngockel.service.core.entity.bar.Bar;

import java.util.ArrayList;
import java.util.Collection;

public class BarDto {

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateBar(Bar bar) {
        bar.setName(name);
        bar.setDescription(description);
    }

    public static BarDto fromEntity(Bar bar) {
        BarDto newBarDto = new BarDto();
        newBarDto.setId(bar.getId());
        newBarDto.setName(bar.getName());
        newBarDto.setDescription(bar.getDescription());
        return newBarDto;
    }

    public static Collection<BarDto> fromEntities(Collection<Bar> bars) {
        Collection<BarDto> barDtos = new ArrayList<BarDto>();
        for(Bar bar: bars) {
            BarDto barDto = fromEntity(bar);
            barDtos.add(barDto);
        }
        return barDtos;
    }
}
