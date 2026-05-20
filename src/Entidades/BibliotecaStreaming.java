package Entidades;

import java.util.ArrayList;
import java.util.Collections;

public class BibliotecaStreaming
{

    private int capacidad;
    private ArrayList<Contenido> contenidos;

    public BibliotecaStreaming() 
    {
        this.capacidad = 3;
        this.contenidos = new ArrayList<>();
    }

    public BibliotecaStreaming(int capacidad) 
    {
        this.capacidad = capacidad;
        this.contenidos = new ArrayList<>();
    }

    private boolean sonIguales(Contenido c) 
    {
        for (Contenido cont : contenidos)
        {
            if (cont.equals(c)) return true;
        }
        return false;
    }

    public void agregar(Contenido c) 
    {
        if (contenidos.size() >= capacidad)
        {
            System.out.println("No hay lugar en la biblioteca");
        } 
        else if (sonIguales(c))
        {
            System.out.println("El contenido ya existe");
        } 
        else {
            contenidos.add(c);
            System.out.println("Contenido agregado");
        }
    }

    private int getDuracionContenido(TipoContenido tipo) 
    {
        switch (tipo)
        {
            case CANCIONES: return getDuracionCanciones();
            case PODCASTS: return getDuracionPodcasts();
            case TODOS: return getDuracionTotal();
        }
        return 0;
    }

    private int getDuracionCanciones() 
    {
        int total = 0;
        for (Contenido c : contenidos) 
        {
            if (c instanceof Cancion) 
            {
                total += ((Cancion) c).getDuracionConPublicidad();
            }
        }
        return total;
    }

    private int getDuracionPodcasts() 
    {
        int total = 0;
        for (Contenido c : contenidos) 
        {
            if (c instanceof Podcast)
            {
                total += ((Podcast) c).getDuracionConPublicidad();
            }
        }
        return total;
    }

    private int getDuracionTotal() 
    {
        int total = 0;
        for (Contenido c : contenidos) 
        {
            total += ((Publicitable) c).getDuracionConPublicidad();
        }
        return total;
    }

    private void ordenar()
    {
        Collections.sort(contenidos);
    }

    @Override
    public String toString()
    {
        ordenar();

        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad: ").append(contenidos.size()).append("\n\n");

        for (Contenido c : contenidos) {
            sb.append(c.toString()).append("\n");
        }

        sb.append("\n Duracion Canciones: ").append(getDuracionCanciones());
        sb.append("\n Duracion Podcasts: ").append(getDuracionPodcasts());
        sb.append("\n Duracion Total: ").append(getDuracionTotal());

        return sb.toString();
    }
}