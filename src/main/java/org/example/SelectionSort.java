package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void ordenar(List<Integer> list){

        int posicao_menor;
        for (int i = 0; i < list.size(); i++) {
            posicao_menor = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(posicao_menor)) {
                    posicao_menor = j;
                }
            }

            int aux = list.get(posicao_menor);
            list.set(posicao_menor, list.get(i));
            list.set(i, aux);
        }

    }

    public static void main(String[] args) {
        LeitorDeArquivo leitor = new LeitorDeArquivo();

        List<Integer> arq1 = new ArrayList<>(leitor.lerArquivo(leitor.arq1000num));
        List<Integer> arq2 = new ArrayList<>(leitor.lerArquivo(leitor.arq5000num));
        List<Integer> arq3 = new ArrayList<>(leitor.lerArquivo(leitor.arq10000num));

        List<List<Integer>> arquivos = new ArrayList<>(Arrays.asList(arq1, arq2, arq3));

        System.out.println("   S E L E C T I O N S O R T \n=============================");

        for (int i = 0; i < arquivos.size(); i++){
            long inicio = System.currentTimeMillis();
            ordenar(arquivos.get(i));
            long fim = System.currentTimeMillis() - inicio;
            System.out.println(arquivos.get(i).size() + " números: " + fim + " milisegundos");
        }
    }
}
