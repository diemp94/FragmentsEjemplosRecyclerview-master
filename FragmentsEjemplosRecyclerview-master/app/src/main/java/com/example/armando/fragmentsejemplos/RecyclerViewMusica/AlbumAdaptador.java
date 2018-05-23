package com.example.armando.fragmentsejemplos.RecyclerViewMusica;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.armando.fragmentsejemplos.R;

import java.util.ArrayList;

public class AlbumAdaptador extends RecyclerView.Adapter<AlbumAdaptador.AlbumViewHolder>{

    private ArrayList<DetalleMusica> albums;

    public AlbumAdaptador(ArrayList<DetalleMusica> albums) {
        this.albums = albums;
    }


    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_album,parent,false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int position) {
        final DetalleMusica detalleMusica = albums.get(position);
        albumViewHolder.txtvArtista.setText(detalleMusica.getArtista());
        albumViewHolder.txtvAlbum.setText(detalleMusica.getNombreAlbum());
        albumViewHolder.imgAlbum.setImageResource(detalleMusica.getFotoAlbum());

        albumViewHolder.imgAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Nombre Album" + detalleMusica.getNombreAlbum(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAlbum;
        private TextView txtvAlbum;
        private TextView txtvArtista;


        public AlbumViewHolder(View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.imgAlbum);
            txtvAlbum = itemView.findViewById(R.id.txtvAlbum);
            txtvArtista = itemView.findViewById(R.id.txtvArtista);
        }
    }
}
