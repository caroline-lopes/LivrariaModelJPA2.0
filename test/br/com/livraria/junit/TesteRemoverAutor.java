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
public class TesteRemoverAutor {
    EntityManager em;    
    public TesteRemoverAutor() {
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
    Autor a = em.find(Autor.class, 2);
    
    // tem que informar o ISBN antigo para remover
    a.removerLivros(em.find(LivroBasico.class, "12345"));
    
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    
    }
}
