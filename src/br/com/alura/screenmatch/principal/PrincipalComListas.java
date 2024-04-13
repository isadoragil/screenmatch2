package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;
<<<<<<< Updated upstream

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        System.out.println("Ordenando por nome:");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano:");
        System.out.println(lista);
    }
=======
>>>>>>> Stashed changes

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 1970);
        filme1.avalia(10);
        Filme filme2 = new Filme("Avatar", 2023);
        filme2.avalia(7);
        var filme3 = new Filme("Crepúsculo", 2008);
        filme3.avalia(9);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(lost);

        //Filme f1 = filme1;  aponta para a referência do filme1 e não o objeto em si

        for (Titulo item: lista) {
            System.out.println(item);
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                //Filme filme = (Filme) item;
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        //lista.forEach(list -> System.out.println(list));
    }
}
