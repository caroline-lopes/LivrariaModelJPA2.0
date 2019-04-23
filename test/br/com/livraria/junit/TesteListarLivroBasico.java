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
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	     String dataString = sdf.format(lb.getDataPublicacao().getTime());
            System.out.println(" ISBN: " + lb.getISBN() + 
                               "\n TITULO: " + lb.getTitulo() +
                               "\n RESUMO: " + lb.getResumo() +
                               "\n EDITORA: "+ lb.getEditora() +
                               "\n DATA DE PUBLICAÇÃO: " + dataString); 
            System.out.println("\n LISTA DE AUTORES: ");
            for(Autor a : lb.getListaAutor()) {
                System.out.println(" "+a.getNome() + "\n");
            }
             System.out.println("________________________________________________________________________________");
             System.out.println(" ");

        }
    }
}
