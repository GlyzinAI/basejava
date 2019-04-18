package com.urise.webapp.model;

import java.util.List;

public class Experience {
    private final String title;
    private List<Organization> organizations;

    public Experience(String title, List<Organization> organizations) {
        this.title = title;
        this.organizations = organizations;
    }

    public String getTitle() {
        return title;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return organizations != null ? organizations.equals(that.organizations) : that.organizations == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (organizations != null ? organizations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "title='" + title + '\'' +
                ", organizations=" + organizations +
                '}';
    }
}
