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

public class MainActivity extends AppCompatActivity {
    EditText txtCorreo, txtContraseña;
    Usuario usuarioEncontrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        LoadListView();
    }

    private void InicializarControles() {
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);
    }


    private List<Usuario> LlenarListaDeUsuarios(){
        List<Usuario> users = new ArrayList<Usuario>();
        users.add(new Usuario("Gilberto","8-987-2197","girongg166@hotmail.com","12345"));
        users.add(new Usuario("Sencillo","8-987-2590","eltitere@hotmail.com","12345"));
        users.add(new Usuario("Gilberto","8-987-2197","g","12345"));
        users.add(new Usuario("Manuel","8-987-2197","gg16@hotmail.com","12345"));

        return users;
    }
    private void LoadListView(){

        Bundle b = getIntent().getExtras();
        if(b!=null){
            Usuario user = new Usuario().restoreBundle(b);
            List<Usuario> users = LlenarListaDeUsuarios();
            users.add(user);
        }
        else{

        }

    }
    public void InicioDeSesion(View v){
        List<Usuario> users = this.LlenarListaDeUsuarios();

        try{
            String correo = txtCorreo.getText().toString();
            String contraseña = txtContraseña.getText().toString();

            for(int i = 0;i<users.size();i++){
                if(correo.equals(users.get(i).getCorreo())){
                    if(contraseña.equals(users.get(i).getContraseña())){
                        usuarioEncontrado = users.get(i);

                        Intent intent = new Intent(getApplicationContext(), PantallaUsuario.class);
                        intent.putExtra("usuario",(Serializable) usuarioEncontrado);
                        intent.putExtra("Users",(Serializable) users);
                        startActivity(intent);

                        break;
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }

}