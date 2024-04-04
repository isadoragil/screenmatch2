package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PrincipalOrdenado {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Adam Sandler");
        lista.add("Paulo Gustavo");
        lista.add("Britney Spears");
        lista.add("Carla Diaz");

        Collections.sort(lista);

        System.out.println(lista);
    }
}
