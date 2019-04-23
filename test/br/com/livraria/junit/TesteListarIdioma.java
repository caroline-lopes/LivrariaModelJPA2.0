/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Idioma;
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
public class TesteListarIdioma {
    EntityManager em;  
    public TesteListarIdioma() {
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
   
    List<Idioma> lista = em.createQuery("from Idioma order by id").getResultList();
        
        for(Idioma idi : lista){
            System.out.println(" ID: " + idi.getId() + 
                               "\n NOME: " + idi.getNome() + 
                               "\n SIGLA: " + idi.getSigla()+
                               "\n -----------------------\n");
        }
   
    }
}
