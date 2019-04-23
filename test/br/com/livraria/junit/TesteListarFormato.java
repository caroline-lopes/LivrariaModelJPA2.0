/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Formato;
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
public class TesteListarFormato {
    EntityManager em;      
    public TesteListarFormato() {
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
   
    List<Formato> lista = em.createQuery("from Formato order by id").getResultList();
        
        for(Formato f : lista){
            System.out.println(" ID: " + f.getId() + 
                               "\n NOME: " + f.getNome()+
                               "\n -----------------------------\n");
        }
}

}
