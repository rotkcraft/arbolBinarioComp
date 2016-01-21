package arbol;

import java.util.ArrayList;

/**
 * Creado por hadexexplade el 21/01/16.9:49
 */
public class ArbolBinario<E>
{
    private NodoBinario<E> raiz;
    private int cantidad;

    public ArbolBinario()
    {
        this.cantidad=0;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public Elemento<E> getRaiz()
    {
        return raiz;
    }

    private NodoBinario<E> validar(Elemento<E> elemento)
    {
        if(!(elemento instanceof NodoBinario))
        {
        return null;
        }
        NodoBinario<E> nodoBinario = (NodoBinario<E>)elemento;
        return nodoBinario.getPadre()==nodoBinario ?null:nodoBinario;
    }

    public Elemento<E> obtenerPadre(Elemento<E> elemento)
    {
        return validar(elemento).getPadre();
    }

    public Elemento<E> obtenerHijoIzquierdo(Elemento<E> elemento)
    {
        return validar(elemento).getHijoIzquierdo();
    }

    public Elemento<E> obtenerHijoDerecho(Elemento<E> elemento)
    {
        return validar(elemento).getHijoDerecho();
    }

    public boolean esRaiz(Elemento<E> elemento)
    {
        return elemento==getRaiz();
    }

    public Elemento<E> insertarRaiz(E elemento)
    {
        if(!estaVacia())
        {
            return null;
        }
        raiz=crearNodo(elemento,null,null,null);
        cantidad=1;
        return raiz;
    }

    public Elemento<E> insertarHijoIzquierdo(Elemento<E> elemento,E dato)
    {
         NodoBinario<E> temporal=validar(elemento);
        if(temporal.getHijoIzquierdo()!=null)
        {
            return null;
        }

        NodoBinario<E> hijoIzquierdo=crearNodo(dato,temporal,null,null);
        temporal.setHijoIzquierdo(hijoIzquierdo);
        cantidad++;
        return hijoIzquierdo;
    }

    public Elemento<E> insertarHijoDerecho(Elemento<E> elemento,E dato)
    {
        NodoBinario<E> temporal=validar(elemento);
        if(temporal.getHijoDerecho()!=null)
        {
            return null;
        }

        NodoBinario<E> hijoDerecho=crearNodo(dato,temporal,null,null);
        temporal.setHijoDerecho(hijoDerecho);
        cantidad++;
        return hijoDerecho;
    }

    public Elemento<E> insertar(E dato)
    {
        return insertar(dato,getRaiz());
    }

    private Elemento<E> insertar(E dato, Elemento<E> nodo)
    {
        if(nodo==null)
        {
            return insertarRaiz(dato);
        }
        else if(((Comparable<E>)dato).compareTo(nodo.getElemento())<0)
        {
            if(obtenerHijoIzquierdo(nodo)==null)
            {
                return insertarHijoIzquierdo(validar(nodo),dato);
            }
            return insertar(dato,obtenerHijoIzquierdo(nodo));
        }
        else {
            if(obtenerHijoDerecho(nodo)==null)
            {
                return insertarHijoDerecho(validar(nodo),dato);
            }
            return insertar(dato, obtenerHijoDerecho(nodo));
        }
    }


    private NodoBinario<E> crearNodo(E elemento, NodoBinario<E> padre,
                                     NodoBinario<E> hijoIzquierdo,
                                     NodoBinario<E> hijoDerecho)
    {
        return new NodoBinario<E>(elemento,padre,hijoIzquierdo,hijoDerecho);
    }

    public boolean estaVacia()
    {
        return getCantidad()==0;
    }


    public Iterable<Elemento<E>> obtenerHijos(Elemento<E> elemento)
    {
        ArrayList<Elemento<E>> hijos=new ArrayList<Elemento<E>>(2);
        if(obtenerHijoIzquierdo(elemento)!=null)
        {
            hijos.add(obtenerHijoIzquierdo(elemento));
        }
        if(obtenerHijoDerecho(elemento)!=null)
        {
            hijos.add(obtenerHijoDerecho(elemento));
        }
        return hijos;
    }



    public ArrayList<Elemento<E>> recorridoPreOrden()
    {
        ArrayList<Elemento<E>> elementos=new ArrayList<Elemento<E>>();
        if(!estaVacia())
        {
            recorridoPreOrden(getRaiz(),elementos);
        }

        return elementos;
    }

    private void recorridoPreOrden(Elemento<E> raiz, ArrayList<Elemento<E>> elementos)
    {
        elementos.add(raiz);
        for(Elemento<E> elemento:obtenerHijos(raiz))
        {
            recorridoPreOrden(elemento,elementos);
        }
    }

    public ArrayList<Elemento<E>> recorridoInOrden()
    {
        ArrayList<Elemento<E>> elementos=new ArrayList<Elemento<E>>();
        if(!estaVacia())
        {
             recorridoInOrden(getRaiz(),elementos);
        }

        return elementos;
    }

    private void recorridoInOrden(Elemento<E> raiz, ArrayList<Elemento<E>> elementos)
    {
        if(obtenerHijoIzquierdo(raiz)!=null)
        {
            recorridoInOrden(obtenerHijoIzquierdo(raiz),elementos);
        }
        elementos.add(raiz);
        if(obtenerHijoDerecho(raiz)!=null)
        {
            recorridoInOrden(obtenerHijoDerecho(raiz),elementos);
        }
    }


    public ArrayList<Elemento<E>> recorridoPosOrden()
    {
        ArrayList<Elemento<E>> elementos=new ArrayList<Elemento<E>>();
        if(!estaVacia())
        {
            recorridoPosOrden(getRaiz(), elementos);
        }

        return elementos;
    }

    private void recorridoPosOrden(Elemento<E> raiz, ArrayList<Elemento<E>> elementos)
    {
        for(Elemento<E>elemento:obtenerHijos(raiz))
        {
            recorridoPosOrden(elemento,elementos);
        }

        elementos.add(raiz);
    }


}
