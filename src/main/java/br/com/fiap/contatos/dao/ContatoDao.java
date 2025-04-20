package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;
import java.util.List;

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

    public List<Contato> listarTodosOsContatos(){
        // SQL ----> SELECT % FROM T_CONTATOS ORDER BY nome ASC

        //JPQL
        String consuta = "SELECT c FROM Contato c ORDER BY nome DESC";
        return em.createQuery(consuta).getResultList();
    }

    public List<Contato> listarContatosPorEmail(String email){
        String consuta = "SELECT c FROM Contato c WHERE email = :email";
        return em.createQuery(consuta, Contato.class)
                .setParameter("email", email)
                .getResultList();
    }


}
