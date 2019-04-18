package com.urise.webapp.model;

import java.util.List;

public class Ability {
    private final String title;
    private List<String> list;

    public Ability(String title, List<String> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ability ability = (Ability) o;

        if (title != null ? !title.equals(ability.title) : ability.title != null) return false;
        return list != null ? list.equals(ability.list) : ability.list == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
