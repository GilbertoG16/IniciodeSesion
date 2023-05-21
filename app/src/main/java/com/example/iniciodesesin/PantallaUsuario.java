package com.example.iniciodesesin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iniciodesesin.Helpers.UsuariosAdapter;
import com.example.iniciodesesin.Models.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PantallaUsuario extends AppCompatActivity {
    TextView nombre,cedula,grupo,c;
    List<Usuario> users;
    Usuario usuarioEncontrado;
    UsuariosAdapter usuariosAdapter;
    ListView lstUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_usuario);
        lstUsu = (ListView)findViewById(R.id.lstUsu);
        InicalizarControles();

        Bundle bundle = getIntent().getExtras();
        users = new ArrayList<Usuario>();
        if(bundle != null){
            List<Usuario> user = (List<Usuario>) bundle.getSerializable("Users");
            Usuario us = (Usuario) bundle.getSerializable("usuario");
            Usuario usu = new Usuario().restoreBundle(bundle);
            users.add(usu);

            if(user != null){
                users=user;
                usuarioEncontrado=us;
            }
        }
        MostrarDatos();
        Toast.makeText(getApplicationContext(), "Bienvenido "+usuarioEncontrado.getNombre() , Toast.LENGTH_SHORT).show();


        usuariosAdapter = new UsuariosAdapter(
                getApplicationContext(),
                users
        );
        lstUsu.setAdapter(usuariosAdapter);


    }

    private void InicalizarControles() {
        nombre = (TextView)findViewById(R.id.txtNombre);
        cedula = (TextView)findViewById(R.id.txtCedula);
        grupo = (TextView)findViewById(R.id.txtGrupo);
    }
    protected void MostrarDatos(){
        if(usuarioEncontrado != null){
            nombre.setText(usuarioEncontrado.getNombre());
            cedula.setText(usuarioEncontrado.getCedula());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.miNew){
            Intent i = new Intent(getApplicationContext(),FormActivity.class);
            i.putExtra("usuario",(Serializable) usuarioEncontrado);
            i.putExtra("Users",(Serializable) users);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Opcion no habilitada",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}