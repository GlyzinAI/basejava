package com.urise.webapp.model;

/**
 * Initial resume class
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 22.03.2019.
 */
public class Resume {

    // Unique identifier
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
