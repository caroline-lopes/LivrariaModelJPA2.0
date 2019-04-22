/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.LivroBasico;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteRemoverLivroBasico {
    EntityManager em;     
    public TesteRemoverLivroBasico() {
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
    //CUIDAR PARA O AUTOR NÃO ESTAR SENDO REFERENCIADO EM OUTRAS TABELAS
    
    public void teste(){
    LivroBasico lb = em.find(LivroBasico.class, "55555");
    
    // tem que informar o ID do Autor antigo para remover
    lb.removerAutores(em.find(Autor.class,1));
    
        em.getTransaction().begin();
        em.remove(lb);
        em.getTransaction().commit();
    
    }
}
