package lista;

import javax.swing.JOptionPane;

public class ImplementandoLista {

    public static void main(String[] args) {

        Lista lista = new Lista();

        int opcao = 0;

        do {

            /*Uso tray aqui para tratar erros inerentes
            à má digitação, isto é, de uma entrada que não
            seja um número.*/
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "+-----Sistema-----+\nMenu\n"
                        + "1 - Inserir Novo Aluno\n" //Okay
                        + "2 - Buscar Aluno\n" //Okay
                        + "3 - Excluir Aluno\n"
                        + "4 - Retornar Tamanho\n" //Okay
                        + "5 - Mostrar Lista\n" //Okay
                        + "6 - Sair ou clique em 'Cancelar'", "Tela Inicial", JOptionPane.INFORMATION_MESSAGE)//Okay
                );
            } catch (Exception e) {
                if (e.getMessage().length() == 4) { //Null, caso o usuário clique em 'Cancelar'

                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um número entre 1 a 6.", "Atenção", 1);
                }
            }

            switch (opcao) {
                case 1: //Adicionar

                    String nome;

                    nome = JOptionPane.showInputDialog(null,
                            "Incluir Aluno\n\nDigite o nome do aluno:");

                    while (nome.trim().length() == 0) {

                        nome = JOptionPane.showInputDialog(null,
                                "Incluir Aluno\n\nDigite um nome válido, o nome não pode estar vazio.", "Atenção", JOptionPane.ERROR_MESSAGE);

                    }

                    int tamTmp = lista.tamanho();

                    lista.adiciona(new Aluno(nome));

                    //Verifica se o tamanho da lista é maior que o tamanho armazenado na variável temporária.
                    if (tamTmp < lista.tamanho()) {
                        JOptionPane.showMessageDialog(null,
                                "Aluno cadastrado com sucesso!\n"
                                + "A posição desse aluno é: " + (lista.getTotalAlunos() - 1), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        opcao = 0;
                    }

                    break;
                case 2: //Buscar aluno
                    if (lista.tamanho() != 0) {//Verificar se a lista não está vazia.

                        String nomeDoAluno = JOptionPane.showInputDialog(null,
                                "Buscar Aluno\n\nDigite o nome do aluno:");

                        if (lista.contem(nomeDoAluno)) {
                            JOptionPane.showMessageDialog(null,
                                    "Aluno encontrado: " + nomeDoAluno + ".", "Atenção", 1);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Aluno não encontrado.", "Atenção", 1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 3: //Excluir aluno
                    if (lista.tamanho() != 0) {//Verificar se a lista não está vazia.

                        int posicaoAluno = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Buscar Aluno\n\nDigite a posição do aluno:"));

                        System.out.println("Posição: " + posicaoAluno);

                        if (lista.posicaoValida(posicaoAluno)) {

                            int confirm = JOptionPane.showConfirmDialog(null, "Deseja", "Atebção", 0);

                            System.out.println(confirm);

                            lista.remove(posicaoAluno);

                            JOptionPane.showMessageDialog(null,
                                    "Aluno encontrado: " + lista.pega(posicaoAluno).getNome() + ".", "Atenção", 1);

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Aluno não encontrado.", "Atenção", 1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 4:
                    if (lista.tamanho() != 0) {//Verificar se a lista não está vazia.
                        JOptionPane.showMessageDialog(null,
                                "Retornar Tamanho\n\nTotal de Alunos: "
                                + lista.tamanho() + ".", "Atenção", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 5: //Mostrar tudo
                    if (lista.tamanho() != 0) {
                        lista.mostrar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
            }
        } while (opcao != 6);

    }
}
