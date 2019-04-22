/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.junit;

import br.com.livraria.jpa.EntityManagerUtil;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.Catalogo;
import br.com.livraria.modelo.Formato;
import br.com.livraria.modelo.Idioma;
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
public class COMPLETO_TesteRemoverLivro {
     EntityManager em;      
    public COMPLETO_TesteRemoverLivro() {
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
     Livro l = em.find(Livro.class, "11111");
     Catalogo c = em.find(Catalogo.class, 1);
     Idioma idi = em.find(Idioma.class, 1);
     Formato f = em.find(Formato.class, 1);
     Livraria lv = em.find(Livraria.class, 1);
     Autor au = em.find(Autor.class, 1);
     
     lv.removerCatalogo(em.find(Catalogo.class, 1));
     au.removerLivros(em.find(Livro.class,"11111"));
     l.removerAutores(em.find(Autor.class, 1));


     
        em.getTransaction().begin();
        em.remove(l);
        em.remove(c);
        em.remove(idi);
        em.remove(f);
        em.remove(lv);
        em.remove(au);
        em.getTransaction().commit();
    
    }
    
}
