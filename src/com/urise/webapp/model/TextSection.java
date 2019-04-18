package com.urise.webapp.model;

public class TextSection extends Section {
    private final String title;
    private final String content;

    public TextSection(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
