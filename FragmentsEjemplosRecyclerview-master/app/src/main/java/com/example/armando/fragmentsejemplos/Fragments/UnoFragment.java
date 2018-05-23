package com.example.armando.fragmentsejemplos.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.armando.fragmentsejemplos.BasesDatos.ConstantesBaseDatos;
import com.example.armando.fragmentsejemplos.BasesDatos.GestorAlbums;
import com.example.armando.fragmentsejemplos.BasesDatos.ManejoBasesDatos;
import com.example.armando.fragmentsejemplos.Comunicacion;
import com.example.armando.fragmentsejemplos.R;
import com.example.armando.fragmentsejemplos.RecyclerViewMusica.AlbumAdaptador;
import com.example.armando.fragmentsejemplos.RecyclerViewMusica.DetalleMusica;

import java.util.ArrayList;

public class UnoFragment extends Fragment {


    private String album;
    private String nombre;
    private String cancion;
    public ArrayList<DetalleMusica> albums1;
    private Comunicacion EM;

    private boolean actualizar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Button btnAgregar;
        final EditText editTextALbum, editTextNombre, editTextCancion;
        View v= inflater.inflate(R.layout.fragment_uno,container,false);
        btnAgregar = (Button) v.findViewById(R.id.buttonAgregar);
        editTextALbum = (EditText) v.findViewById(R.id.editTextAlbum);
        editTextNombre = (EditText) v.findViewById(R.id.editTextNombre);
        editTextCancion = (EditText) v.findViewById(R.id.editTextNombre);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                album = editTextALbum.getText().toString();
                nombre = editTextNombre.getText().toString();
                cancion = editTextCancion.getText().toString();

                AsignarAlbums(album,nombre,cancion);
                Toast.makeText(v.getContext(),"Album Agregado",Toast.LENGTH_SHORT).show();

                //EM.enviarDatos("True");

            }
        });
        return v;
    }

    public ArrayList<DetalleMusica> AsignarAlbums(String album, String nombre, String cancion)
    {
        ManejoBasesDatos db = new ManejoBasesDatos(getContext());
        addSong(album,nombre,cancion,db);
        return db.extraerAlbumsDataBase();
    }

    private void addSong(String album, String nombre, String cancion, ManejoBasesDatos db) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,album);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,nombre);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,cancion);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.album_nuevo);
        IniciarlizarListaCanciones();
        db.InsertarAlbum(contentValues);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void IniciarlizarListaCanciones() {

        GestorAlbums gestorAlbums = new GestorAlbums(this.getActivity());
        albums1 = gestorAlbums.AsignarAlbums();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            EM = (Comunicacion) context;
        }catch (Exception e) {
            throw new ClassCastException(context.toString()+"No se pudo");
        }
    }

/* public ArrayList<DetalleMusica> AsignarAlbums(String album,String nombre, String cancion)
    {
        ManejoBasesDatos db = new ManejoBasesDatos(getContext());
        SQLiteDatabase db1 = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,album);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,nombre);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,cancion);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.album_nuevo);

        Long idResultante = db1.insert(ConstantesBaseDatos.DATABASE_NAME,ConstantesBaseDatos.TABLE_ALBUMS,contentValues);


        addSong(album,nombre,cancion,db1);
        return db.extraerAlbumsDataBase();
    }

    private void addSong(String album, String nombre, String cancion, ManejoBasesDatos db) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,album);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,nombre);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,cancion);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.album_nuevo);
        db.InsertarAlbum(contentValues);
    }*/

}
