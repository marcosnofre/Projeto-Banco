package contasBancarias.java;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente titular, BigDecimal saldo, int numeroConta) {
        super(titular, saldo, numeroConta);
    }

    @Override
    public void investir(BigDecimal valor) {
        System.out.println("Não é possível fazer investimentos em uma Conta Poupança.");
    }

    @Override
    public String toString() {
        return "ContaPoupança {" +
                "titular=" + getTitular() +
                ", saldo=" + getSaldo() +
                ", numeroConta=" + getNumeroConta() +
                "}";
    }

}
