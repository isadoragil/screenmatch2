package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = sc.nextLine();

        try {
            String endereco = "http://www.omdbapi.com/?t=" + busca.replaceAll(" ", "+") + "&apikey=4c19ce34";
            //HttpRequest
            //HttpResponse
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            //Gson gson = new Gson(); (caso nome dos objetos estejam corretos com o json)

            //Titulo meuTitulo = gson.fromJson(json, Titulo.class); (caso não tenha o record)

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
        //try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Título já convertido:");
            System.out.println(meuTitulo);

            //gravando dados em arquivos (passar o caminho do diretório como argumento: ("C:\\meuArquivo.txt")
            // )
            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();
        } catch (NumberFormatException e) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço!");
        } catch(ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMensagem());
        } catch (Exception e) {
            System.out.println("Aconteceu algo, não sei o que!");
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("O programa finalizou corretamente!");

    }
}
