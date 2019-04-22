/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Idioma;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteRemoverIdioma {
    EntityManager em;
    public TesteRemoverIdioma() {
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
     Idioma idi = em.find(Idioma.class, 2);
        em.getTransaction().begin();
        em.remove(idi);
        em.getTransaction().commit();
    
    }
}
