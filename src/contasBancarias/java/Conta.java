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

    public void consultarSaldo() {
        System.out.printf("Olá %S%nO seu saldo é de R$ %.2f%n%n", this.titular.getNome(), this.saldo);

    }

    public void depositar(BigDecimal valor) {

        this.saldo = this.saldo.add(valor);
        System.out.printf("Depósito realizado com sucesso! %nSeu saldo é de R$ %.2f%n%n", this.saldo);
    }

    public void sacar(BigDecimal valor) {
        if (!Verificacoes.verificarSeSaldoMaiorQueValor(this, valor)) {
            System.out.printf("Não é possível realizar essa operação. %nSeu saldo é de R$ %.2f%n%n", this.saldo);
        } else if (Verificacoes.verificarSePessoaJuridica(this)) {
            if (!Verificacoes.verificarSeSaldoMaiorQueValorPJ(this, valor)) {
                System.out.printf("Não é possível realizar essa operação  %n%n-- OBSERVAÇÃO: Há uma taxa de 0,5%% em Saques realizados por Pessoa Jurídica --%n  %nSeu saldo é de R$ %.2f%n", this.saldo);
            } else {
                this.saldo = this.saldo.subtract(valor.multiply(BigDecimal.valueOf(1.005)));
                System.out.printf("Saque realizado com sucesso! %n-- OBSERVAÇÃO: Há uma taxa de 0,5%% em Saques realizados por Pessoa Jurídica --%nSeu saldo é de R$ %.2f%n%n", this.saldo);
            }
        } else {
            this.saldo = this.saldo.subtract(valor);
            System.out.printf("Saque realizado com sucesso! %nSeu saldo é de R$ %.2f%n%n", this.saldo);
        }
    }

    public void transferir(BigDecimal valor, Conta contaDestino) {
        if (Verificacoes.verificarSePessoaJuridica(this)) {
            if (!Verificacoes.verificarSeSaldoMaiorQueValorPJ(this, valor)) {
                System.out.printf("Não é possível realizar essa operação  %n%n-- OBSERVAÇÃO: Há uma taxa de 0,5%% em Transferencias realizadas por Pessoa Jurídica --%n  %nSeu saldo é de R$ %.2f%n", this.saldo);
            } else {
                this.saldo = this.saldo.subtract(valor.multiply(BigDecimal.valueOf(1.005)));
                contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
                System.out.printf("Transferência realizada com sucesso! %nSeu saldo é de R$ %.2f%n %n", this.saldo);

            }
        } else {
            if (!Verificacoes.verificarSeSaldoMaiorQueValor(this, valor)) {
                System.out.printf("Não é possível realizar essa operação. %nSeu saldo é de R$ %.2f%n %n ", this.saldo);
            } else {
                this.saldo = this.saldo.subtract(valor);
                contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
                System.out.printf("Transferência realizada com sucesso! %nSeu saldo é de R$ %.2f%n %n", this.saldo);

            }
        }
    }

    public void investir(BigDecimal valor) {

    }

    @Override
    public String toString() {
        return "Conta{" +
                "titular: " + titular +
                ", saldo: " + saldo +
                ", numeroConta: " + numeroConta +
                '}';
    }
}