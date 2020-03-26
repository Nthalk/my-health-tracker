/*
 * This file is generated by jOOQ.
 */
package com.nthalk.healthtracker.db.models.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = -1283673261;

    private Long  userId;
    private Float normalMinTemperature;
    private Float normalMaxTemperature;

    public User() {}

    public User(User value) {
        this.userId = value.userId;
        this.normalMinTemperature = value.normalMinTemperature;
        this.normalMaxTemperature = value.normalMaxTemperature;
    }

    public User(
        Long  userId,
        Float normalMinTemperature,
        Float normalMaxTemperature
    ) {
        this.userId = userId;
        this.normalMinTemperature = normalMinTemperature;
        this.normalMaxTemperature = normalMaxTemperature;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getNormalMinTemperature() {
        return this.normalMinTemperature;
    }

    public void setNormalMinTemperature(Float normalMinTemperature) {
        this.normalMinTemperature = normalMinTemperature;
    }

    public Float getNormalMaxTemperature() {
        return this.normalMaxTemperature;
    }

    public void setNormalMaxTemperature(Float normalMaxTemperature) {
        this.normalMaxTemperature = normalMaxTemperature;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(userId);
        sb.append(", ").append(normalMinTemperature);
        sb.append(", ").append(normalMaxTemperature);

        sb.append(")");
        return sb.toString();
    }
}