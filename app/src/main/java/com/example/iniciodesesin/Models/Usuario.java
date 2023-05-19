package com.example.iniciodesesin.Models;

public class Usuario {


    private String nombre;
    private String cedula;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, String cedula, String correo, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


}
