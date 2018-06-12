package br.com.pizzanet.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaPU");

    public EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
