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
    EditText txtNombre,txtCorreo,txtCedula,txtContraseña;
    List<Usuario> users ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        InicializarControles();
        Bundle bundle = getIntent().getExtras();

        users = new ArrayList<Usuario>();
        if(bundle != null){
            List<Usuario> user = (List<Usuario>) bundle.getSerializable("Users");
            if(user != null){
                users=user;
            }
        }
        Toast.makeText(getApplicationContext(), "Número de usuarios: " + users.size()+" ", Toast.LENGTH_SHORT).show();
    }

    private void InicializarControles() {
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtCedula = (EditText)findViewById(R.id.txtCedula);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);
    }
    public void AgregarUsuario(View view){
        String correo = txtCorreo.getText().toString();
        boolean correoExistente = false;

        for (Usuario user : users) {
            if (correo.equals(user.getCorreo())) {
                correoExistente = true;
                break;
            }
        }

        if (correoExistente) {
            Toast.makeText(getApplicationContext(), "El correo ya existe", Toast.LENGTH_SHORT).show();
        } else {
            Usuario nuevoUsuario = new Usuario(
                    txtNombre.getText().toString(),
                    txtCedula.getText().toString(),
                    txtCorreo.getText().toString(),
                    txtContraseña.getText().toString()
            );

            users.add(nuevoUsuario);
            Toast.makeText(getApplicationContext(), "Usuario agregado", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), PantallaUsuario.class);
            intent.putExtra("Users", (Serializable) users);
            intent.putExtra("usuario", nuevoUsuario);
            startActivity(intent);
        }

    }
}