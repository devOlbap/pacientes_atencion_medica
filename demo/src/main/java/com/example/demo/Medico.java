package com.example.demo;

public class Medico {
    private int id;
    private String nombre;
    private String apellido;
    private String profesion;

    public Medico(
        int id,
        String nombre,
        String apellido,
        String profesion
    ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    public int getId(){
        return id;
    }

    public String getFullName(){
        return nombre+' '+apellido;
    }
    public String getProfesion(){
        return profesion;
    }
}
