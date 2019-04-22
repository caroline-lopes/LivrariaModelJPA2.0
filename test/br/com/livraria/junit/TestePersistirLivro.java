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
public class TestePersistirLivro {
    EntityManager em;    
    public TestePersistirLivro() {
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
    Livro l = new Livro();
    l.setISBN("77777");
    l.setTitulo("Harry");
    l.setResumo("resumo de harry potter");
    l.setEditora("ed. Mundo das Letras");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdf.parse("08/07/1997");
            Calendar dtC = Calendar.getInstance();
            dtC.setTime(dtP);
            l.setDataPublicacao(dtC);
    l.setCodigoBarras("345345345345");
    l.setNumeroPaginas("187");
    l.setAtivo(Boolean.TRUE);
    
    Calendar hoje = Calendar.getInstance();
    l.setDataCadastro(hoje);
    
    l.setValor(70.90);
    
    
    
    
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

    //IDIOMA -------------------------------------------------------------------
    Idioma idi = new Idioma();
    idi.setNome("Espanhol");
    idi.setSigla("ESP");
    l.setIdioma(idi);
    //l.setIdioma(em.find(Idioma.class, 2)); //CASO QUEIRA OUTRO IDIOMA
    
    //FORMATO ------------------------------------------------------------------
    Formato f = new Formato();
    f.setNome("Digital/E-book");
    l.setFormato(f);
    //l.setFormato(em.find(Formato.class, 2)); //CASO QUEIRA OUTRO FORMATO
    
    //LIVRARIA -----------------------------------------------------------------
    Livraria lv = new Livraria();
    lv.setNome("Delta");
    lv.setSite("www.Delta.com.br");
  
    
    //CATALOGO -----------------------------------------------------------------
    Catalogo c = new Catalogo();
    c.setNome("Linguas");
    c.setDescricao("descrição livros de idiomas!");
    c.setLivraria(lv); 
    //c.setLivraria(em.find(Livraria.class, 2));//CASO QUEIRA OUTRA LIVRARIA
    l.setCatalogo(c);
    //l.setCatalogo(em.find(Catalogo.class, 2)); //CASO QUEIRA OUTRO CATALOGO
    

    //########################################################################## 
    //AUTOR
    Autor au = new Autor();
    au.setNome("Francisco Mendes");
    au.setBibliografia("eles escreveu varios livros de romance");
      //##########################################################################
    
 
    //LISTAS
    lv.adicionarCatalogo(c);
    au.adicionarLivros(l);
    l.adicionarAutores(au);
    
 
    em.getTransaction().begin();
    em.persist(f);
    em.persist(idi);
    em.persist(c);
    em.persist(lv);
    em.persist(au);
    em.persist(l);
    em.getTransaction().commit();}
     catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}
