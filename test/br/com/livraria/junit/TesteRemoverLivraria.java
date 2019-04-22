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
public class TesteRemoverLivraria {
    EntityManager em;    
    public TesteRemoverLivraria() {
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
     Livraria l = em.find(Livraria.class, 1);
     Catalogo c = em.find(Catalogo.class, 2);

     l.removerCatalogo(c);
     
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
    
    }
}
