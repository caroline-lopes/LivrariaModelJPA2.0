/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Catalogo;
import br.com.livraria.modelo.Livraria;
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
public class TesteListarLivraria {
    EntityManager em;     
    public TesteListarLivraria() {
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
   
   System.out.println("\n\nLISTA DE LIVRARIAS: \n\n");
   System.out.println("________________________________________________________________________________");
   System.out.println(" ");
    List<Livraria> lista = em.createQuery("from Livraria order by id").getResultList();
        
        for(Livraria l : lista){
            System.out.println(" ID: " + l.getId() + 
                               "\n NOME: " + l.getNome() + 
                               "\n SITE: " + l.getSite());
            System.out.println("\n LISTA DE CATALOGOS: ");
            for(Catalogo c : l.getListaCatalogo()) {
                System.out.println(" "+c.getNome() );
            }
             System.out.println("________________________________________________________________________________");
             System.out.println(" ");

        }
        
   

    }
}
