package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.Modelos.Estoque;

public class EstoqueDAO {

    EntityManagerFactory emf;
    EntityManager em;


    public EstoqueDAO(){
        emf = Persistence.createEntityManagerFactory("a1_mysql");
        em = emf.createEntityManager();
    }

    public void salvarEstoque(Estoque estoque){
        em.getTransaction().begin();
        em.persist(estoque);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<Estoque> listar(){
        List<Estoque> estoquesTotais = em.createQuery("from Estoque", Estoque.class).getResultList();
        return estoquesTotais;
    }

    public void atualizar(String id, String bairro){
        em.getTransaction().begin();
        List<Estoque> estoque = em.createQuery("from Estoque where id = "+id+"", Estoque.class).getResultList();
        estoque.get(0).setLocalizacao(bairro);// precisa dar um commit aqui, porque se nao ele nao vai atualizar no banco de dados
        em.merge(estoque.get(0));
		em.getTransaction().commit();
    }

    public void deletar(int id){
        em.getTransaction().begin();
        Estoque estoque = em.find(Estoque.class, id);
        em.remove(estoque);
        em.getTransaction().commit();
    }
    

    
}
