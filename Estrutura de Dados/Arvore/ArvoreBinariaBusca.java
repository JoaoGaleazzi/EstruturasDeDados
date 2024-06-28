package Arvore;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T>{

    public void inserir(T info){
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(info);

        if(estaVazia())
            setRaiz(novo);

        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai;

        while(true){
            pai = p;
            if(info.compareTo(p.getInfo()) < 0){
                p = pai.getEsquerda();
                if(p == null){
                    pai.setEsquerda(novo);
                    return;
                }
            }
            else{
                p = pai.getDireita();
                if(p == null){
                    pai.setDireita(novo);
                    return;
                }
            }
        }
    }

    public void retirar(T info){
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        while(p != null && p.getInfo().compareTo(info) != 0){
            pai = p;
            if(info.compareTo(p.getInfo()) < 0){
                p = p.getEsquerda();
                filhoEsquerda = true;
            }
            else{
                p = p.getDireita();
                filhoEsquerda = false;
            }
        }

        if(p != null){
            if(p.getDireita() == null && p.getEsquerda() == null){
                if(p.getInfo().compareTo(getRaiz().getInfo()) == 0){
                    setRaiz(null);
                    return;
                }
                if(filhoEsquerda)
                    pai.setEsquerda(null);
                else
                    pai.setDireita(null);
            }
            else{
                if(p.getDireita() == null){
                    if(p.getInfo().compareTo(getRaiz().getInfo()) == 0){
                        setRaiz(p.getEsquerda());
                    }
                    else{
                        if(filhoEsquerda)
                            pai.setEsquerda(p.getEsquerda());
                        else
                            pai.setDireita(p.getEsquerda());
                    }
                }
                else{
                    if(p.getEsquerda() == null){
                        if(p.getInfo().compareTo(getRaiz().getInfo()) == 0){
                            setRaiz(p.getDireita());
                        }
                        else{
                            if(filhoEsquerda)
                                pai.setEsquerda(p.getDireita());
                            else
                                pai.setDireita(p.getDireita());
                        }
                    }
                    else{
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                        if(p.getInfo().compareTo(getRaiz().getInfo()) == 0){
                            setRaiz(sucessor);
                        }
                        else{
                            if(filhoEsquerda)
                                pai.setEsquerda(sucessor);
                            else
                                pai.setDireita(sucessor);
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor= p;
        while (atual != null){
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }
        
        if(sucessor != p.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }
        return sucessor;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if(no == null)
            return null;
        if(info.compareTo(no.getInfo()) == 0)
            return no;
        if(info.compareTo(no.getInfo()) < 0)
            return buscar(no.getEsquerda(), info);
        return buscar(no.getDireita(), info);
    }

    public T obterMenorValor(){
        if(estaVazia()){
            return null;
        }
        NoArvoreBinaria<T> noAtual = getRaiz();
        while(noAtual.getEsquerda() != null){
            noAtual = noAtual.getEsquerda();
        }
        return noAtual.getInfo();
    }
}
