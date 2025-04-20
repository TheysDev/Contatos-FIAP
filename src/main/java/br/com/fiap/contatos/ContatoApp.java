package br.com.fiap.contatos;

import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class ContatoApp {

    public static void main(String[] args) {

        //Criação EntityManager
        EntityManager em = Conexao.getEntityManager();

        // cadastrar(em);
        // atualizar(em);
        // excluir(em);
        consultarContatoPorId(em);


    }

    public static void cadastrar(EntityManager em){
        Contato contato = new Contato();
        contato.setNome("Fabiana Gomes");
        contato.setEmail("fabiana@email.com");
        contato.setDataNascimento(LocalDate.of(2000,10,15));

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.salvar(contato);
        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em){
        Contato contato = new Contato();
        contato.setId(3L);
        contato.setNome("Ana Maria");
        contato.setEmail("ana.maria@fiap.com.br");
        contato.setDataNascimento(LocalDate.of(2000,10,15));

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.atualizar(contato);
        em.getTransaction().commit();
    }
    public static void excluir(EntityManager em){
        Contato contato = new Contato();
        contato.setId(2L);

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.excluir(contato);
        em.getTransaction().commit();
    }

    public static void consultarContatoPorId(EntityManager em){

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.consultarContatoPorId(4L);
        em.getTransaction().commit();
    }

}
