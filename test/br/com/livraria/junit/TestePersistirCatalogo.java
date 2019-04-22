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
public class TestePersistirCatalogo {
    EntityManager em;      
    public TestePersistirCatalogo() {
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
 
    Catalogo c = new Catalogo();
    c.setNome("Outono");
    c.setDescricao("descrição livros no outono!");
    c.setLivraria(em.find(Livraria.class, 3)); //CASO QUEIRA OUTRA LIVRARIA
    
    c.adicionarLivro(em.find(Livro.class, "22222"));
    
    em.getTransaction().begin();
    em.persist(c);
    em.getTransaction().commit();}
     catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    
        
        
    
    }
}
