/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Catalogo;
import br.com.livraria.modelo.Formato;
import br.com.livraria.modelo.Idioma;
import br.com.livraria.modelo.Livraria;
import br.com.livraria.modelo.Livro;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteAtualizarLivro {
    EntityManager em;    
    public TesteAtualizarLivro() {
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
    Livro l = em.find(Livro.class, 6);
    l.setCodigoBarras("121212121212");
    l.setNumeroPaginas("555");
    l.setAtivo(Boolean.TRUE);
    
    Calendar hoje = Calendar.getInstance();
    l.setDataCadastro(hoje);
    l.setValor(23.90);
    
 
    
    //##########################################################################
    //    RESUMIDO
    //##########################################################################
    /*
    
    l.setIdioma(em.find(Idioma.class, 1)); //CASO QUEIRA OUTRO IDIOMA
    l.setFormato(em.find(Formato.class, 1)); //CASO QUEIRA OUTRO FORMATO
    l.setCatalogo(em.find(Catalogo.class, 4)); //CASO QUEIRA OUTRO CATALOGO

    */
    //##########################################################################
    //    DETALHADO 
    //##########################################################################

// IDIOMA -------------------------------------------------------------------
    Idioma idi = em.find(Idioma.class, 1);
    idi.setNome("Italiano");
    idi.setSigla("ITA");
    l.setIdioma(idi);
    
    
    
    //FORMATO ------------------------------------------------------------------
    Formato f = em.find(Formato.class, 1);
    f.setNome("Digital/E-book");
    l.setFormato(f);
    
    

    //CATALOGO -----------------------------------------------------------------
    Catalogo c = em.find(Catalogo.class, 4);
    c.setNome("Linguas");
    c.setDescricao("descrição livros de idiomas!");
    c.setLivraria(em.find(Livraria.class, 3)); //CASO QUEIRA OUTRA LIVRARIA
    l.setCatalogo(c);

    
    
   //##########################################################################
    
    
    
    em.getTransaction().begin();
    em.persist(l);
    em.persist(idi);
    em.persist(f);
    em.persist(c);
    em.getTransaction().commit();
    }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}


