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
public class TesteListarCatalogo {
    EntityManager em;
    public TesteListarCatalogo() {
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
   
  
    System.out.println("LISTA DE CATALOGOS:");
    List<Catalogo>listacat = em.createQuery("from Catalogo order by id").getResultList();
        
        for(Catalogo c : listacat){
            System.out.println(" ID: " + c.getId() + " Nome: " + c.getNome() + " Descrição: " + c.getDescricao()+ " Livraria: " + c.getLivraria().getNome());
        }
        System.out.println("________________________________________________________________________________");
    System.out.println(" ");
    }
}
