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
public class COMPLETO_TestePersistirLivroResumido {
    EntityManager em;
    public COMPLETO_TestePersistirLivroResumido() {
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
    l.setISBN("33333");
    l.setTitulo("A Bela e a Fera");
    l.setResumo("Um clássico infantil que já virou filme com a atriz Emma Watson! ");
    l.setEditora("Ed. Caminho da leitura");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdf.parse("01/09/2016");
            Calendar dtC = Calendar.getInstance();
            dtC.setTime(dtP);
            l.setDataPublicacao(dtC);
    l.setCodigoBarras("577757775777577775");
    l.setNumeroPaginas("27");
    l.setAtivo(Boolean.FALSE);
    
    Calendar hoje = Calendar.getInstance();
    l.setDataCadastro(hoje);
    
    l.setValor(39.90);
    
    
    l.setIdioma(em.find(Idioma.class, 1)); //CASO QUEIRA OUTRO IDIOMA
    l.setFormato(em.find(Formato.class, 1)); //CASO QUEIRA OUTRO FORMATO
    l.setCatalogo(em.find(Catalogo.class, 1)); //CASO QUEIRA OUTRO CATALOGO
    l.adicionarAutores(em.find(Autor.class, 1));
    l.adicionarAutores(em.find(Autor.class, 2));
    Livraria liv = em.find(Livraria.class, 1);
    liv.adicionarCatalogo(em.find(Catalogo.class, 2));
    
    em.getTransaction().begin();
    em.persist(l);
    em.persist(liv);
    em.getTransaction().commit();}
     catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}
