package br.com.desbravador.gestaoprojetosbackend.converter.dto;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ConverterDto<T, I> {

    Optional<T> convertToDto(Optional<I> domain);

    Optional<I> convertToDomain(Optional<T> dto);

    default Optional<T> convertToDto(I domain) {
        return convertToDto(Optional.ofNullable(domain));
    }

    default T convertToDtoNotOptional(I domain) {
        return convertToDto(Optional.ofNullable(domain)).orElse(null);
    }

    default Optional<I> convertToDomain(T dto) {
        return convertToDomain(Optional.ofNullable(dto));
    }

    default I convertToDomainNotOptional(T dto) {
        return convertToDomain(Optional.ofNullable(dto)).orElse(null);
    }

    default List<T> convertToDtos(Collection<I> domains) {
        return Optional.ofNullable(domains).orElse(Lists.newArrayList()).stream()
                .map(p -> convertToDto(Optional.ofNullable(p)).orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    default List<I> convertToDomains(Collection<T> dtos) {
        return Optional.ofNullable(dtos).orElse(Lists.newArrayList()).stream()
                .map(p -> convertToDomain(Optional.ofNullable(p)).orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
