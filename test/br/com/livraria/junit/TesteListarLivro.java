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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol Lopes
 */
public class TesteListarLivro {
    EntityManager em; 
    public TesteListarLivro() {
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
   
   System.out.println("LISTA DE LIVROS:\n\n");
    List<Livro> listaDeLivros = em.createQuery("from Livro order by id").getResultList();
        
        for(Livro l : listaDeLivros){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataString = sdf.format(l.getDataPublicacao().getTime());
            SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
		String dataDeCadastro = fo.format(l.getDataCadastro().getTime());
                
            System.out.println(" ISBN: " + l.getISBN()+
                               "\n TÍTULO: " + l.getTitulo()+
                               "\n RESUMO: " + l.getResumo()+
                               "\n EDITORA: " + l.getEditora()+
                               "\n DATA DE PUBLICAÇÃO: " + dataString+
                               "\n CÓDIGO DE BARRAS: "+l.getCodigoBarras()+
                               "\n NÚMERO DE PÁGINAS: "+ l.getNumeroPaginas()+
                               "\n STATUS DO LIVRO: "+ l.getAtivo() +
                               "\n DATA DE CADASTRO "+ dataDeCadastro+
                               "\n VALOR: "+l.getValor()+
                               "\n IDIOMA: "+ l.getIdioma().getNome()+ 
                               "\n FORMATO: "+ l.getFormato().getNome() +
                               "\n CATÁLOGO: "+ l.getCatalogo().getNome()+
                               "\n --------------------------------------------------------- \n");
        }
     
    
    }
}
