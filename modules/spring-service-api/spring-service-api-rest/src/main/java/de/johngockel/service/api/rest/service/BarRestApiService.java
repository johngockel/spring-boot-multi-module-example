package de.johngockel.service.api.rest.service;

import de.johngockel.service.api.core.dto.BarDto;
import de.johngockel.service.api.core.service.BarApiService;
import de.johngockel.service.core.entity.bar.Bar;
import de.johngockel.service.core.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bar")
public class BarRestApiService implements BarApiService {

    private BarService barService;

    @Autowired
    public BarRestApiService(BarService barService) {
        this.barService = barService;
    }

    @GetMapping("/{id}")
    public BarDto getBar(@PathVariable("id") Long barId) {
        Bar bar = barService.getBar(barId);
        return BarDto.fromEntity(bar);
    }

    @GetMapping()
    public Collection<BarDto> getBars() {
        Collection<Bar> bars = barService.getBars();
        return BarDto.fromEntities(bars);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrUpdateBar(@RequestBody BarDto barDto) {
        Bar bar = barService.getBar(barDto.getId());
        barDto.updateBar(bar);
        barService.saveBar(bar);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBar(@PathVariable("id") Long barId) {
        barService.deleteBar(barId);
    }

    public void deleteBars(Collection<Long> barIds) {
        barService.deleteBars(barIds);
    }
}
