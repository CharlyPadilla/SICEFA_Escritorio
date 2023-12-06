package org.utl.dsm.dsm406_controlpacientes.Model;

import org.utl.dsm.dsm406_controlpacientes.Model.Persona;

public class Cliente {
    public Integer idCliente;
    public String emailCliente;
    public String fechaRegistroCliente;
    public int estatusCliente;
    public Persona personaCliente;

    public Cliente(Integer idCliente, String emailCliente, String fechaRegistroCliente, int estatusCliente, Persona personaCliente) {
        this.idCliente = idCliente;
        this.emailCliente = emailCliente;
        this.fechaRegistroCliente = fechaRegistroCliente;
        this.estatusCliente = estatusCliente;
        this.personaCliente = personaCliente;
    }

    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getFechaRegistroCliente() {
        return fechaRegistroCliente;
    }

    public void setFechaRegistroCliente(String fechaRegistroCliente) {
        this.fechaRegistroCliente = fechaRegistroCliente;
    }

    public int getEstatusCliente() {
        return estatusCliente;
    }

    public void setEstatusCliente(int estatusCliente) {
        this.estatusCliente = estatusCliente;
    }

    public Persona getPersonaCliente() {
        return personaCliente;
    }

    public void setPersonaCliente(Persona personaCliente) {
        this.personaCliente = personaCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", emailCliente='" + emailCliente + '\'' +
                ", fechaRegistroCliente='" + fechaRegistroCliente + '\'' +
                ", estatusCliente=" + estatusCliente +
                ", personaCliente=" + personaCliente +
                '}';
    }
}

