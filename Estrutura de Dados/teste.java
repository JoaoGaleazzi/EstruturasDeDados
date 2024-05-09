import Arvore.ArvoreBinaria;
import Arvore.NoArvoreBinaria;

public class teste {
    public static void main(String[] args) {
        System.out.println("teste");

        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        no1.setEsquerda(no2);
        no2.setEsquerda(no3);
        no2.setDireita(no4);
        no4.setDireita(no5);
        no4.setEsquerda(no6);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
        arvore.setRaiz(no1);
        System.out.println(arvore.toString());
        System.out.println(arvore.contarFolhas(no1));
    }
}
