package com.apollo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TUser {
    @Id
    private int id;

    private String email;
    @Column(columnDefinition = "bit default false")
    private boolean send;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", send=" + send +
                '}';
    }
}
