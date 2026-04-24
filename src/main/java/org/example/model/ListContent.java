package org.example.model;

import java.util.List;
import java.util.Objects;

public record ListContent(List<String> items) implements AbstractContent {

    public ListContent {
        Objects.requireNonNull(items, "Items must not be null");
        items = List.copyOf(items);
    }
}
