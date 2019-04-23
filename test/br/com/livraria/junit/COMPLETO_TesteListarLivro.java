/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.Livro;
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
public class COMPLETO_TesteListarLivro {
    EntityManager em; 
    public COMPLETO_TesteListarLivro() {
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
   
    List<Livro> lista1 = em.createQuery("from Livro order by id").getResultList();
        
        for(Livro l : lista1){
            System.out.println("ISBN: " + l.getISBN() + 
                               " \nTÍTULO: " + l.getTitulo() +
                               " \nRESUMO: " + l.getResumo() +
                               " \nEDITORA: " + l.getEditora());

        }
    }
}
