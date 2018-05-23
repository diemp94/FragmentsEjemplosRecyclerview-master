package com.example.armando.fragmentsejemplos.BasesDatos;

import android.content.ContentValues;
import android.content.Context;

import com.example.armando.fragmentsejemplos.R;
import com.example.armando.fragmentsejemplos.RecyclerViewMusica.DetalleMusica;

import java.util.ArrayList;

public class GestorAlbums {

    private Context context;
    public GestorAlbums(Context context)
    {
        this.context = context;

    }

    public ArrayList<DetalleMusica> AsignarAlbums()
    {
        ManejoBasesDatos db = new ManejoBasesDatos(context);
        InsertarCuatroAlbums(db);
        return db.extraerAlbumsDataBase();
    }

    public void InsertarCuatroAlbums(ManejoBasesDatos db)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,"Rola el Deep");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,"Adele");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,"Rolando");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.adele);
        db.InsertarAlbum(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,"Beatles Song");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,"Beatles");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,"Let it be");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.beatles);
        db.InsertarAlbum(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,"Elements of Life");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,"Tiesto");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,"Elements of Life");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.tiesto);
        db.InsertarAlbum(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM,"Mi Carcel");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA,"Marco Antonio Solis");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_CANCION,"Mi Carcel");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.marcosolis);
        db.InsertarAlbum(contentValues);

    }
}
