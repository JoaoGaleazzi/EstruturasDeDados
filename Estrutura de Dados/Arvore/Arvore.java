package Arvore;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        super();
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }
    
    @Override
    public String toString(){
        if(estaVazia())
            return "";
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no){
        String s = "<";
        s += no.getInfo();

        NoArvore<T> p;
        p = no.getPrimeiro();
        while(p != null){
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s += ">";

        return s;
    }

    public boolean pertence(T info){
        if(estaVazia())
            return false;
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info){
        if(no.getInfo().equals(info))
            return true;

        NoArvore<T> p;
        p = no.getPrimeiro();
        while(p != null){
            if(pertence(p, info)){
                return true;
            }
            p = p.getProximo();
        }

        return false;
    }

    public int contarNos(){
        if(estaVazia())
            return 0;
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no){
        int qtde = 1;

        NoArvore<T> p = no.getPrimeiro();
        while(p != null){
            qtde += contarNos(p);
            p = p.getProximo();
        }

        return qtde;
    }
    
    public boolean estaVazia(){
        return raiz == null;
    }
}
