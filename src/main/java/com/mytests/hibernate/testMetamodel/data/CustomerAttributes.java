package com.mytests.hibernate.testMetamodel.data;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class CustomerAttributes {
    @Basic @Column(name = "vip")
    private Boolean vip;

    @Basic @Column(name = "address")
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return
               "address='" + address + '\'' +
               ", vip=" + vip ;
    }
}
