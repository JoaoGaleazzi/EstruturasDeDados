package trabalho;

import Fila.FilaLista;
import Pilha.PilhaLista;

public class Calculadora {
    public float Calcular(String expressao) throws Exception{
        FilaLista<String> filaExpressao = extrairTermos(expressao);
        FilaLista<String> filaExpressaoPosFixada = gerarExprPosFixada(filaExpressao);

        return calcularExprPosFixada(filaExpressaoPosFixada);
    }

    private FilaLista<String> extrairTermos(String expressao) throws Exception{
        FilaLista<String> fila = new FilaLista<String>();
        String tempNum = "";
        for (int i = 0; i < expressao.toCharArray().length; i++) {
            if(Character.compare(' ', expressao.charAt(i)) == 0){
                continue;
            }
            if(Character.compare('-', expressao.charAt(i)) == 0 && tempNum == "" && Character.isDigit(expressao.charAt(i+1))){
                tempNum += expressao.charAt(i);
                continue;
            }
            if(Character.isDigit(expressao.charAt(i))){
                tempNum += expressao.charAt(i);
                continue;
            }
            if(Character.compare(',', expressao.charAt(i)) == 0){
                if(tempNum.isEmpty() || tempNum.contains(","))
                    throw new Exception("Expressão inválida");
                tempNum += expressao.charAt(i);
                continue;
            }
            if(!tempNum.isEmpty()){
                
                fila.inserir(tempNum);
                tempNum = "";
            }
            if("+-*/()".indexOf(expressao.charAt(i)) == -1){
                throw new Exception("Expressão inválida");
            }
            fila.inserir(Character.toString(expressao.charAt(i)));
        }
        if(!tempNum.isEmpty()){
            if(tempNum.endsWith(",")){
                throw new Exception("Expressão inválida");
            }
            fila.inserir(tempNum);
        }

        return fila;
    }

    private FilaLista<String> gerarExprPosFixada(FilaLista<String> expressao) throws Exception{
        FilaLista<String> novaFila = new FilaLista<String>();
        PilhaLista<String> pilha = new PilhaLista<String>();
        
        while(!expressao.estaVazia()){
            String termo = expressao.retirar();
            if(termo.matches("-?\\d+(,\\d+)?")){
                novaFila.inserir(termo);
                continue;
            }
            if(termo.compareTo("(") == 0){
                pilha.push(termo);
                continue;
            }
            if(termo.compareTo(")") == 0){
                if(pilha.estaVazia())
                    throw new Exception("Expressão inválida");
                String termoPilha = pilha.pop();
                while(termoPilha.compareTo("(") != 0){
                    novaFila.inserir(termoPilha);
                    termoPilha = pilha.pop();
                    if(termoPilha == null)
                        throw new Exception("Expressão inválida");
                }
                continue;
            }

            String termosEncerrar = "(";

            switch (termo) {
                case "*":
                case "/":
                    termosEncerrar += "+-";
                    break;

                case "+":
                case "-":
                    break;
                
                default:
                    throw new Exception("Expressão Inválida");
            }
            
            while(!pilha.estaVazia()){
                String termoPilha = pilha.peek();
                if(termosEncerrar.contains(termoPilha)){
                    break;
                }
                novaFila.inserir(pilha.pop());
            }
            pilha.push(termo);
        }

        while(!pilha.estaVazia()){
            novaFila.inserir(pilha.pop());
        }

        return novaFila;
    }

    private float calcularExprPosFixada(FilaLista<String> expPosFixada) throws Exception{
        try {
            PilhaLista<String> aux = new PilhaLista<String>();

            while(!expPosFixada.estaVazia()){
                String termo = expPosFixada.retirar();
                if("+-*/".contains(termo)){
                    aux.push(calcularTermo(aux.pop(), aux.pop(), termo));
                }
                else{
                    aux.push(termo);
                }
            }

            float resultado = Float.parseFloat(aux.pop());

            if(!aux.estaVazia())
                throw new Exception("Expressão inválida");

            return resultado;
        }
         catch (Exception e) {
            throw new Exception("Expressão inválida");
        }
        
    }

    private String calcularTermo(String st1, String st2, String operador) throws Exception{
        float n1 = Float.parseFloat(st1);
        float n2 = Float.parseFloat(st2);
        switch (operador) {
            case "*":
                return Float.toString(n2 * n1);
            case "/":
                return Float.toString(n2 / n1);
            case "+":
                return Float.toString(n2 + n1);
            case "-":
                return Float.toString(n2 - n1);
            default:
                throw new Exception();
        }
    }
}
