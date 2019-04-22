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
   
   System.out.println("LISTA DE LIVROS:");
    List<Livro> listaDeLivros = em.createQuery("from Livro order by id").getResultList();
        
        for(Livro l : listaDeLivros){
            System.out.println("ISBN: " + l.getISBN()+" Codigo de Barras: "+l.getCodigoBarras()+"Número de Páginas: "+ l.getNumeroPaginas()+
                    "\nStatus do Livro:"+ l.getAtivo() + "Data do Cadastro: " + l.getDataCadastro().toInstant()+"Valor: "+l.getValor()+
                    "\nIdioma: "+ l.getIdioma().getNome()+ "Formato: "+ l.getFormato().getNome() +"Catalogo: "+ l.getCatalogo().getNome());
        }
     
    
    }
}
