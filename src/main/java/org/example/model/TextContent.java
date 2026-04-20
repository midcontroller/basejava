package org.example.model;

import java.util.Objects;

public class TextContent extends AbstractSection {
    private final String text;

    public TextContent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TextContent other = (TextContent) obj;
        return Objects.equals(text, other.text);
    }
}
