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
public class COMPLETO_TestePersistirLivro {
    EntityManager em;
    public COMPLETO_TestePersistirLivro() {
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
    l.setISBN("11111");
    l.setTitulo("Um dia na Praia");
    l.setResumo("O que pode ser mais gostoso do que passar um dia na praia? "
            + "Com este kit, que vem com bolsa, livro, baldinho e pá impermeáveis, "
            + "o dia perfeito na praia está garantido. "
            + "Aproveite para ler e brincar muito! ");
    l.setEditora("Ed. Caminho da leitura");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdf.parse("08/12/2017");
            Calendar dtC = Calendar.getInstance();
            dtC.setTime(dtP);
            l.setDataPublicacao(dtC);
    l.setCodigoBarras("343434343434343434");
    l.setNumeroPaginas("23");
    l.setAtivo(Boolean.TRUE);
    
    Calendar hoje = Calendar.getInstance();
    l.setDataCadastro(hoje);
    
    l.setValor(47.90);
    
    //##########################################################################
    //    DETALHADO 
    //##########################################################################

    //IDIOMA -------------------------------------------------------------------
    Idioma idi = new Idioma();
    idi.setNome("Português");
    idi.setSigla("PTB");
    l.setIdioma(idi);
    //l.setIdioma(em.find(Idioma.class, 2)); //CASO QUEIRA OUTRO IDIOMA
    
    //FORMATO ------------------------------------------------------------------
    Formato f = new Formato();
    f.setNome("Físico");
    l.setFormato(f);
    //l.setFormato(em.find(Formato.class, 2)); //CASO QUEIRA OUTRO FORMATO
    
    //LIVRARIA -----------------------------------------------------------------
    Livraria lv = new Livraria();
    lv.setNome("Delta");
    lv.setSite("www.Delta.com.br");
    //c.setLivraria(em.find(Formato.class, 2)); // Mas não dá pois precisa da variavel
    
      //CATALOGO -----------------------------------------------------------------
    Catalogo c = new Catalogo();
    c.setNome("Infância");
    c.setDescricao("Os livros mais divertidos para as crianças");
    c.setLivraria(lv); 
    //c.setLivraria(em.find(Livraria.class, 2));//CASO QUEIRA OUTRA LIVRARIA
    l.setCatalogo(c);
    //l.setCatalogo(em.find(Catalogo.class, 2)); //CASO QUEIRA OUTRO CATALOGO
    
    
     //########################################################################## 
    //AUTOR
    Autor au = new Autor();
    au.setNome("Francisco Mendes");
    au.setBibliografia(" O Francisco é escritor e ilustrador, "
            + "seus livros mais conhecidos são: O cavalo-marinho mais veloz do mundo!, "
            + "A festa no fundo do mar, O caranguejo e a tartaruga, Castelo de areia, ...");
    
    //##########################################################################
    //    RESUMIDO
    //##########################################################################
    
    /*
    l.setIdioma(em.find(Idioma.class, 1)); //CASO QUEIRA OUTRO IDIOMA
    l.setFormato(em.find(Formato.class, 1)); //CASO QUEIRA OUTRO FORMATO
    l.setCatalogo(em.find(Catalogo.class, 4)); //CASO QUEIRA OUTRO CATALOGO

    */
    
    
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
