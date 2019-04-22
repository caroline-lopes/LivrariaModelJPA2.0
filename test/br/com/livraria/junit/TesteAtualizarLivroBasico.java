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
public class TesteAtualizarLivroBasico {
    EntityManager em;
    public TesteAtualizarLivroBasico() {
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
    LivroBasico lb = em.find(LivroBasico.class,"11111"); // é o isbn
    lb.setTitulo("A cigarra e a formiga");
    lb.setResumo("Uma fábula muito antiga");
    lb.setEditora("Editora Carvalho");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdf.parse("15/02/2019");
            Calendar dtC = Calendar.getInstance();
            dtC.setTime(dtP);
            lb.setDataPublicacao(dtC);
    // priemiro tem que remover o autor
    lb.removerAutores(em.find(Autor.class,1));
    // depois adicionar o certo
    lb.adicionarAutores(em.find(Autor.class,4));
 
    em.getTransaction().begin();
    em.persist(lb);
    em.getTransaction().commit();
    }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
    
    
}
