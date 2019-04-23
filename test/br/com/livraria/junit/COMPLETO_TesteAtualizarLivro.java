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
public class COMPLETO_TesteAtualizarLivro {
    EntityManager em;    
    public COMPLETO_TesteAtualizarLivro() {
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
    Livro l = em.find(Livro.class, "22222");
    l.setTitulo("Harry Potter and the Prisoner of Azkaban");
    l.setResumo("Sirius Black, escaped mass-murderer and follower of"
            + " Lord Voldemort, is on the run - and they say he is"
            + " coming after Harry. In his first ever Divination class,"
            + " Professor Trelawney sees an omen of death in Harry's tea"
            + " leaves... But perhaps most terrifying of all are the"
            + " Dementors patrolling the school grounds...");
    
    l.setEditora("Ed. Pottermore Publishing");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdf.parse("08/07/1999");
            Calendar dtC = Calendar.getInstance();
            dtC.setTime(dtP);
            l.setDataPublicacao(dtC);
    l.setCodigoBarras("9595959595995595");
    l.setNumeroPaginas("475");
    l.setAtivo(Boolean.TRUE);
    
    Calendar hoje = Calendar.getInstance();
    l.setDataCadastro(hoje);
    
    l.setValor(42.50);
    
    //##########################################################################
    //    DETALHADO 
    //##########################################################################

    //IDIOMA -------------------------------------------------------------------
     Idioma idi = em.find(Idioma.class, 2);
    idi.setNome("Inglês");
    idi.setSigla("ING");
    l.setIdioma(idi);
    //l.setIdioma(em.find(Idioma.class, 2)); //CASO QUEIRA OUTRO IDIOMA
    
    //FORMATO ------------------------------------------------------------------
    Formato f = em.find(Formato.class, 2);
    f.setNome("Digital/E-book");
    l.setFormato(f);
    //l.setFormato(em.find(Formato.class, 2)); //CASO QUEIRA OUTRO FORMATO
    
    //LIVRARIA -----------------------------------------------------------------
    Livraria lv = em.find(Livraria.class, 2);
    lv.setNome("Saraiva");
    lv.setSite("www.Saraiva.com.br");
    //c.setLivraria(em.find(Formato.class, 2)); // Mas não dá pois precisa da variavel
    
      //CATALOGO -----------------------------------------------------------------
    Catalogo c = em.find(Catalogo.class, 2);
    c.setNome("Aventura");
    c.setDescricao(" Sabe aquele livro que você começa e não consegue parar de "
            + "ler? Os livros escolhidos para esse catálogo vão te surpreender "
            + "com os universos e histórias desses personagens marcantes");
    c.setLivraria(lv); 
    //c.setLivraria(em.find(Livraria.class, 2));//CASO QUEIRA OUTRA LIVRARIA
    l.setCatalogo(c);
    //l.setCatalogo(em.find(Catalogo.class, 2)); //CASO QUEIRA OUTRO CATALOGO
    
    
     //########################################################################## 
    //AUTOR
    Autor au = em.find(Autor.class, 2);
    au.setNome("J. K. Rowling");
    au.setBibliografia("J. K. Rowling tornou-se uma escritora de sucesso, suas "
            + "principais obras são: Série Harry Potter, Quadribol Através dos "
            + "Séculos, Os Contos de Beedle o Bardo, Animais Fantásticos e onde "
            + "habitam, Uma morte súbita, O chamado do Cuco, ...  ");
    
    //##########################################################################
    //    RESUMIDO
    //##########################################################################
    
    /*
    l.setIdioma(em.find(Idioma.class, 1)); //CASO QUEIRA OUTRO IDIOMA
    l.setFormato(em.find(Formato.class, 1)); //CASO QUEIRA OUTRO FORMATO
    l.setCatalogo(em.find(Catalogo.class, 4)); //CASO QUEIRA OUTRO CATALOGO

    */
    
    
    //LISTAS
    lv.removerCatalogo(em.find(Catalogo.class, 2));
    lv.adicionarCatalogo(c);
    
    au.removerLivros(em.find(Livro.class,"22222"));
    au.adicionarLivros(l);
    
    //l.removerAutores(em.find(Autor.class, 1));
    //l.adicionarAutores(au);
    
 
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
