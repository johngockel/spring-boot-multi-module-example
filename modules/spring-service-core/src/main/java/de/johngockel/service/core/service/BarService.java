package de.johngockel.service.core.service;

import de.johngockel.service.core.entity.bar.Bar;
import de.johngockel.service.core.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class BarService {

    private BarRepository barRepository;

    @Autowired
    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    public Bar newBar(String name) {
        return newBar(name, null);
    }

    public Bar newBar(String name, String description) {
        Bar newBar = new Bar();
        newBar.setName(name);
        newBar.setDescription(description);
        return barRepository.save(newBar);
    }

    public Bar getBar(Long barId) {
        return barRepository.getOne(barId);
    }

    public Collection<Bar> getBars() {
        return barRepository.findAll();
    }

    public void saveBar(Bar bar) {
        barRepository.save(bar);
    }

    public void deleteBar(Long barId) {
        barRepository.deleteById(barId);
    }

    public void deleteBars(Collection<Long> barIds) {
        for(Long barId: barIds) {
            deleteBar(barId);
        }
    }
}
