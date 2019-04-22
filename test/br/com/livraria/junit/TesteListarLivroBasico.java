/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.LivroBasico;
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
public class TesteListarLivroBasico {
    EntityManager em;     
    public TesteListarLivroBasico() {
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
   
    List<LivroBasico> lista = em.createQuery("from LivroBasico order by id").getResultList();
        
        for(LivroBasico lb : lista){
            System.out.println(" ISBN: " + lb.getISBN() + 
                               " TITULO: " + lb.getTitulo() +
                               " RESUMO: " + lb.getResumo() +
                               " EDITORA: "+ lb.getEditora() +
                               " DATA DA PUBLICAÇÃO: " + lb.getDataPublicacao()); 

        }
    }
}
