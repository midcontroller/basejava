package org.example.model;

import java.util.Objects;

public record TextSection(String text) implements Section {
    public TextSection {
        Objects.requireNonNull(text);
    }
}
