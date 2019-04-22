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
public class TestePersistirAutor {
        EntityManager em;
    public TestePersistirAutor() {
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
    Autor a = new Autor();
    a.setNome("André Lemos");
    // A BIBLIOGRAFIA É UM TEXTO SEM LIMITES DE CARACTERES
    // declarada como string sem restrição de tamanho 
    // e dizendo columnDefinition = "text"
    a.setBibliografia(" O André escreve livros de Terror, Suspense, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, " 
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, "
            + "texto sobre o autor, texto sobre o autor, texto sobre o autor, ");
 
    //LISTA DE LIVROS DO AUTOR
    // é um ManyToMany entre Autor e LivroBasico
    // com um JoinTables ele cria uma nova tabela chamada autor_LBasico
    // que contem o ID do autor e o ISBN do livro mencionado
    // ISBN É UMA STRING
    a.adicionarLivros(em.find(LivroBasico.class, "12345"));
    
    em.getTransaction().begin();
    em.persist(a);
    em.getTransaction().commit();
    }
}
