package org.example.model;

import java.util.List;
import java.util.Objects;

public record ListSection(List<String> items) implements Section {

    public ListSection {
        Objects.requireNonNull(items, "Items must not be null");
        items = List.copyOf(items);
    }
}
