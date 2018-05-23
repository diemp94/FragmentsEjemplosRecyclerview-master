package com.example.armando.fragmentsejemplos.RecyclerViewMusica;

public class DetalleMusica  {
    private String nombreAlbum;
    private String artista;
    private String nombreCancion;
    private int fotoAlbum;

    public DetalleMusica(){

    }


    public DetalleMusica(String nombreAlbum, String artista, String nombreCancion, int fotoAlbum) {
        this.nombreAlbum = nombreAlbum;
        this.artista = artista;
        this.nombreCancion = nombreCancion;
        this.fotoAlbum = fotoAlbum;
    }



    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public int getFotoAlbum() {
        return fotoAlbum;
    }

    public void setFotoAlbum(int fotoAlbum) {
        this.fotoAlbum = fotoAlbum;
    }

}
