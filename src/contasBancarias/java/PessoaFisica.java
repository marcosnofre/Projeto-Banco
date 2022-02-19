package contasBancarias.java;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String endereco, String cpf) {
        super(nome , endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + super.getNome() + '\'' +
                ", endereco='" + super.getEndereco() + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
