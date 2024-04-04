package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalComListas {
    public static void main(String[] args) {
        ArrayList<Titulo> lista = new ArrayList<>();

        Filme filme1 = new Filme("O poderoso chefão", 1970);
        Serie lost = new Serie("Lost", 2000);
        Filme filme2 = new Filme("Avatar", 2023);
        var filme3 = new Filme("Crepúsculo", 2008);

        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(lost);

        Collections.sort(lista);

        System.out.println(lista);
    }

}
