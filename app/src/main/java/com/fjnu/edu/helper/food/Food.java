package com.fjnu.edu.helper.food;

/**
 * Created by ZhouShiqiao on 2017/5/30 0030.
 */

public class Food {
    private String mno;
    private String name;
    private int storage;
    private String addtime;
    private double freshness;
    private double residue;
    private String unit;

    public Food(String mno, String name, int storage, String addtime, double residue, String unit) {
        this.mno = mno;
        this.name = name;
        this.storage = storage;
        this.addtime = addtime;
        this.residue = residue;
        this.unit = unit;
        this.setFreshness();
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public double getFreshness() {
        return freshness;
    }

    public void setFreshness() {

    }

    public double getResidue() {
        return residue;
    }

    public void setResidue(double residue) {
        this.residue = residue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
