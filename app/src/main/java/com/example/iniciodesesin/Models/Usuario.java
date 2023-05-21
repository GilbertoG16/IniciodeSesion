package com.example.iniciodesesin.Models;

import android.os.Bundle;



import androidx.annotation.NonNull;

import java.io.Serializable;


public class Usuario implements Serializable {


    private String nombre;
    private String cedula;
    private String correo;
    private String contraseña;



    private String grupo;
    public Usuario(){

    }

    public Usuario(String nombre, String cedula, String correo, String contraseña,String grupo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
        this.grupo=grupo;
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
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Bundle UsuarioToBundle(){
        Bundle b = new Bundle();
        b.putString("nombre",this.getNombre());
        b.putString("cedula",this.getCedula());
        b.putString("correo",this.getCorreo());
        b.putString("contraseña",this.getContraseña());
        b.putString("grupo",this.getGrupo());
        return b;
    }

    public Usuario restoreBundle(Bundle b){
        return new Usuario(
                b.getString("nombre"),
                b.getString("cedula"),
                b.getString("correo"),
                b.getString("contraseña"),
                b.getString("grupo")
        );
    }



}
