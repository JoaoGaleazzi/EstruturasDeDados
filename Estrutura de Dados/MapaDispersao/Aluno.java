package MapaDispersao;

import java.time.LocalDate;

public class Aluno implements Comparable{
    private int matricula;
    private String nome;
    private LocalDate dataNascimento;
    
    public Aluno(int matricula, String nome, LocalDate dataNascimento) {
        super();
        setMatricula(matricula);
        setNome(nome);
        setDataNascimento(dataNascimento);
    }

    /**
     * @return int return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return LocalDate return the dataNascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int compareTo(Aluno o) {
        if(getMatricula() < o.getMatricula())
            return -1;
        if(getMatricula() > o.getMatricula())
            return 1;
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
