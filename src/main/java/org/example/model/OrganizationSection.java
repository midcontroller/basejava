package org.example.model;

import java.util.List;

public record OrganizationSection(List<Organization> organizations) implements AbstractContent {
    public OrganizationSection {
        organizations = List.copyOf(organizations);
    }
}
