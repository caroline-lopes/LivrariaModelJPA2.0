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
    public class TestePersistirLivraria {
    EntityManager em;  
    public TestePersistirLivraria() {
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
         
    Livraria l = new Livraria();
    l.setNome("Nobel");
    l.setSite("www.Nobel.com.br");
    
    
    //CASO QUEIRA FAZER UM CATALOGO
    /*
    Catalogo c = new Catalogo();
    c.setNome("Melhores livros de Romance");
    c.setDescricao("Uma seleção de grandes autores de livros de romance!");
    c.setLivraria(l);
   //c.setLivraria(em.find(Livraria.class, 1)); //CASO QUEIRA OUTRA LIVRARIA
    */
    
    
    
    // A livraria tem uma lista de catalogos
    l.adicionarCatalogo(em.find(Catalogo.class, 1));
    
    
    em.getTransaction().begin();
    em.persist(l);
    //em.persist(c);
    em.getTransaction().commit();}
     catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    
        
        
    
    }
}
