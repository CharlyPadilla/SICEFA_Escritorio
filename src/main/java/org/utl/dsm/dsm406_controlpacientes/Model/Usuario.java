package org.utl.dsm.dsm406_controlpacientes.Model;

public class Usuario {
    public Integer idUsuario;
    public String nombreUsuario;
    public String contraseniaUsuario;
    public String rolUsuario;

    public Usuario(Integer idUsuario, String nombreUsuario, String contraseniaUsuario, String rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.rolUsuario = rolUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}
