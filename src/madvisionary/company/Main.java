package madvisionary.company;
//https://github.com/AxelVarreira
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Variaveis
        //variables
        String name, type;
        int op=0;
        String status=null;
        ContaBanco cliente = new ContaBanco();
        Scanner input = new Scanner(System.in);

//        Sistema de input e dicas para usuarios
//        input and trick system for users
//        System.out.println("Qual o seu nome senhor?");
//        name = input.nextLine();

        System.out.println("\nSugerimos criar uma conta inicialmente.\n");

        do{

            System.out.println("Digite a opção desejada!\n1)Criar conta\t\t\t\t\t\t2)Fechar Conta\n3)Depositar" +
                    "\t\t\t\t\t\t\t4)Sacar" +
                    "\n5)Pagar Mensalidade\t\t\t\t\t6)Verificar saldo\n7)Status geral\t\t\t\t\t\t0)Sair\n");
            op = input.nextInt();

            //Sistema de escolha
            //choice system
            switch(op){
                case 1:
                    cliente.openAccount();
                break;
                case 2:
                    cliente.closeAccount();
                    break;
                case 3:
                    cliente.depositar();
                    break;
                case 4:
                    cliente.sacar();
                    break;
                case 5:
                    cliente.pagarMensal();
                    break;
                case 6:
                    cliente.verSaldo();
                    break;
                case 7:
                    cliente.status();
                    break;
            }
        }while(op!=0);
    }
}
