package contasBancarias.java;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {

    public ContaInvestimento() {

    }

    public ContaInvestimento(Cliente titular, BigDecimal saldo, int numeroConta) {
        super(titular, saldo, numeroConta);
    }

    @Override
    public void investir(BigDecimal valor) {
        if (Verificacoes.verificarSeSaldoMaiorQueValor(this, valor)) {
            if (Verificacoes.verificarSePessoaJuridica(this)) {
                this.setSaldo(getSaldo().add(valor.multiply(BigDecimal.valueOf(0.12))));
                System.out.printf("Seu investimento foi realizado com sucesso! %n Seu saldo atual é R$ %.2f%n", this.getSaldo());
            } else {
                this.setSaldo(getSaldo().add(valor.multiply(BigDecimal.valueOf(0.10))));
                System.out.printf("Seu investimento foi realizado com sucesso! %n Seu saldo atual é R$ %.2f%n", this.getSaldo());
            }
        } else {
            System.out.printf("Não é possível realizar esse investimento! %n Seu saldo atual é R$ %.2f%n", this.getSaldo());
        }

    }

    @Override
    public void depositar(BigDecimal valor) {
        System.out.println("Não é possivel realizar depósitos em conta Investimento. \n Tente Investir ou abra outro tipo de conta.");
    }


    @Override
    public String toString() {
        return "ContaInvestimento {" +
                "titular=" + getTitular() +
                ", saldo=" + getSaldo() +
                ", numeroConta=" + getNumeroConta() +
                "}";
    }
}