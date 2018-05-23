package com.example.armando.fragmentsejemplos.BasesDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.armando.fragmentsejemplos.RecyclerViewMusica.DetalleMusica;

import java.util.ArrayList;

public class ManejoBasesDatos extends SQLiteOpenHelper{

    Context context;

    public ManejoBasesDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME,null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTableAlbum= "CREATE TABLE " + ConstantesBaseDatos.TABLE_ALBUMS + "("  +
                                        ConstantesBaseDatos.TABLE_ALBUMS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_ALBUMS_CANCION + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_ALBUMS_FOTO + " INTEGER" +
                                        ")";
        db.execSQL(queryCrearTableAlbum);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF" + "EXIST" + ConstantesBaseDatos.TABLE_ALBUMS );
        onCreate(db);
    }

    public ArrayList<DetalleMusica> extraerAlbumsDataBase()
    {
        ArrayList<DetalleMusica> albums = new ArrayList<>();
        String query ="SELECT * FROM " + ConstantesBaseDatos.TABLE_ALBUMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext())
        {
            DetalleMusica albumactual= new DetalleMusica();
            albumactual.setNombreAlbum(registros.getString(1));
            albumactual.setArtista(registros.getString(2));
            albumactual.setNombreCancion(registros.getString(3));
            albumactual.setFotoAlbum(registros.getInt(4));
            albums.add(albumactual);
        }
        db.close();
        return albums;
    }

    public void InsertarAlbum(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_ALBUMS,null,contentValues);
        db.close();

    }
}
