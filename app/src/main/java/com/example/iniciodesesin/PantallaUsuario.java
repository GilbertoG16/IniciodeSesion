package com.example.iniciodesesin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class PantallaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_usuario);
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
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Opcion no habilitada",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}