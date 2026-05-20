package Entidades;

public class Podcast extends Contenido implements Publicitable
{

    private TipoPodcast tipoPodcast;

    public Podcast(String titulo, int duracion, String nombre, String apellido, String pais, TipoPodcast tipoPodcast)
    {
        super(titulo, duracion, nombre, apellido, pais);
        this.tipoPodcast = tipoPodcast;
    }

    @Override
    public int getDuracionConPublicidad()
    {
        switch (this.tipoPodcast)
        {
            case TECNOLOGIA: return this.duracion + 60;
            case ENTRETENIMIENTO: return this.duracion + 45;
            case EDUCACION: return this.duracion + 20;
        }
        return this.duracion;
    }

    @Override
    public String toString() 
    {
        return super.toString() + " - Tipo: " + this.tipoPodcast + " - Duracion publicidad: " + getDuracionConPublicidad();
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Podcast)) return false;

        Podcast p = (Podcast) obj;
        return this.tipoPodcast == p.tipoPodcast;
    }
}