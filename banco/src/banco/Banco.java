package banco;

import java.util.Scanner;
import java.util.ArrayList;

public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int m = 10;
        int o = 0;
        int id = 0;
        int numc = 0;
        int numcd = 0;
        int numb = 0;
        int valor = 0;
        String nome;
        Scanner ler = new Scanner(System.in);
        ArrayList<ContaCorrente> contas = new ArrayList<>();

        while (m != 0) {
            System.out.println("     Lista de Opcoes ");
            System.out.println("1 => Cadastra Conta");
            System.out.println("2 => Listar Contas");
            System.out.println("3 => Excluir Conta");
            System.out.println("4 => Efetuar Depositos");
            System.out.println("5 => Efetuar Saque");
            System.out.println("6 => Consultar Conta");
            System.out.println("7 => Efetuar Transferencia entre contas");
            System.out.println("0 => Sair");
            System.out.print(" Digite sua opcao: ");
            final int ncc = contas.size();
            o = ler.nextInt();

            switch (o) {
                case 1:
                    System.out.println("++ Nova conta ++");
                    System.out.print("Informe nome:");
                    nome = ler.next();
                    id++;
                    contas.add(new ContaCorrente(id, nome, 0, 100));
                    System.out.println(" ++ Conta Criada Com Sucesso  ++");                    
                    System.out.println("-------------------------------");
                    System.out.println("");

                    break;
                case 2:
                    System.out.println("++ Lista Contas ++");
                    System.out.println("-------------------------------");
                    System.out.println("Numero  Nome do Cliente Saldo");
                    System.out.println("-------------------------------");
                    for (int i = 0; i <= (ncc - 1); i++) {
                        contas.get(i).Imprime();
                    }
                    System.out.println("-------------------------------");
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("++ Excluir Conta ++");
                    System.out.println("-------------------------------");
                    System.out.println("++ Informe o Numero da conta:   ++");
                    numc = ler.nextInt();
                    
                    numc = contas.indexOf(numc);
                    contas.remove(numc);
                    numc++;
                    System.out.println("++ Conta " + numc + " excluida     ++");
                    System.out.println("-------------------------------");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("++ Depósito Conta ++");
                    System.out.println("-------------------------------");
                    System.out.println("++ Informe o Numero da conta:   ++");
                    numc = ler.nextInt();
                    numc--;
                    System.out.println("++ Informe o Valor do Depósito: ++");
                    valor = ler.nextInt();
                    contas.get(numc).Deposito(valor);
                    System.out.println("++ Depósito Efetuado       ++");
                    System.out.println("-------------------------------");
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("++ Saque Conta ++");
                    System.out.println("-------------------------------");
                    System.out.println("++ Informe o Numero da conta:   ++");
                    numc = ler.nextInt();
                    numc--;
                    System.out.println("++ Informe o Valor do Saque: ++");
                    valor = ler.nextInt();
                    contas.get(numc).saque(valor);
                    System.out.println("-------------------------------");
                    System.out.println("");
                    break;

                case 6:
                    System.out.println("++ Consulta Conta ++");
                    System.out.println("++ Informe o Numero da conta:   ++");
                    numc = ler.nextInt();
                    
                    
                    numb = contas.indexOf(numc);
                    System.out.println(numb);
                   // numc--;
                    System.out.println("Numero  Nome do Cliente Saldo");
                    System.out.println("-------------------------------");
                    contas.get(numb).Imprime();
                    System.out.println("-------------------------------");
                    System.out.println("");
                    break;

                case 7:
                    System.out.println("++ Transferencia Entre Contas ++");
                    System.out.println("-------------------------------");
                    System.out.println("++ Informe o Numero da conta Doadora: ++");
                    numcd = ler.nextInt();
                    numcd--;
                    System.out.println("++ Informe o Numero da conta Receptora: ++");
                    numc = ler.nextInt();
                    numc--;
                    System.out.println("++ Informe o Valor do Saque da Conta Doadora: ++");
                    valor = ler.nextInt();

                    if (contas.get(numcd).Tem_Saldo(valor)) {
                        contas.get(numcd).saque(valor);
                        contas.get(numc).Deposito(valor);
                        System.out.println("++ Transferencia Entre Contas Foi Efetuada ++");
                    } else {
                        System.out.println("++ Saldo Insuficienta Na Conta Doadora ++");
                    }
                    System.out.println("-------------------------------");
                    System.out.println("");
                    break;

                case 0:
                    m = 0;
                    break;
                    
                default:
                    System.out.println("Opcão Inválida!");
                    break;

            }

        }

    }

}
