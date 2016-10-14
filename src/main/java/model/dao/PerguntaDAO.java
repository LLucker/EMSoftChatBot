package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.domain.Pergunta;

public class PerguntaDAO {

    private EntityManager manager = null;

    public PerguntaDAO() {
        super();

        this.manager = JPAUtil.getEntityManager();
    }

    public void incluir(Pergunta pergunta) {

        this.manager.getTransaction().begin();
        this.manager.persist(pergunta);
        this.manager.getTransaction().commit();
    }

    public void fecharConexao() {
        this.manager.close();
    }

    @Override
    protected void finalize() throws Throwable {
        this.fecharConexao();
    }

    public void alterar(Pergunta pergunta) {
        this.manager.getTransaction().begin();
        this.manager.merge(pergunta);
        this.manager.getTransaction().commit();
    }

    public void remover(Pergunta pergunta) {
        this.manager.getTransaction().begin();
        this.manager.remove(pergunta);
        this.manager.getTransaction().commit();
    }

    public Pergunta obter(Integer codigo) {
        Pergunta retorno = this.manager.find(Pergunta.class, codigo);
        return retorno;
    }

    public List<Pergunta> obterTodos() {
        List<Pergunta> retorno = null;

        String jpql = "from Pergunta p";
        TypedQuery<Pergunta> query = this.manager.createQuery(jpql, Pergunta.class);
        retorno = query.getResultList();

        return retorno;
    }

    public List<Pergunta> obterPergunta(String frase) {
        List<Pergunta> retorno = null;

        String jpql = "from Pergunta p  where p.frase like :pFrase";
        TypedQuery<Pergunta> query = this.manager.createQuery(jpql, Pergunta.class);

        query.setParameter(":pFrase", frase + "%");
        // EXECUTA A CONSULTA E RETORNA UMA LISTA
        retorno = query.getResultList();

        return retorno;
    }

}
