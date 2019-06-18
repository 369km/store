package com.fudo.store.model;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseModel{
    @Column(name = "name")
    private String name;
    @Column(name = "weichat")
    private String weichat;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
