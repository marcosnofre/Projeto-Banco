package contasBancarias.java;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente titular, BigDecimal saldo, int numeroConta) {
        super(titular, saldo, numeroConta);
    }

    @Override
    public void investir(BigDecimal valor) {
        System.out.println("Não é possível fazer investimentos utilizando uma conta corrente");
    }

    @Override
    public String toString() {
        return "ContaCorrente {"  +
                "titular=" + getTitular() +
                ", saldo=" + getSaldo() +
                ", numeroConta=" + getNumeroConta() +
                "}";
    }
}
