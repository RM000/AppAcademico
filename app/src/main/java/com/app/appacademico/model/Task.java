package com.app.appacademico.model;

public class Task {
    private int id;
    private int id_discipline;
    private String name;
    private int type;
    private float value;
    private float grade; //nota

    public Task() {
        super();
        this.id = 0;
        this.id_discipline = 0;
        this.name = "";
        this.type = 0;
        this.value = 0;
        this.grade = 0;
    }

    public void setIdDiscipline(int id){
        this.id_discipline = id;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setType(int t) {
        this.type = t;
    }

    public void setValue(float v){
        this.value = v;
    }

    public void setGrade(float g){
        this.grade = g;
    }

    public int getId(){
        return this.id;
    }

    public int getIdDiscipline(){
        return this.id_discipline;
    }

    public String getName(){
        return this.name;
    }

    public int getType(){
        return this.type;
    }

    public float getValue(){
        return this.value;
    }

    public float getGrade(){
        return this.grade;
    }
}
