package Lista;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    void inserir(T valor) {
        Object[] info = getInfo();

        if (getTamanho() == info.length) {
			redimensionar();
            info = getInfo();
		}

        int posicao = procuraPosicaoInclusao(valor);
        if(posicao < getTamanho())
            deslocarDados(posicao);

        info = getInfo();
        info[posicao] = valor;
        
        setTamanho(getTamanho() + 1);
    }

    private void deslocarDados(int posicao) {
        Object[] info = getInfo();
        for (int i = getTamanho()-1; i >= posicao; i--) {
            info[i+1] = info[i];
        }
    }

    private int procuraPosicaoInclusao(T valor) {
        Object[] info = getInfo();

        for (int i = 0; i < getTamanho(); i++) {
            if(((Comparable)info[i]).compareTo(valor) > 0)
                return i;
        }
        return getTamanho();
    }

    @Override
    int buscar(T valor) {
        Object[] info = getInfo();
        
        int inicio = 0;
        int fim = getTamanho()-1;

        while(inicio <= fim){
            int meio = (inicio + fim)/2;
            int comparacao = valor.compareTo((T)info[meio]);
            if(comparacao < 0)
                fim = meio -1;
            else{
                if(comparacao > 0)
                    inicio = meio + 1;
                else
                    return meio;
            }
        }
        return -1;
    }

}
