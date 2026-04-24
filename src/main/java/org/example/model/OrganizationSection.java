package org.example.model;

import java.util.List;
import java.util.Objects;

public record OrganizationSection(List<Organization> organizations) implements AbstractContent {
    public OrganizationSection {
        Objects.requireNonNull(organizations, "Organizations must not be null");
        organizations = List.copyOf(organizations);
    }
}
