package org.utl.dsm.dsm406_controlpacientes.Model;

public class Empleado {
    public int idEmpleado;
    public String codigoEmpleado;
    public String fechaIngresoEmpleado;
    public String puestoEmpleado;
    public Float salarioBrutoEmpleado;
    public int activoEmpleado;
    public Persona personaEmpleado;
    public Usuario usuarioEmpleado;
    public Sucursal sucursalEmpleado;

    public Empleado(int idEmpleado, String codigoEmpleado, String fechaIngresoEmpleado, String puestoEmpleado, Float salarioBrutoEmpleado, int activoEmpleado, Persona personaEmpleado, Usuario usuarioEmpleado, Sucursal sucursalEmpleado) {
        this.idEmpleado = idEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
        this.puestoEmpleado = puestoEmpleado;
        this.salarioBrutoEmpleado = salarioBrutoEmpleado;
        this.activoEmpleado = activoEmpleado;
        this.personaEmpleado = personaEmpleado;
        this.usuarioEmpleado = usuarioEmpleado;
        this.sucursalEmpleado = sucursalEmpleado;
    }

    public Empleado() {

    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getFechaIngresoEmpleado() {
        return fechaIngresoEmpleado;
    }

    public void setFechaIngresoEmpleado(String fechaIngresoEmpleado) {
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public Float getSalarioBrutoEmpleado() {
        return salarioBrutoEmpleado;
    }

    public void setSalarioBrutoEmpleado(Float salarioBrutoEmpleado) {
        this.salarioBrutoEmpleado = salarioBrutoEmpleado;
    }

    public int getActivoEmpleado() {
        return activoEmpleado;
    }

    public void setActivoEmpleado(int activoEmpleado) {
        this.activoEmpleado = activoEmpleado;
    }

    public Persona getPersonaEmpleado() {
        return personaEmpleado;
    }

    public void setPersonaEmpleado(Persona personaEmpleado) {
        this.personaEmpleado = personaEmpleado;
    }

    public Usuario getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(Usuario usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    public Sucursal getSucursalEmpleado() {
        return sucursalEmpleado;
    }

    public void setSucursalEmpleado(Sucursal sucursalEmpleado) {
        this.sucursalEmpleado = sucursalEmpleado;
    }
}

