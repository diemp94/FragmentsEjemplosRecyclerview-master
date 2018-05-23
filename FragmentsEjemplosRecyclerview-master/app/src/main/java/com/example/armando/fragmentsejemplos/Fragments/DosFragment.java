package com.example.armando.fragmentsejemplos.Fragments;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.armando.fragmentsejemplos.BasesDatos.GestorAlbums;
import com.example.armando.fragmentsejemplos.BasesDatos.ManejoBasesDatos;
import com.example.armando.fragmentsejemplos.MainActivity;
import com.example.armando.fragmentsejemplos.R;
import com.example.armando.fragmentsejemplos.RecyclerViewMusica.AlbumAdaptador;
import com.example.armando.fragmentsejemplos.RecyclerViewMusica.DetalleMusica;

import java.util.ArrayList;

public class DosFragment extends Fragment {

    ArrayList<DetalleMusica> albums, albumsAct;
    private RecyclerView listaAlbums;

    private String getChange;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_dos,container,false);

        listaAlbums= v.findViewById(R.id.rcListaContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

       //FragmentTransaction ft = getFragmentManager().beginTransaction();
       //ft.detach(this).attach(this).commit();

            listaAlbums.setLayoutManager(llm);
            IniciarlizarListaContactos();
            IniciarAdaptador();



        return v;
    }

    private void IniciarAdaptador()
    {
        AlbumAdaptador miAdaptador = new AlbumAdaptador(albums);
        listaAlbums.setAdapter(miAdaptador);


    }

    private void IniciarlizarListaContactos() {

        GestorAlbums gestorAlbums = new GestorAlbums(this.getActivity());
        albums = gestorAlbums.AsignarAlbums();
        albumsAct = albums;
        for(int i=0; i< albums.size(); i++){
            for(int j=0; j< albumsAct.size(); j++){
                if(albums.get(i).getNombreCancion().matches(albumsAct.get(j).getNombreCancion()) && i != j){
                    albumsAct.remove(j);
                }
            }
        }
    }

    public  String recibir(String msg){
        getChange = msg;
        Log.i("DATO",getChange);
        return getChange;
    }
}
