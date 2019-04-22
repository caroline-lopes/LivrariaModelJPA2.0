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
public class TesteAtualizarAutor {
    EntityManager em;
    public TesteAtualizarAutor() {
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
    Autor  a = em.find(Autor.class, 1);
    a.setNome("Marcos de Almeida");
    // A BIBLIOGRAFIA É UM TEXTO SEM LIMITES DE CARACTERES
    // declarada como string sem restrição de tamanho 
    // e dizendo columnDefinition = "text"
    a.setBibliografia(" Marcos escreve histórias infantis e é ilustrador,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,"
            + " vida do autor, vida do autor, vida do autor, vida do autor,");
    
    //LISTA DE LIVROS DO AUTOR
    // é um ManyToMany entre Autor e LivroBasico
    // com um JoinTables ele cria uma nova tabela chamada autor_LBasico
    // que contem o ID do autor e o ISBN do livro mencionado
    // ISBN É UMA STRING
    
    // tem que informar o ISBN antigo para remover
    a.removerLivros(em.find(LivroBasico.class, "55555"));
    // depois informar o ISBN novo para ser cadastrado na lista
    a.adicionarLivros(em.find(LivroBasico.class, "22222"));
    
    
    em.getTransaction().begin();
    em.persist(a);
    em.getTransaction().commit();
}
}
