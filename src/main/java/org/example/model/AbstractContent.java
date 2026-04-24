package org.example.model;

public sealed interface AbstractContent permits TextContent, ListContent, OrganizationSection {}
