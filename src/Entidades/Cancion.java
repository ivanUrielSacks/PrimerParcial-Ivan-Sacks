package Entidades;

public class Cancion extends Contenido implements Publicitable 
{

    private GeneroMusical generoMusical;
    private CalidadAudio calidadAudio;

    public Cancion(String titulo, int duracion, Artista artista, GeneroMusical generoMusical, CalidadAudio calidadAudio)
    {
        super(titulo, duracion, artista);
        this.generoMusical = generoMusical;
        this.calidadAudio = calidadAudio;
    }

    @Override
    public int getDuracionConPublicidad()
    {
        switch (this.calidadAudio) 
        {
            case BAJA: 
                return this.duracion + 30;
            case MEDIA: 
                return this.duracion + 20;
            case ALTA:
                return this.duracion;
        }
        return this.duracion;
    }

    @Override
    public String toString() 
    {
        return super.toString() + " - Genero: " + this.generoMusical + " - Duracion publicidad: " + getDuracionConPublicidad();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Cancion)) return false;

        Cancion c = (Cancion) obj;
        return this.generoMusical == c.generoMusical;
    }
}