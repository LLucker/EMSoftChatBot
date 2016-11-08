package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.domain.Resposta;

public class RespostaDAO {

    private EntityManager manager = null;

    public RespostaDAO() {
        super();

        this.manager = JPAUtil.getEntityManager();
    }

    public Resposta incluir(Resposta resposta) {

        this.manager.getTransaction().begin();
        this.manager.persist(resposta);
        this.manager.getTransaction().commit();
        return resposta;
    }

    public void fecharConexao() {
        this.manager.close();
    }

    @Override
    protected void finalize() throws Throwable {
        this.fecharConexao();
    }

    public void alterar(Resposta resposta) {
        this.manager.getTransaction().begin();
        this.manager.merge(resposta);
        this.manager.getTransaction().commit();
    }

    public void remover(Resposta resposta) {
        this.manager.getTransaction().begin();
        this.manager.remove(resposta);
        this.manager.getTransaction().commit();
    }

    public Resposta obter(Integer codigo) {
        Resposta retorno = this.manager.find(Resposta.class, codigo);
        return retorno;
    }

    public List<Resposta> obterTodos() {
        List<Resposta> retorno = null;

        String jpql = "from Resposta r";
        TypedQuery<Resposta> query = this.manager.createQuery(jpql, Resposta.class);
        retorno = query.getResultList();

        return retorno;
    }

    public Resposta obterRespostaPorID(Integer id_resposta) {
        try{
        String jpql = "from Resposta p  where p.id_resposta = :id";
        TypedQuery<Resposta> query = this.manager.createQuery(jpql, Resposta.class);
        query.setParameter("id", id_resposta);
        Resposta retorno = query.getSingleResult();
        return retorno;     }
        catch(NoResultException nre){
            return null;
        }
    }

}
