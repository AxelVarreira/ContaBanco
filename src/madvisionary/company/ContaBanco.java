/*
*Conta corrente: 12 reais mensal e ganha 150 reais
*Conta Poupança: 20 reais mensal e ganha 50 reais
*Constructor:
*Status: False
*Saldo: 0
* */

package madvisionary.company;

import java.util.Scanner;

public class ContaBanco {
    //ATRIBUTOS
    //ATTRIBUTES
    public Double numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    public String basicAnswer;
    private Scanner input = new Scanner(System.in);
    Double ale = Math.random();

    public ContaBanco() {
        setStatus(false);
        setSaldo(0);
    }

    //METODOS GETTERS e SETTERS
    //GETTERS AND SETTERS METHODS
    public Double getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDono() {
        return dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setNumConta(Double numConta) {
        this.numConta = numConta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    //METODOS FUNCIONAIS
    //FUNCTIONS
    public void openAccount() {
        if (getStatus() != true) {
            this.status = true;
            System.out.println("Digite o seu nome: ");
            setDono(input.nextLine());
            setNumConta(1000+ale*(2000-1000));
            System.out.println("Qual tipo de conta o senhor deseja? Conta corrente (cC)/ Conta Poupanca(cP))");
            tipo = input.nextLine();
            if ("cC".equals(tipo)) {
                setSaldo(150);
            } else {
                setSaldo(50);
            }
            System.out.println("Conta aberta com sucesso!");
        } else {
            System.out.println("\nConta já aberta!\n");
        }
        System.out.println(getSaldo());
    }

    public void closeAccount() {
        if (getStatus() != false) {
            //Eu poderia tirar o operador logico, porém, ia ter que inverter os blocos de codigo, creio eu
            if (getSaldo() > 0) {
                System.out.println("O senhor deseja sacar o dinheiro em sua conta?(y)(n)");
                basicAnswer = input.nextLine();
                if ("y".equals(basicAnswer)) {
                    verSaldo();
                    sacar();
                } else {
                    System.out.println("Fechando conta!");
                }
            } else {
                System.out.println("Falha em fechar conta. O senhor está negativado\nO senhor gostaria de ir para a " +
                        "área de depósito senhor? (y)(n)");
                basicAnswer = input.nextLine();
                if ("y".equals(basicAnswer)) {
                    depositar();
                } else {
                    System.out.println("Voltando ao menu...");
                }
            }
            this.status = false;
            System.out.println("Conta fechada com sucesso!");
        } else {
            System.out.println("\nConta inexistente.\n");
        }

    }

        public void depositar() {
            if(getStatus()){
                System.out.println("Digite o valor que quer depositar: ");
                float deposito = input.nextFloat();
                setSaldo(saldo + deposito);
                verSaldo();
            }else{
                System.out.println("Conta inexistente!");
            }
        }

        public void sacar() {
            if(getStatus()){
                System.out.println("Digite o valor que quer sacar: ");
                float saque = input.nextFloat();
                if (saque <= getSaldo()) {
                    System.out.println("Sacado com sucesso!");
                    setSaldo(saldo - saque);
                } else {
                    System.out.println("Valor para saque indisponivel!");
                }
                verSaldo();
            }else{
                System.out.println("Conta inexistente!");
            }
        }

        public void pagarMensal() {
            if ("cC".equals(tipo)) {
                if (getSaldo() > 12) {
                    System.out.println("Mensalidade paga com sucesso!");
                    setSaldo(saldo - 12);
                } else {
                    System.out.println("Saldo insuficiente!");
                }
            } else if ("cP".equals(tipo)) {
                if (getSaldo() > 20) {
                    System.out.println("Mensalidade paga com sucesso!");
                    setSaldo(saldo - 20);
                } else {
                    System.out.println("Saldo insuficiente!");
                }
            }

            verSaldo();
        }

        public void verSaldo() {
            if(getStatus()){
                System.out.println("Seu saldo atual é: " +getSaldo());
            }else{
                System.out.println("Conta inexistente!");
            }
        }
        public void status(){
            System.out.println("\nNome: "+getDono());
            System.out.println("Numero da conta: "+getNumConta());
            System.out.println("Saldo: "+getSaldo());
            if(getStatus()){
                System.out.println("Status: Ativo");
            }else{
                System.out.println("Status: Desativado/Inexistente");
            }
            System.out.println("Tipo:"+getTipo()+"\n");
        }
}