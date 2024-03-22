package com.example.demo;


public class Atencion {
    private int id;
    private String fecha_atencion;
    private boolean estado;
    private Paciente paciente;
    private Medico medico;

    public Atencion(
        int id,
        String fecha_atencion,
        boolean estado,
        Paciente paciente,
        Medico medico
    ){
        this.id =  id;
        this.fecha_atencion =  fecha_atencion;
        this.estado =  estado;
        this.paciente =  paciente;
        this.medico =  medico;
    }


    public int getId(){
        return id;
    }
    public String getFechaAtencion(){
        return fecha_atencion;
    }
    public boolean getEstado(){
        return estado;
    }
    public Medico getMedico(){
        return medico;
    }
    public Paciente getPaciente(){
        return paciente;
    }


}
