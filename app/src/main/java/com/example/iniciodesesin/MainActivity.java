package com.example.iniciodesesin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iniciodesesin.Models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Usuario> users;
    EditText txtCorreo, txtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();

         users = LlenarListaDeUsuarios();
    }

    private void InicializarControles() {
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);
    }
    private List<Usuario> LlenarListaDeUsuarios(){
        List<Usuario> users = new ArrayList<>();
        users.add(new Usuario("Gilberto","8-987-2197","girongg166@hotmail.com","12345"));
        users.add(new Usuario("Sencillo","8-987-2590","eltitere@hotmail.com","12345"));
        users.add(new Usuario("Gilberto","8-987-2197","girongg166@hotmail.com","12345"));

        return users;
    }
    public void InicioDeSesion(View v){
        boolean c=false;
        try{
            String correo = txtCorreo.getText().toString();
            String contraseña = txtContraseña.getText().toString();

            for(int i = 0;i<users.size();i++){
                if(correo.equals(users.get(i).getCorreo())){
                    if(contraseña.equals(users.get(i).getContraseña())){
                        Intent intent = new Intent(getApplicationContext(), PantallaUsuario.class);
                        startActivity(intent);
                        c=true;
                    }
                }
                else if(c==false){
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }
}