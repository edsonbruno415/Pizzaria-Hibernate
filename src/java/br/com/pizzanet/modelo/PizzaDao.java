package br.com.pizzanet.modelo;

import br.com.pizzanet.conexao.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

public class PizzaDao {

    private final EntityManager em = new ConnectionFactory().getConnection();
    private List<Pizza> pizzas = null;

    public int salvarPizza(Pizza pizza) {
        try {
            em.getTransaction().begin();
            if (pizza.getId() == null) {
                em.persist(pizza);
            } else {
                em.merge(pizza);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return 1;
        } finally {
            em.close();
        }
        return 0;
    }

    public int excluirPizza(Pizza pizza) {
        try {
            em.getTransaction().begin();
            pizza = em.find(Pizza.class, pizza.getId());
            em.remove(pizza);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return 1;
        } finally {
            em.close();
        }
        return 0;
    }

    public Pizza buscarPizza(Pizza pizza) {
        Pizza pi = new Pizza();
        try {
            pi = em.find(Pizza.class, pizza.getId());
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
        return pi;
    }

    public List<Pizza> listarPizzas() {
        try {
            pizzas = em.createQuery("from Pizza p").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
        return pizzas;
    }
}
