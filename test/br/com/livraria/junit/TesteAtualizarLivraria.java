/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Catalogo;
import br.com.livraria.modelo.Livraria;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteAtualizarLivraria {
    EntityManager em;   
    public TesteAtualizarLivraria() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
     @Test
    public void teste(){
     try {
    Livraria l = em.find(Livraria.class, 4);
    l.setNome("Saraiva");
    l.setSite("www.Saraiva.com.br");
    
    //CASO QUEIRA CHAMAR UM CATALOGO
    /*
    Catalogo c = em.find(Catalogo.class, 1);
    c.setNome("Inverno");
    c.setDescricao("descrição livros no inverno!");
    c.setLivraria(l);
   //c.setLivraria(em.find(Livraria.class, 1)); //CASO QUEIRA OUTRA LIVRARIA
    */
    
    // remover o antigo catalogo
    l.removerCatalogo(em.find(Catalogo.class, 2));
    // para adicionar o novo
    l.adicionarCatalogo(em.find(Catalogo.class, 3));
    
    em.getTransaction().begin();
    em.persist(l);
    //em.persist(c);
    em.getTransaction().commit();
    }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}
