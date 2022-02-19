package contasBancarias.java;

import java.math.BigDecimal;

public abstract class Conta {

    private Cliente titular;
    private BigDecimal saldo;
    private int numeroConta;

    public Conta() {
    }

    public Conta(Cliente titular, BigDecimal saldo, int numeroConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    //Metodos

    // consultar saldo
    public void consultarSaldo() {

        System.out.printf("Olá %S%n O seu saldo atual é R$ %.2f%n%n", this.titular.getNome() ,this.saldo);

    }

    // depositar
    public void depositar(BigDecimal valor) {

        this.saldo = this.saldo.add(valor);
        System.out.printf("Depósito realizado com sucesso! \n Seu saldo atual é R$ %.2f%n%n", this.saldo);
    }

    // sacar
    public void sacar(BigDecimal valor) {
        if (!Verificacoes.verificarSeSaldoMaiorQueValor(this, valor)) {
            System.out.printf("Não é possível realizar essa operação. \n Seu saldo atual é R$ %.2f%n%n", this.saldo);
        } else if (Verificacoes.verificarSePessoaJuridica(this)) {
            if (!Verificacoes.verificarSeSaldoMaiorQueValorPJ(this, valor)) {
                System.out.printf("Não é possível realizar essa operação  ** LEMBRETE: há uma taxa de 0,05%% em saques realizados Pessoa Jurídica **  \n Seu saldo atual é R$ %.2f%n", this.saldo);
            } else {
                this.saldo = this.saldo.subtract(valor.multiply(BigDecimal.valueOf(1.005)));
                System.out.printf("Saque realizado com sucesso! \n Seu saldo atual é R$ %.2f%n%n", this.saldo);
            }
        } else {
            this.saldo = this.saldo.subtract(valor);
            System.out.printf("Saque realizado com sucesso! \n Seu saldo atual é R$ %.2f%n%n", this.saldo);
        }
    }

    // transferir //
    public void transferir( BigDecimal valor, Conta contaDestino) {
        if(! Verificacoes.verificarSeSaldoMaiorQueValor(this, valor) ) {
            System.out.printf("Não é possível realizar essa operação. \n Seu saldo atual é R$ %.2f%n%n", this.saldo);
        }  else {
            if(Verificacoes.verificarSePessoaJuridica(this)) {
                this.saldo= this.saldo.subtract(valor.multiply(BigDecimal.valueOf(1.005)));
            } else {
                this.saldo= this.saldo.subtract(valor);
            }
            contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
            System.out.printf("Transferência realizada com sucesso! \n Seu saldo atual é R$ %.2f%n%n", this.saldo);
        }
    }


    public void investir(BigDecimal valor) {

    }


    @Override
    public String toString() {
        return "Conta{" +
                "titular=" + titular +
                ", saldo=" + saldo +
                ", numeroConta=" + numeroConta +
                '}';
    }
}