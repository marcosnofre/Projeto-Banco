package contasBancarias.java;

import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args) {
        Banco bancoItau = new Banco();

        Conta contaRoger = new ContaCorrente(new PessoaFisica("Roger Machado", "Rua Raposo Tavares , 8000", "112.312.233-50"),
                BigDecimal.valueOf(1_000), 1);
        Conta contaPaulo = new ContaCorrente(new PessoaJuridica("Paulo Coelho", "Avenida Castelo Branco , 500", "01.002.248/0001-12"),
                BigDecimal.valueOf(10_000), 2);
        Conta contaMarcos = new ContaPoupanca(new PessoaFisica("Marcos Mion", "Rua Jose Mauro de Vasconcelos , 10", "456.231.223-12"),
                BigDecimal.valueOf(1_000), 3);
        Conta contaPatricia = new ContaPoupanca(new PessoaJuridica("Patrícia Abravanel", "Rua das Gameleiras , 23", "08.147.669/0001-12"),
                BigDecimal.valueOf(10_000), 4);
        Conta contaMariana = new ContaInvestimento(new PessoaFisica("Mariana Ximenes", "Av. Roberto Freire , 0230", "784214319-09"),
                BigDecimal.valueOf(10_000), 5);
        Conta contaRoberto = new ContaInvestimento(new PessoaJuridica("Roberto Carlos", "Av Salgado Filho , 893", "17.217.813/0001-33"),
                BigDecimal.valueOf(10_000), 6);

        System.out.println("------- Abrindo novas conta --------");

        bancoItau.criarConta(contaRoger);
        bancoItau.criarConta(contaPaulo);
        bancoItau.criarConta(contaMarcos);
        bancoItau.criarConta(contaPatricia);
        bancoItau.criarConta(contaMariana);
        bancoItau.criarConta(contaRoberto);

        System.out.println("-------- Lista de Contas Cadastradas--------");

        System.out.println(contaRoger);
        System.out.println();
        System.out.println(contaPaulo);
        System.out.println();
        System.out.println(contaMarcos);
        System.out.println();
        System.out.println(contaPatricia);
        System.out.println();
        System.out.println(contaMariana);
        System.out.println();
        System.out.println(contaRoberto);
        System.out.println();


        System.out.println("--------- Consultando saldo de contas ----------");

        contaRoger.consultarSaldo();
        contaPaulo.consultarSaldo();
        contaMarcos.consultarSaldo();
        contaPatricia.consultarSaldo();
        contaMariana.consultarSaldo();
        contaRoberto.consultarSaldo();

        System.out.println("---------- Depositos em Contas ------------");

        contaRoger.depositar(BigDecimal.valueOf(300));
        contaPaulo.depositar(BigDecimal.valueOf(200));
        contaMarcos.depositar(BigDecimal.valueOf(400));
        contaPatricia.depositar(BigDecimal.valueOf(250));
        contaMariana.depositar(BigDecimal.valueOf(300));
        contaRoberto.depositar(BigDecimal.valueOf(300));
        System.out.println();

        System.out.println("---------- Saque das contas -----------");
        System.out.println("Saque de R$ 500,00");
        contaRoger.sacar(BigDecimal.valueOf(500));
        System.out.println("Saque de R$ 10.000,00");
        contaPaulo.sacar(BigDecimal.valueOf(10_000));
        System.out.println("Saque de R$ 1.000,00");
        contaPaulo.sacar(BigDecimal.valueOf(1_000));
        System.out.println("Saque de R$ 1.001,00");
        contaMarcos.sacar(BigDecimal.valueOf(1_001));
        System.out.println("Saque de R$ 990,00");
        contaPatricia.sacar(BigDecimal.valueOf(990));
        System.out.println("Saque de R$ 1.000,00");
        contaMariana.sacar(BigDecimal.valueOf(1_000));
        System.out.println("Saque de R$ 1.000,00");
        contaRoberto.sacar(BigDecimal.valueOf(1_000));
        System.out.println();

        System.out.println("---------- Valores Investidos ------------");

        contaMariana.investir(BigDecimal.valueOf(5000));
        System.out.println();
        contaRoberto.investir(BigDecimal.valueOf(5000));
        System.out.println();
        contaPaulo.investir(BigDecimal.valueOf(200));
        System.out.println();

        System.out.println("--------------Realizando Transferencias------------------");

        contaRoberto.consultarSaldo();
        System.out.println("Transferencia de R$ 2.000,00 para Marcos");
        contaRoberto.transferir(BigDecimal.valueOf(2000), contaMarcos);
        System.out.println("Transferencia de R$ 30.000,00 para Roger");
        contaRoberto.transferir(BigDecimal.valueOf(30_000), contaRoger);


    }
}