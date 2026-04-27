package org.example.model;

public sealed interface Section permits TextSection, ListSection, OrganizationSection {
}
