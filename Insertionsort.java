import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Insertionsort {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(); 
        String caminhoArquivoOrdenado = "C:\\Users\\hanry\\Documents\\Estrutura de dados 2\\Algoritimo-Ordenação\\txt\\ordenados.txt";
        ArrayList<Integer> numerosArquivoOrdenado = new ArrayList<>(lerarquivo(numeros, caminhoArquivoOrdenado));


        String caminhoArquivoDesordenado = "C:\\Users\\hanry\\Documents\\Estrutura de dados 2\\Algoritimo-Ordenação\\txt\\invertidos.txt";
        ArrayList<Integer> numerosArquivoDesordenado = new ArrayList<>(lerarquivo(numeros, caminhoArquivoDesordenado));
        System.out.println("Ordenação via Insertion Sort(Invertidos):");
        long inicioExecucaoDesor = System.currentTimeMillis();
        int [] valores = ordenarInsertionSort(numerosArquivoDesordenado);
        long fimExecucaoDesor = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (fimExecucaoDesor - inicioExecucaoDesor) + "\nComparações: " + valores[0] + "\nTrocas: " + valores[1]);
    }

    public static int[] ordenarInsertionSort(ArrayList<Integer> listaNumeros) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 1; i < listaNumeros.size(); i++) {
            int chave = listaNumeros.get(i);
            int j = i - 1;

            comparacoes++;

            while (j >= 0 && listaNumeros.get(j) > chave) {
                listaNumeros.set(j + 1, listaNumeros.get(j));
                j = j - 1;
                trocas++;
            }
            listaNumeros.set(j + 1, chave);
        }

        return new int[]{comparacoes, trocas};
    }
    public static ArrayList<Integer> lerarquivo(ArrayList<Integer> numeros, String caminho) {
            try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
                String linha;

                while ((linha = reader.readLine()) != null) {
                    try {
                        int numero = Integer.parseInt(linha);
                        numeros.add(numero);
                    } catch (NumberFormatException e) {
                        System.err.println("Ignorando linha inválida: " + linha);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return numeros; 

        }
}