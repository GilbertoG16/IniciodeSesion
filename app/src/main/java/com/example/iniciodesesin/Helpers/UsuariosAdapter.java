package com.example.iniciodesesin.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.iniciodesesin.Models.Usuario;
import com.example.iniciodesesin.R;

import java.util.List;

public class UsuariosAdapter extends ArrayAdapter<Usuario> {
    List<Usuario> opciones;
    public UsuariosAdapter(Context context, List<Usuario> datos){
        super(context, R.layout.listviewusuarios,datos);

        opciones=datos;
    }
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listviewusuarios,null);

        TextView nombre = (TextView) item.findViewById(R.id.txtNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView correo = (TextView)item.findViewById(R.id.txtCorreo);
        correo.setText(opciones.get(position).getCorreo());

        TextView grupo = (TextView)item.findViewById(R.id.txtGrupo);
        grupo.setText(opciones.get(position).getGrupo());

        return item;
    }
}
