package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        String jpql = "from Pergunta";
        TypedQuery<Pergunta> query = this.manager.createQuery(jpql, Pergunta.class);
        List<Pergunta> retorno = query.getResultList();

        return retorno;
    }

    public List<Pergunta> obterPerguntasSemResposta() {
        String jpql = "from Pergunta p  where p.resposta is null";
        TypedQuery<Pergunta> query = this.manager.createQuery(jpql, Pergunta.class);
        List<Pergunta> retorno = query.getResultList();
        return retorno;
       
    }
    public Pergunta consultaPergunta(String frase) {
        try{
        String jpql = "from Pergunta p  where p.texto like :pFrase";
        TypedQuery<Pergunta> query = this.manager.createQuery(jpql, Pergunta.class);
        query.setParameter("pFrase", "%"+frase+"%");
        Pergunta retorno = query.getSingleResult();
        return retorno;     }
        catch(NoResultException nre){
            return null;
        }
    }
}
