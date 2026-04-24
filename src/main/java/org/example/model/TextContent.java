package org.example.model;

import java.util.Objects;

public record TextContent(String text) implements AbstractContent {
    public TextContent {
        Objects.requireNonNull(text);
    }
}
