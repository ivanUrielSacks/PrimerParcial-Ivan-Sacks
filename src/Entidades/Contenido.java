package Entidades;

import java.util.Random;

public abstract class Contenido implements Comparable<Contenido> 
{

    protected Artista artista;
    protected String titulo;
    protected int duracion;
    protected int likes;
    protected static Random generadorLikes;

    static
    {
        generadorLikes = new Random();
    }

    public Contenido(String titulo, int duracion, Artista artista) 
    {
        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = artista;
    }

    public Contenido(String titulo, int duracion, String nombre, String apellido, String pais) 
    {
        this(titulo, duracion, new Artista(nombre, apellido, pais));
    }

    public int getLikes()
    {
        if (this.likes == 0)
        {
            this.likes = generadorLikes.nextInt(1000000) + 1;
        }
        return this.likes;
    }

    private static String mostrar(Contenido c)
    {
        return c.titulo + " - " + c.artista.getArtista() + " - " + c.duracion + "s - Likes: " + c.likes;
    }

    public static boolean sonIguales(Contenido c1, Contenido c2) 
    {
        if (c1 == null || c2 == null) return false;

        return c1.titulo.equals(c2.titulo) && Artista.sonIguales(c1.artista, c2.artista);
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (obj == null || !(obj instanceof Contenido)) return false;
        Contenido c = (Contenido) obj;
        return sonIguales(this, c);
    }

    @Override
    public String toString()
    {
        return this.titulo + " - " + this.artista.getArtista() + " - Likes: " + getLikes();
    }

    @Override
    public int compareTo(Contenido o)
    {
        int cmpApellido = this.artista.getApellido().compareTo(o.artista.getApellido());
        if (cmpApellido != 0) return cmpApellido;

        int cmpNombre = this.artista.getNombre().compareTo(o.artista.getNombre());
        if (cmpNombre != 0) return cmpNombre;

        return this.titulo.compareTo(o.titulo);
    }
}