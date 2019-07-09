package lista;

public class Aluno {
    
    /**
     * 
     */
    private String nome;
    
    /**
     * 
     */
    private int codigo_aluno = 0;
    
    /**
     * 
     * @param nome 
     */
    public Aluno(String nome) {
        this.codigo_aluno++;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
