package br.com.fiap.contatos;

import br.com.fiap.contatos.utils.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.dao.TipoContatoDao;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class ContatoApp {

    public static void main(String[] args) {

        //Criação EntityManager
        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //atualizar(em);
        //excluir(em);
        //consultarContatoPorId(em);
        //listarTodosOsContatos(em);
        //listarContatosPorEmail(em);
        consultarTipoContatoPeloId(em);



    }

    private static void consultarTipoContatoPeloId(EntityManager em) {

        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);
        TipoContato tipoContatoBuscado = new TipoContato();
        tipoContatoBuscado.setId(2L);

        TipoContato tipoContatoEncontrado = new TipoContato();
        tipoContatoEncontrado = tipoContatoDao.buscarTipoContatoPeloId(tipoContatoBuscado);

        System.out.println("Tipo Contato: " + tipoContatoEncontrado.getTipo());
        System.out.println("Contatos: " + tipoContatoEncontrado.getContatos());

    }

    public static void listarContatosPorEmail(EntityManager em){

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarContatosPorEmail("FABIANA@EMAIL.COM".toLowerCase());

        for(Contato contato : contatos) {
            System.out.println("---------------------");
            System.out.println(contato.toString());
        }
        System.out.println("");
        System.out.println("Fim dos registros....");
    }

    public static void listarTodosOsContatos(EntityManager em){

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarTodosOsContatos();

        for(Contato contato : contatos) {
            System.out.println("---------------------");
            System.out.println(contato.toString());
        }
        System.out.println("");
        System.out.println("Fim dos registros....");
    }

    public static void cadastrar(EntityManager em){

        TipoContato tipoContato = new TipoContato();
        tipoContato.setId(2L);
        //tipoContato.setTipo("Família");

        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);

        em.getTransaction().begin();
        //tipoContatoDao.salvar(tipoContato);

        Contato contato = new Contato();
        contato.setNome("Ana Maria");
        contato.setEmail("ana@fiap.com.br");
        contato.setDataNascimento(LocalDate.of(2004,11,10));
        contato.setTipoContato(tipoContato);

        //Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

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

        contatoDao.consultarContatoPorId(6L);

    }

}
