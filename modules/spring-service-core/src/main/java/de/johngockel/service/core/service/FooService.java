package de.johngockel.service.core.service;

import de.johngockel.service.core.entity.foo.Foo;
import de.johngockel.service.core.repository.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class FooService {

    private FooRepository fooRepository;

    @Autowired
    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public Foo newFoo(String name) {
        return newFoo(name, null);
    }

    public Foo newFoo(String name, String description) {
        Foo newFoo = new Foo();
        newFoo.setName(name);
        newFoo.setDescription(description);
        return fooRepository.save(newFoo);
    }

    public Foo getFoo(Long fooId) {
        return fooRepository.getOne(fooId);
    }

    public Collection<Foo> getFoos() {
        return fooRepository.findAll();
    }

    public void saveFoo(Foo foo) {
        fooRepository.save(foo);
    }

    public void deleteFoo(Long fooId) {
        fooRepository.deleteById(fooId);
    }

    public void deleteFoos(Collection<Long> fooIds) {
        for(Long fooId: fooIds) {
            deleteFoo(fooId);
        }
    }
}
