package de.johngockel.service.api.core.service;

import de.johngockel.service.api.core.dto.FooDto;

import java.util.Collection;

public interface FooApiService {

    FooDto getFoo(Long fooId);
    Collection<FooDto> getFoos();

    FooDto createFoo(FooDto fooDto);

    void saveFoo(FooDto foo);

    void deleteFoo(Long fooId);
    void deleteFoos(Collection<Long> fooIds);
}
