/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Formato;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteAtualizarFormato {
    EntityManager em;    
    public TesteAtualizarFormato() {
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
    Formato f = em.find(Formato.class, 1);
    f.setNome("Físico");
       
    em.getTransaction().begin();
    em.persist(f);
    em.getTransaction().commit();
    
    
    }
}
