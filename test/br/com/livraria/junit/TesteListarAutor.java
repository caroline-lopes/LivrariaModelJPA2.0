/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteListarAutor {
    EntityManager em; 
    public TesteListarAutor() {
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
   
    List<Autor> lista = em.createQuery("from Autor order by id").getResultList();
        
        for(Autor a : lista){
            System.out.println(" ID: " + a.getId() + 
                               " NOME: " + a.getNome() +
                               " BIBLIOGRAFIA: " + a.getBibliografia());

        }
   
        
    }
}
