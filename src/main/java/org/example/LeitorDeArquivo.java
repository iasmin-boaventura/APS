package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {

    public String arq1000num = "C:\\Users\\boave\\IdeaProjects\\APS\\src\\main\\java\\org\\example\\1000_numbers.txt";
    public String arq5000num = "C:\\Users\\boave\\IdeaProjects\\APS\\src\\main\\java\\org\\example\\5000_numbers.txt";
    public String arq10000num = "C:\\Users\\boave\\IdeaProjects\\APS\\src\\main\\java\\org\\example\\10000_numbers.txt";

    public List<Integer> lerArquivo(String nomeArquivo) {
        List<Integer> numeros = new ArrayList<>();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linha);
                    numeros.add(numero);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter número: " + e.getMessage());
                }
            }

            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numeros;
    }

    public void printList(List<Integer> list) {
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }


}
