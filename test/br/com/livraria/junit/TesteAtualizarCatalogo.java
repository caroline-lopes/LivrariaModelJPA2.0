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
public class TesteAtualizarCatalogo {
    EntityManager em;
    public TesteAtualizarCatalogo() {
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
    
    Catalogo c = em.find(Catalogo.class, 4);
    c.setNome("Primavera");
    c.setDescricao("descrição livros na Primavera!");
    c.setLivraria(em.find(Livraria.class, 3));

    //primeiro tem que remover o ISBN do livro antigo
    c.removerLivro(em.find(Livro.class, "77777"));
    //depois adicionar o ISBN do livro novo
    c.adicionarLivro(em.find(Livro.class, "12345"));
    
    em.getTransaction().begin();
    em.persist(c);
    em.getTransaction().commit();
    }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}
