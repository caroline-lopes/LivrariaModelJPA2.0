/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.LivroBasico;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TestePersistirLivroBasico {
    EntityManager em;
    public TestePersistirLivroBasico() {
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
    
    //LIVRO --------------------------------------------------------------------
    LivroBasico lb = new LivroBasico();
    // ISBN É UMA STRING  
    lb.setISBN("11111");
    lb.setTitulo("O Coelho Azul");
    lb.setResumo("Não, não é o coelho da Mônica!");
    lb.setEditora("Editora Confiança");
        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdf.parse("23/09/2014");
            Calendar dtC = Calendar.getInstance();
            dtC.setTime(dtP);
            lb.setDataPublicacao(dtC);
            
    //LISTA DE AUTORES DOS LIVROS
    // é um ManyToMany entre LivroBasico e o Autor
    // com um JoinTables ele cria uma nova tabela chamada lBasico_Autor
    // que contem o ISBN do livro e o ID do autor 
    lb.adicionarAutores(em.find(Autor.class, 1));
    
    
    
    em.getTransaction().begin();
    em.persist(lb);
    em.getTransaction().commit();}
     catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}
