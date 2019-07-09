package lista;

import javax.swing.JOptionPane;


public class Lista {

    //final int TAMANHO_VETOR = 100;
    private final Aluno[] ALUNOS = new Aluno[Short.MAX_VALUE]; //32767

    private int totalAlunos = 0;

    public void adiciona(Aluno aluno) {
        this.ALUNOS[totalAlunos] = aluno;
        this.totalAlunos++;
    }

    public int tamanho() {
        return this.totalAlunos;
    }

    public void mostrar() {

        String al = "";

        for (int k = 0; k < this.totalAlunos; k++) {
            al += k + "--" + this.ALUNOS[k].getNome() + "\n";
        }
        if (al.length() == 0) {
            JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.\n", "Atenção", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Lista de Alunos:\n" + al, "Atenção", 1);
        }

    }

    boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.totalAlunos;
    }

    public Aluno pega(int posicao) {

        if (posicaoValida(posicao)) {
            return this.ALUNOS[posicao];
        } else {
            return null;
        }

    }

    public void pegaVoid(int pos) {
        if (this.pega(pos) != null) {
            System.out.println(this.pega(pos).getNome());
        } else {
            System.out.println("Posição inválida");
        }
    }

    public void remove(int posicao) {

        if (posicaoValida(posicao)) {
            for (int i = posicao; i < this.totalAlunos - 1; i++) {
                this.ALUNOS[i] = this.ALUNOS[i + 1];
            }
            this.totalAlunos--;
        }

    }

    boolean contem(String nome) {

        for (int i = 0; i < this.totalAlunos; i++) {
            if (this.ALUNOS[i].getNome().toUpperCase().equals(nome.toUpperCase())) {
                return true;
            }
        }

        return false;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

}
