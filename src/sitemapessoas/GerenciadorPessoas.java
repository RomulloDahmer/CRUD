package sitemapessoas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPessoas {
    private List<Pessoa> pessoas;
    private int proximoId; 

    public GerenciadorPessoas() {
        pessoas = new ArrayList<>();
        proximoId = 1; 
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoa.setId(proximoId); 
        pessoas.add(pessoa);
        proximoId++; 
    }

    public Pessoa encontrarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<Pessoa> listarPessoas() {
        return pessoas;
    }

   
    public boolean atualizarPessoa(Pessoa pessoaAtualizada) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getId() == pessoaAtualizada.getId()) {
                pessoas.set(i, pessoaAtualizada);
                return true;
            }
        }
        return false;
    }

    public boolean excluirPessoa(int id) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getId() == id) {
                pessoas.remove(i);
                return true;
            }
        }
        return false;
    }
}
