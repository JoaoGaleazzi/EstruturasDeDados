package Lista;

public class teste {
    public static void main(String[] args) {
        ListaEstatica<Integer> x = new ListaEstatica<Integer>();
        x.inserir(1);
        x.inserir(2);
        x.inserir(3);
        x.inserir(4);
        x.inserir(5);
        x.inserir(6);
        x.exibir();
        x.Inverter();
        x.exibir();
    }
}
