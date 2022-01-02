package com.syssolution.ssonline;

public class PackagesModel {

    private String name;
    private String charge;
    private String speed;

    public PackagesModel(String name, String charge, String speed) {
        this.name = name;
        this.charge = charge;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
