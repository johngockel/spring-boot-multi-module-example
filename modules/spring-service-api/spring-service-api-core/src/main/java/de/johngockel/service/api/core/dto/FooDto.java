package de.johngockel.service.api.core.dto;

import de.johngockel.service.core.entity.foo.Foo;

import java.util.ArrayList;
import java.util.Collection;

public class FooDto {

    private Long id;
    private String name;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void updateFoo(Foo foo) {
        foo.setName(name);
        foo.setDescription(description);
    }

    public static FooDto fromEntity(Foo foo) {
        FooDto newFooDto = new FooDto();
        newFooDto.setId(foo.getId());
        newFooDto.setName(foo.getName());
        newFooDto.setDescription(foo.getDescription());
        return newFooDto;
    }

    public static Collection<FooDto> fromEntities(Collection<Foo> foos) {
        Collection<FooDto> fooDtos = new ArrayList<FooDto>();
        for(Foo foo: foos) {
            FooDto fooDto = fromEntity(foo);
            fooDtos.add(fooDto);
        }
        return fooDtos;
    }
}
