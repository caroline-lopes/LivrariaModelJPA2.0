/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Catalogo;
import br.com.livraria.modelo.Livraria;
import br.com.livraria.modelo.Livro;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteRemoverCatalogo {
    EntityManager em;  
    public TesteRemoverCatalogo() {
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
        Catalogo c = em.find(Catalogo.class, 1);
        Livro l = em.find(Livro.class,"77777");

        c.removerLivro(l);
     
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    
    }
}
