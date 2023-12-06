package org.utl.dsm.dsm406_controlpacientes.Model;

public class Persona {
    public Integer idPersona;
    public String nombrePersona;
    public String apellidoPaternoPersona;
    public String apellidoMaternoPersona;
    public String generoPersona;
    public String coloniaPersona;
    public String fechaNacimientoPersona;
    public String rfcPersona;
    public String curpPersona;
    public String domicilioPersona;
    public String codigoPostalPersona;
    public String ciudadPersona;
    public String estadoPersona;
    public String telefonoPersona;
    public String fotoPersona;
    public int estatus;

    public Persona(Integer idPersona, String nombrePersona, String apellidoPaternoPersona, String apellidoMaternoPersona, String generoPersona, String coloniaPersona, String fechaNacimientoPersona, String rfcPersona, String curpPersona, String domicilioPersona, String codigoPostalPersona, String ciudadPersona, String estadoPersona, String telefonoPersona, String fotoPersona, int estatus) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPaternoPersona = apellidoPaternoPersona;
        this.apellidoMaternoPersona = apellidoMaternoPersona;
        this.generoPersona = generoPersona;
        this.coloniaPersona = coloniaPersona;
        this.fechaNacimientoPersona = fechaNacimientoPersona;
        this.rfcPersona = rfcPersona;
        this.curpPersona = curpPersona;
        this.domicilioPersona = domicilioPersona;
        this.codigoPostalPersona = codigoPostalPersona;
        this.ciudadPersona = ciudadPersona;
        this.estadoPersona = estadoPersona;
        this.telefonoPersona = telefonoPersona;
        this.fotoPersona = fotoPersona;
        this.estatus = estatus;
    }

    public Persona() {
    }

    public Integer getIdPersona() {
            return idPersona;
        }

    public String getColoniaPersona() {
        return coloniaPersona;
    }

    public void setColoniaPersona(String coloniaPersona) {
        this.coloniaPersona = coloniaPersona;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public void setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
        }

        public String getNombrePersona() {
            return nombrePersona;
        }

        public void setNombrePersona(String nombrePersona) {
            this.nombrePersona = nombrePersona;
        }

        public String getApellidoPaternoPersona() {
            return apellidoPaternoPersona;
        }

        public void setApellidoPaternoPersona(String apellidoPaternoPersona) {
            this.apellidoPaternoPersona = apellidoPaternoPersona;
        }

        public String getApellidoMaternoPersona() {
            return apellidoMaternoPersona;
        }

        public void setApellidoMaternoPersona(String apellidoMaternoPersona) {
            this.apellidoMaternoPersona = apellidoMaternoPersona;
        }

        public String getGeneroPersona() {
            return generoPersona;
        }

        public void setGeneroPersona(String generoPersona) {
            this.generoPersona = generoPersona;
        }

        public String getFechaNacimientoPersona() {
            return fechaNacimientoPersona;
        }

        public void setFechaNacimientoPersona(String fechaNacimientoPersona) {
            this.fechaNacimientoPersona = fechaNacimientoPersona;
        }

        public String getRfcPersona() {
            return rfcPersona;
        }

        public void setRfcPersona(String rfcPersona) {
            this.rfcPersona = rfcPersona;
        }

        public String getCurpPersona() {
            return curpPersona;
        }

        public void setCurpPersona(String curpPersona) {
            this.curpPersona = curpPersona;
        }

        public String getDomicilioPersona() {
            return domicilioPersona;
        }

        public void setDomicilioPersona(String domicilioPersona) {
            this.domicilioPersona = domicilioPersona;
        }

        public String getCodigoPostalPersona() {
            return codigoPostalPersona;
        }

        public void setCodigoPostalPersona(String codigoPostalPersona) {
            this.codigoPostalPersona = codigoPostalPersona;
        }

        public String getCiudadPersona() {
            return ciudadPersona;
        }

        public void setCiudadPersona(String ciudadPersona) {
            this.ciudadPersona = ciudadPersona;
        }

        public String getEstadoPersona() {
            return estadoPersona;
        }

        public void setEstadoPersona(String estadoPersona) {
            this.estadoPersona = estadoPersona;
        }

        public String getTelefonoPersona() {
            return telefonoPersona;
        }

        public void setTelefonoPersona(String telefonoPersona) {
            this.telefonoPersona = telefonoPersona;
        }

        public String getFotoPersona() {
            return fotoPersona;
        }

        public void setFotoPersona(String fotoPersona) {
            this.fotoPersona = fotoPersona;
        }
    }