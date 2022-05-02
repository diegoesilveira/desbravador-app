package br.com.desbravador.gestaoprojetosbackend.converter.entity;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ConverterEntity<T, I> {

    Optional<T> convertToEntity(Optional<I> domain);

    Optional<I> convertToDomain(Optional<T> entity);

    default Optional<T> convertToEntity(I domain) {
        return convertToEntity(Optional.ofNullable(domain));
    }

    default T convertToEntityNotOptional(I domain) {
        return convertToEntity(Optional.ofNullable(domain)).orElse(null);
    }

    default Optional<I> convertToDomain(T entity) {

        return convertToDomain(Optional.ofNullable(entity));
    }

    default I convertToDomainNotOptional(T entity) {

        return convertToDomain(Optional.ofNullable(entity)).orElse(null);
    }

    default List<T> convertToEntities(Collection<I> domains) {
        return Optional.ofNullable(domains).orElse(Lists.newArrayList()).stream()
                .map(p -> convertToEntity(Optional.ofNullable(p)).orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    default List<I> convertToDomains(Collection<T> entities) {
        return Optional.ofNullable(entities).orElse(Lists.newArrayList()).stream()
                .map(p -> convertToDomain(Optional.ofNullable(p)).orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());
    }


}
