package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort{

    public static void ordenar(List<Integer> list) {
        int tam = list.size();

        for (int i = tam / 2 - 1; i >= 0; i--) {
            heapify(list, tam, i);
        }

        for (int i = tam - 1; i > 0; i--) {
            int max = list.get(0);
            list.set(0, list.get(i));
            list.set(i, max);

            heapify(list, i, 0);
        }
    }

    public static void heapify(List<Integer> list, int tam, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < tam && list.get(esquerda) > list.get(maior))
            maior = esquerda;

        if (direita < tam && list.get(direita) > list.get(maior))
            maior = direita;

        if (maior != i) {
            int troca = list.get(i);
            list.set(i, list.get(maior));
            list.set(maior, troca);

            heapify(list, tam, maior);
        }
    }

    public static void main(String[] args) {
        LeitorDeArquivo leitor = new LeitorDeArquivo();

        List<Integer> arq1 = new ArrayList<>(leitor.lerArquivo(leitor.arq1000num));
        List<Integer> arq2 = new ArrayList<>(leitor.lerArquivo(leitor.arq5000num));
        List<Integer> arq3 = new ArrayList<>(leitor.lerArquivo(leitor.arq10000num));

        List<List<Integer>> arquivos = new ArrayList<>(Arrays.asList(arq1, arq2, arq3));

        System.out.println("       H E A P S O R T \n=============================");

        for (int i = 0; i < arquivos.size(); i++){
            long inicio = System.currentTimeMillis();
            ordenar(arquivos.get(i));
            long fim = System.currentTimeMillis() - inicio;
            System.out.println(arquivos.get(i).size() + " números: " + fim + " milisegundos");
        }

    }
}
