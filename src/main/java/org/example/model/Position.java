package org.example.model;

import java.time.YearMonth;
import java.util.Objects;

public record Position(YearMonth startDate, YearMonth endDate, String title, String description) {
    public Position {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        if (title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (endDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("endDate must not be before startDate");
        }
    }
}
