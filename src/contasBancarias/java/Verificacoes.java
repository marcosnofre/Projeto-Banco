package contasBancarias.java;

import java.math.BigDecimal;

public class Verificacoes {

    public static boolean verificarSePessoaJuridica(Conta conta) {
        if(conta.getTitular() instanceof PessoaJuridica) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verificarSeSaldoMaiorQueValor(Conta conta, BigDecimal valor) {
        if(valor.compareTo(conta.getSaldo()) == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean verificarSeSaldoMaiorQueValorPJ(Conta conta, BigDecimal valor) {
        valor = valor.multiply(BigDecimal.valueOf(1.005));
        if(valor.compareTo(conta.getSaldo()) == 1) {
            return false;
        } else {
            return true;
        }
    }







}
