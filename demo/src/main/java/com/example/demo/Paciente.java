package com.example.demo;

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private int rut;
    private String dv;
    private String direccion;
    private String numeracion;

    public Paciente(
        int id,
        String nombre,
        String apellido,
        int rut,
        String dv,
        String direccion,
        String numeracion
    ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.dv = dv;
        this.direccion = direccion;
        this.numeracion = numeracion;
    }

    public int getId(){
        return id;
    }
    public String getRut(){
        return rut+"-"+dv;
    }
    public String getFullName(){
        return nombre+' '+apellido;
    }
    
    public String getDireccion(){
        return direccion+' '+numeracion;
    }





}
