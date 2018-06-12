package br.com.pizzanet.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomePizza;
    private String tamanhoPizza;
    private String ingredientesPizza;
    private float precoPizza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePizza() {
        return nomePizza;
    }

    public void setNomePizza(String nomePizza) {
        this.nomePizza = nomePizza;
    }

    public String getTamanhoPizza() {
        return tamanhoPizza;
    }

    public void setTamanhoPizza(String tamanhoPizza) {
        this.tamanhoPizza = tamanhoPizza;
    }

    public String getIngredientesPizza() {
        return ingredientesPizza;
    }

    public void setIngredientesPizza(String ingredientesPizza) {
        this.ingredientesPizza = ingredientesPizza;
    }

    public float getPrecoPizza() {
        return precoPizza;
    }

    public void setPrecoPizza(float precoPizza) {
        this.precoPizza = precoPizza;
    }

}
