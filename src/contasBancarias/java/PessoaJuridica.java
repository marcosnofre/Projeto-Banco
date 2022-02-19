package contasBancarias.java;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }


    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + super.getNome() + '\'' +
                ", endereco='" + super.getEndereco() + '\'' +
                ", cnpj='" + this.cnpj + '\'' +
                "}";
    }
}

