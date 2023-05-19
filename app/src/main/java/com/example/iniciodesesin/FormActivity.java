package com.example.iniciodesesin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    EditText txtNombre,txtCorreo,txtCedula,txtContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        InicializarControles();
    }

    private void InicializarControles() {
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtCedula = (EditText)findViewById(R.id.txtCedula);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);
    }
    public void AgregarUsuario(View view){
        try {

        }catch(Exception e){

        }
    }
}