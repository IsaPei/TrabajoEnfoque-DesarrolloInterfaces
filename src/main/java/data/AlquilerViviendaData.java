package data;

import java.sql.Date;

public class AlquilerViviendaData {

    private String codReferencia;
    private int numExpediente;
    private java.sql.Date fechaEntrada;
    private int tiempoEstimado;
    private String estado;
    private String nombreCliente;
    private String dniCliente;
    private String correoCliente;
    private int telefonoCliente;
    private double facturacion;

    public AlquilerViviendaData(String codReferencia, int numExpediente, Date fechaEntrada, int tiempoEstimado, String estado, String nombreCliente, String dniCliente, String correoCliente, int telefonoCliente, double facturacion) {
        this.codReferencia = codReferencia;
        this.numExpediente = numExpediente;
        this.fechaEntrada = fechaEntrada;
        this.tiempoEstimado = tiempoEstimado;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.facturacion = facturacion;
    }

    public String getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }

    @Override
    public String toString() {
        return "AlquilerViviendaData{" + "codReferencia=" + codReferencia + ", numExpediente=" + numExpediente + ", fechaEntrada=" + fechaEntrada + ", tiempoEstimado=" + tiempoEstimado + ", estado=" + estado + ", nombreCliente=" + nombreCliente + ", dniCliente=" + dniCliente + ", correoCliente=" + correoCliente + ", telefonoCliente=" + telefonoCliente + ", facturacion=" + facturacion + '}';
    }

}
