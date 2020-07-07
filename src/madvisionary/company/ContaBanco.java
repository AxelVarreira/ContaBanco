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
    private int verifier;
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

    public float getSaldo() { return saldo; }

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
        //abre a conta com todas as informacoes
        if (this.getStatus() != true) {
            this.setStatus(true);
            System.out.println("Digite o seu nome: ");
            this.setDono(input.nextLine());
            this.setNumConta(1000+ale*(2000-1000));
            System.out.println("Qual tipo de conta o senhor deseja? Conta corrente (cC)/ Conta Poupanca(cP))");
            setTipo(input.nextLine());
            if ("cC".equals(tipo)) {
                this.setSaldo(150);
                verifier = 1;
            } else {
                this.setSaldo(50);
                verifier = 2;
            }
            System.out.println("Conta aberta com sucesso!");
        } else {
            System.out.println("\nConta já aberta!\n");
        }
        System.out.println(this.getSaldo());
    }

    public void closeAccount() {
        if (getStatus() != false) {
            //Eu poderia tirar o operador logico, porém, ia ter que inverter os blocos de codigo, creio eu
            if (this.getSaldo() > 0) {
                System.out.println("O senhor deseja sacar o dinheiro em sua conta?(y)(n)");
                basicAnswer = input.nextLine();
                if ("y".equals(basicAnswer)) {
                    this.verSaldo();
                    this.sacar();
                } else {
                    System.out.println("Fechando conta!");
                }
            } else {
                System.out.println("Falha em fechar conta. O senhor está negativado\nO senhor gostaria de ir para a " +
                        "área de depósito senhor? (y)(n)");
                basicAnswer = input.nextLine();
                if ("y".equals(basicAnswer)) {
                    this.depositar();
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
            if(this.getStatus()){
                System.out.println("Digite o valor que quer depositar: ");
                float deposito = input.nextFloat();
                this.setSaldo(this.getSaldo()+deposito);
                this.verSaldo();
            }else{
                System.out.println("Conta inexistente!");
            }
        }

        public void sacar() {
            if(this.getStatus()){
                System.out.println("Digite o valor que quer sacar: ");
                float saque = input.nextFloat();
                if (saque <= this.getSaldo()) {
                    System.out.println("Sacado com sucesso!");
                    this.setSaldo(this.getSaldo() - saque);
                } else {
                    System.out.println("Valor para saque indisponivel!");
                }
                this.verSaldo();
            }else{
                System.out.println("Conta inexistente!");
            }
        }

        public void pagarMensal() {
            if ("cC".equals(tipo)) {
                if (this.getSaldo() > 12) {
                    System.out.println("Mensalidade paga com sucesso!");
                    this.setSaldo(this.getSaldo() - 12);
                } else {
                    System.out.println("Saldo insuficiente!");
                }
            } else if ("cP".equals(tipo)) {
                if (this.getSaldo() > 20) {
                    System.out.println("Mensalidade paga com sucesso!");
                    this.setSaldo(this.getSaldo() - 20);
                } else {
                    System.out.println("Saldo insuficiente!");
                }
            }

            this.verSaldo();
        }
        //by https://github.com/AxelVarreira
        public void verSaldo() {
            if(this.getStatus()){
                System.out.println("Seu saldo atual é: " +this.getSaldo());
            }else{
                System.out.println("Conta inexistente!");
            }
        }
        public void status(){
            System.out.println("\nNome: "+this.getDono());
            System.out.println("Numero da conta: "+this.getNumConta());
            System.out.println("Saldo: "+this.getSaldo());
            if(this.getStatus()){
                System.out.println("Status: Ativo");
            }else{
                System.out.println("Status: Desativado/Inexistente");
            }
            System.out.println("Tipo:"+this.getTipo()+"\n");
        }
}