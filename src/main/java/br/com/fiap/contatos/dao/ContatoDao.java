package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Contato contato) {
        em.persist(contato);
    }

    public void atualizar(Contato contato) {
        em.merge(contato);
    }

    public void excluir(Contato contato) {
        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.remove(contatoExcluir);
    }

    public void consultarContatoPorId(Long id) {
        Contato contatoConsulta = em.find(Contato.class, id);

        if (contatoConsulta == null) {
            System.out.println("Contato Não Encontrado!");
        }else {
            System.out.println("---------------------------");
            System.out.println(contatoConsulta.toString());
            System.out.println("---------------------------");
        }

    }


}
