package org.example.model;

import java.util.List;
import java.util.Objects;

public record Organization(String name, String url, List<Position> positions) {
    public Organization {
        Objects.requireNonNull(name, "name must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        Objects.requireNonNull(positions, "positions must not be null");
        positions = List.copyOf(positions);
    }
}
