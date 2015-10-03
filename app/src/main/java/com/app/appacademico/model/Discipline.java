package com.app.appacademico.model;

/**
 * Created by marialuisa on 11/09/15.
 */
public class Discipline {
    private int id;
    private String name;
    private float totalPoints;
    private float minimumRequired;

    public Discipline() {
        super();
        this.id = 0;
        this.name = "";
        this.totalPoints = 0;
        this.minimumRequired = 0;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setTotalPoints(float tp){
        this.totalPoints = tp;
    }

    public void setMinimumRequired(float mr){
        this.minimumRequired = mr;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public float getTotalPoints(){
        return totalPoints;
    }

    public float getMinimumRequired(){
        return minimumRequired;
    }
}
