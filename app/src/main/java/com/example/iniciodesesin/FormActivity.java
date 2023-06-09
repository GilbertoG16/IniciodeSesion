package com.example.iniciodesesin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iniciodesesin.Models.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {
    EditText txtNombre,txtCorreo,txtCedula,txtContraseña,txtGrupo;
    List<Usuario> users ;
    Usuario usuarioEncontrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        InicializarControles();
        Bundle bundle = getIntent().getExtras();

        users = new ArrayList<Usuario>();
        if(bundle != null){
            List<Usuario> user = (List<Usuario>) bundle.getSerializable("Users");
            Usuario us = (Usuario) bundle.getSerializable("usuario");
            if(user != null){
                users=user;
                usuarioEncontrado=us;
            }
        }

    }

    private void InicializarControles() {
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtCedula = (EditText)findViewById(R.id.txtCedula);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);
        txtGrupo = (EditText)findViewById(R.id.txtGrupo);
    }
    public void AgregarUsuario(View view) {
        String correo = txtCorreo.getText().toString().trim();
        String nombre = txtNombre.getText().toString().trim();
        String cedula = txtCedula.getText().toString().trim();
        String contraseña = txtContraseña.getText().toString().trim();
        String grupo = txtGrupo.getText().toString().trim();

        if (nombre.length() == 0 || cedula.length() == 0 || correo.length() == 0 || contraseña.length() == 0 || grupo.length() == 0) {
            Toast.makeText(getApplicationContext(), "Que sopa kmpa te faltan datos io loco cha madre tú botaste por elprd", Toast.LENGTH_SHORT).show();
        } else {
            boolean correoExistente = false;

            for (Usuario user : users) {
                if (correo.equals(user.getCorreo())) {
                    correoExistente = true;
                    break;
                }
            }

            if (correoExistente) {
                Toast.makeText(getApplicationContext(), "E´te correo ya ta aki brokiz salsa", Toast.LENGTH_SHORT).show();
            } else {
                Usuario nuevoUsuario = new Usuario(nombre, cedula, correo, contraseña, grupo);

                users.add(nuevoUsuario);
                Toast.makeText(getApplicationContext(), "Quedamo así pues", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), PantallaUsuario.class);
                i.putExtra("usuario", (Serializable) usuarioEncontrado);
                i.putExtra("Users", (Serializable) users);
                i.putExtras(nuevoUsuario.UsuarioToBundle());
                startActivity(i);
            }
        }
    }

}