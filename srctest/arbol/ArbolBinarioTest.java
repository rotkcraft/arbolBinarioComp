package arbol;

import org.junit.Test;

import java.util.Random;

/**
 * Creado por hadexexplade el 21/01/16.10:25
 */
public class ArbolBinarioTest
{
    @Test
    public void pruebaInsertar()
    {
        ArbolBinario<Integer> integerArbolBinario=new ArbolBinario<Integer>();
        Random random=new Random();


        for (int i = 1; i < 25; i++)
        {
            integerArbolBinario.insertar(random.nextInt(1+random.nextInt(25)));

        }

        System.out.println("Recorrido Inorden");

        for(Elemento<Integer> elemento:integerArbolBinario.recorridoInOrden())
        {
            System.out.printf("%s\t", elemento);
        }

        System.out.println();

        System.out.println("Recorrido Posorden");

        for(Elemento<Integer> elemento:integerArbolBinario.recorridoPosOrden())
        {
            System.out.printf("%s\t", elemento);
        }


        System.out.println();

        System.out.println("Recorrido Preorden");

        for(Elemento<Integer> elemento:integerArbolBinario.recorridoPreOrden())
        {
            System.out.printf("%s\t", elemento);
        }

    }

}