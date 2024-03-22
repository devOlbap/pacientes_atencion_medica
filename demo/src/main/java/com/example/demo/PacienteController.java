package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PacienteController {

    private List<Atencion> atenciones = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();

    Paciente paciente_1 = new Paciente(1, "Pablo", "Garrido", 19933666, "2", "El Manzano", "2003");
    Paciente paciente_2 = new Paciente(2, "Daniela", "Fuentes", 19199911, "K", "El Roble", "55789");

    Medico medico_1 = new Medico(1, "Dagoberto", "Godoy", "Oncólogo");
    
    public PacienteController(){

        Atencion atencion_1 = new Atencion(1, "2023-12-12", false, paciente_1, medico_1);
        Atencion atencion_2 = new Atencion(2, "2024-01-10", false, paciente_2, medico_1);
        Atencion atencion_3 = new Atencion(3, "2024-02-12", false, paciente_1, medico_1);
        Atencion atencion_4 = new Atencion(4, "2024-04-12", true, paciente_1, medico_1);

        pacientes.add(paciente_1);
        pacientes.add(paciente_2);

        atenciones.add(atencion_1);
        atenciones.add(atencion_2);
        atenciones.add(atencion_3);
        atenciones.add(atencion_4);

        medicos.add(medico_1);

    }

    //______ PACIENTE
    @GetMapping("/pacientes")
    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    @GetMapping("/pacientes/{id}")
    public Paciente obtenerPacienteById(@PathVariable int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null; 
    }
    
    @GetMapping("/pacientes/{id}/atenciones")
    public List<Atencion> obtenerAtencionesPorPaciente(@PathVariable int id) {
        List<Atencion> atencionesPaciente = new ArrayList<>();
        for (Atencion atencion : atenciones) {
            if (atencion.getPaciente().getId() == id) {
                atencionesPaciente.add(atencion);
            }
        }
        return atencionesPaciente;
    }
    @GetMapping("/pacientes/{id}/atenciones/activas")
    public List<Atencion> obtenerAtencionesActivasByPaciente(@PathVariable int id) {
        List<Atencion> atencionesPaciente = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                for (Atencion atencion : atenciones) {
                    if (atencion.getPaciente().getId() == id) {
                        if(atencion.getEstado()){
                            atencionesPaciente.add(atencion);
                        }
                    }
                }
            }
        }
        return atencionesPaciente;
    }

    //____FIN PACIENTE
    //____MEDICO

    @GetMapping("/medico")
    public List<Medico> obtenerMedicos() {
        return medicos;
    }
    @GetMapping("/medico/{id}")
    public Medico obtenerMedicoById(@PathVariable int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null; 
    }
    @GetMapping("/medico/{id}/atenciones")
    public List<Atencion> obtenerAtencionesPorMedico(@PathVariable int id) {
        List<Atencion> atencionesMedico = new ArrayList<>();
        for (Atencion atencion : atenciones) {
            if (atencion.getMedico().getId() == id) {
                atencionesMedico.add(atencion);
            }
        }
        return atencionesMedico;
    }
    // endpoint para obtener roles activos por usuario
    @GetMapping("/medico/{id}/atenciones/activas")
    public List<Atencion> obtenerAtencionesActivasByMedico(@PathVariable int id) {
        List<Atencion> atencionesMedico = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                for (Atencion atencion : atenciones) {
                    if (atencion.getMedico().getId() == id) {
                        if(atencion.getEstado()){
                            atencionesMedico.add(atencion);
                        }
                    }
                }
            }
        }
        return atencionesMedico;
    }
}

