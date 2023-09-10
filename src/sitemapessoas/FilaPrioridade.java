
package sitemapessoas;

import java.util.PriorityQueue;

public class FilaPrioridade {
    private PriorityQueue<Pessoa> fila;

    public FilaPrioridade() {
        fila = new PriorityQueue<>((p1, p2) -> {
            if (p1.getIdade() > 60 && p2.getIdade() > 60) {
                return p2.getIdade() - p1.getIdade(); // Ambos tem mais de 60 anos
            } else if (p1.getIdade() > 60) {
                return -1; // Apenas p1 tem mais de 60 anos
            } else if (p2.getIdade() > 60) {
                return 1; // Apenas p2 tem mais de 60 anos
            } else {
                return p2.getIdade() - p1.getIdade(); // Nenhum tem mais de 60 anos
            }
        });
    }

    public void adicionarPessoa(Pessoa pessoa) {
        fila.add(pessoa);
    }

    public Pessoa proximaPessoa() {
        return fila.peek();
    }

    public Pessoa atenderProximaPessoa() {
        return fila.poll();
    }

    public boolean filaVazia() {
        return fila.isEmpty();
    }
}
