/*
 * This file is generated by jOOQ.
 */
package com.nthalk.healthtracker.db.models.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserToken implements Serializable {

    private static final long serialVersionUID = 420148294;

    private Long   userId;
    private String token;

    public UserToken() {}

    public UserToken(UserToken value) {
        this.userId = value.userId;
        this.token = value.token;
    }

    public UserToken(
        Long   userId,
        String token
    ) {
        this.userId = userId;
        this.token = token;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserToken (");

        sb.append(userId);
        sb.append(", ").append(token);

        sb.append(")");
        return sb.toString();
    }
}