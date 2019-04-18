package com.urise.webapp.model;

import sun.util.resources.LocaleData;

public class Organization {
    private final String companyName;
    private final LocaleData data;
    private final String description;

    public Organization(String companyName, LocaleData data, String description) {
        this.companyName = companyName;
        this.data = data;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocaleData getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = companyName != null ? companyName.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "companyName='" + companyName + '\'' +
                ", data=" + data +
                ", description='" + description + '\'' +
                '}';
    }
}
