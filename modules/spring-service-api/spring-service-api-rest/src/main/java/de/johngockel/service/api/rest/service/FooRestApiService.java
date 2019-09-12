package de.johngockel.service.api.rest.service;

import de.johngockel.service.api.core.dto.FooDto;
import de.johngockel.service.api.core.service.FooApiService;
import de.johngockel.service.core.entity.foo.Foo;
import de.johngockel.service.core.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/foo")
public class FooRestApiService implements FooApiService {

    private FooService fooService;

    @Autowired
    public FooRestApiService(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping("/{id}")
    public FooDto getFoo(@PathVariable("id") Long fooId) {
        Foo foo = fooService.getFoo(fooId);
        return FooDto.fromEntity(foo);
    }

    @GetMapping()
    public Collection<FooDto> getFoos() {
        Collection<Foo> foos = fooService.getFoos();
        return FooDto.fromEntities(foos);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FooDto createFoo(@RequestBody FooDto fooDto) {
        Foo newFoo = fooService.newFoo(fooDto.getName(), fooDto.getDescription());
        return FooDto.fromEntity(newFoo);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveFoo(@RequestBody FooDto fooDto) {
        Foo foo = fooService.getFoo(fooDto.getId());
        fooDto.updateFoo(foo);
        fooService.saveFoo(foo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFoo(@PathVariable("id") Long fooId) {
        fooService.deleteFoo(fooId);
    }

    public void deleteFoos(Collection<Long> fooIds) {
        fooService.deleteFoos(fooIds);
    }
}
