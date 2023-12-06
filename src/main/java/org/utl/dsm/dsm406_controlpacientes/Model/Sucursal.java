package org.utl.dsm.dsm406_controlpacientes.Model;

public class Sucursal {
    public int idSucursal;
    public String nombreSucursal;
    public String titularSucursal;
    public String rfcSucursal;
    public String domicilioSucursal;
    public String coloniaSucursal;
    public String codigoPostalSucursal;
    public String ciudadSucursal;
    public String estadoSucursal;
    public String telefonoSucursal;
    public String latitulSucursal;
    public String longitudSucursal;
    public boolean estatusSucursal;

    public Sucursal(String nombreSucursal, String titularSucursal, String rfcSucursal, String domicilioSucursal, String coloniaSucursal, String codigoPostalSucursal, String ciudadSucursal, String estadoSucursal, String telefonoSucursal, String latitulSucursal, String longitudSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.titularSucursal = titularSucursal;
        this.rfcSucursal = rfcSucursal;
        this.domicilioSucursal = domicilioSucursal;
        this.coloniaSucursal = coloniaSucursal;
        this.codigoPostalSucursal = codigoPostalSucursal;
        this.ciudadSucursal = ciudadSucursal;
        this.estadoSucursal = estadoSucursal;
        this.telefonoSucursal = telefonoSucursal;
        this.latitulSucursal = latitulSucursal;
        this.longitudSucursal = longitudSucursal;
    }

    public Sucursal(int idSucursal, String nombreSucursal, String titularSucursal, String rfcSucursal, String domicilioSucursal, String coloniaSucursal, String codigoPostalSucursal, String ciudadSucursal, String estadoSucursal, String telefonoSucursal, String latitulSucursal, String longitudSucursal, boolean estatusSucursal) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.titularSucursal = titularSucursal;
        this.rfcSucursal = rfcSucursal;
        this.domicilioSucursal = domicilioSucursal;
        this.coloniaSucursal = coloniaSucursal;
        this.codigoPostalSucursal = codigoPostalSucursal;
        this.ciudadSucursal = ciudadSucursal;
        this.estadoSucursal = estadoSucursal;
        this.telefonoSucursal = telefonoSucursal;
        this.latitulSucursal = latitulSucursal;
        this.longitudSucursal = longitudSucursal;
        this.estatusSucursal = estatusSucursal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getTitularSucursal() {
        return titularSucursal;
    }

    public void setTitularSucursal(String titularSucursal) {
        this.titularSucursal = titularSucursal;
    }

    public String getRfcSucursal() {
        return rfcSucursal;
    }

    public void setRfcSucursal(String rfcSucursal) {
        this.rfcSucursal = rfcSucursal;
    }

    public String getDomicilioSucursal() {
        return domicilioSucursal;
    }

    public void setDomicilioSucursal(String domicilioSucursal) {
        this.domicilioSucursal = domicilioSucursal;
    }

    public String getColoniaSucursal() {
        return coloniaSucursal;
    }

    public void setColoniaSucursal(String coloniaSucursal) {
        this.coloniaSucursal = coloniaSucursal;
    }

    public String getCodigoPostalSucursal() {
        return codigoPostalSucursal;
    }

    public void setCodigoPostalSucursal(String codigoPostalSucursal) {
        this.codigoPostalSucursal = codigoPostalSucursal;
    }

    public String getCiudadSucursal() {
        return ciudadSucursal;
    }

    public void setCiudadSucursal(String ciudadSucursal) {
        this.ciudadSucursal = ciudadSucursal;
    }

    public String getEstadoSucursal() {
        return estadoSucursal;
    }

    public void setEstadoSucursal(String estadoSucursal) {
        this.estadoSucursal = estadoSucursal;
    }

    public String getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(String telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }

    public String getLatitulSucursal() {
        return latitulSucursal;
    }

    public void setLatitulSucursal(String latitulSucursal) {
        this.latitulSucursal = latitulSucursal;
    }

    public String getLongitudSucursal() {
        return longitudSucursal;
    }

    public void setLongitudSucursal(String longitudSucursal) {
        this.longitudSucursal = longitudSucursal;
    }

    public boolean isEstatusSucursal() {
        return estatusSucursal;
    }

    public void setEstatusSucursal(boolean estatusSucursal) {
        this.estatusSucursal = estatusSucursal;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "idSucursal=" + idSucursal +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", titularSucursal='" + titularSucursal + '\'' +
                ", rfcSucursal='" + rfcSucursal + '\'' +
                ", domicilioSucursal='" + domicilioSucursal + '\'' +
                ", coloniaSucursal='" + coloniaSucursal + '\'' +
                ", codigoPostalSucursal='" + codigoPostalSucursal + '\'' +
                ", ciudadSucursal='" + ciudadSucursal + '\'' +
                ", estadoSucursal='" + estadoSucursal + '\'' +
                ", telefonoSucursal='" + telefonoSucursal + '\'' +
                ", latitulSucursal='" + latitulSucursal + '\'' +
                ", longitudSucursal='" + longitudSucursal + '\'' +
                ", estatusSucursal=" + estatusSucursal +
                '}';
    }
}
