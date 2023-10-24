package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BubbleSort {

    public static List<Integer> ordenar(List<Integer> list){
        int tam = list.size();

        boolean trocador;
        do {
            trocador = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    trocador = true;
                }
            }
        } while (trocador);

        return list;
    }

    public static void main(String[] args) {
        LeitorDeArquivo leitor = new LeitorDeArquivo();

        List<Integer> arq1 = new ArrayList<>(leitor.lerArquivo(leitor.arq1000num));
        List<Integer> arq2 = new ArrayList<>(leitor.lerArquivo(leitor.arq5000num));
        List<Integer> arq3 = new ArrayList<>(leitor.lerArquivo(leitor.arq10000num));

        List<List<Integer>> arquivos = new ArrayList<>(Arrays.asList(arq1, arq2, arq3));

        System.out.println("     B U B B L E S O R T \n=============================");

        for (int i = 0; i < arquivos.size(); i++){
            long inicio = System.currentTimeMillis();
            ordenar(arquivos.get(i));
            long fim = System.currentTimeMillis() - inicio;
            System.out.println(arquivos.get(i).size() + " números: " + fim + " milisegundos");
        }


    }
}
