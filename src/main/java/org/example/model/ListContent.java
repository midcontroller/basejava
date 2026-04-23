package org.example.model;

import java.util.List;

public record ListContent(List<String> items) implements AbstractContent {
    public ListContent {
        items = List.copyOf(items);
    }
}
