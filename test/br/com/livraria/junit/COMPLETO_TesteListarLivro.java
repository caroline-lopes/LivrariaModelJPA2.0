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
public class COMPLETO_TesteListarLivro {
    EntityManager em; 
    public COMPLETO_TesteListarLivro() {
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
   
   System.out.println(" ##################################################################"
                    + "\n ##################################################################"
                    +"\n #\n # LIVROS\n #"
                    + "\n ##################################################################"
                    + "\n # Comentarios da Carol "
                    + "\n # Classes Pertencentes: Livro e LivroBasico"
                    + "\n # Descrição de Funcionamento: Mostra todos os livros cadastrados."
                    + "\n #\n # IMPORTANTE: observe que o 3º livro tem 2 autores\n #");
   System.out.println(" ##################################################################");
   System.out.println(" ");
   
   
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
                               "\n CATÁLOGO: "+ l.getCatalogo().getNome());
            System.out.println("\n LISTA DE AUTORES: ");
            for(Autor a : l.getListaAutor()) {
                System.out.println(" "+a.getNome());
            }
             System.out.println("________________________________________________________________________________");
             System.out.println(" ");

        
             
        }
     
   System.out.println(" ##################################################################"
                    + "\n ##################################################################"
                    +"\n #\n # LIVRARIAS\n #"
                    + "\n ##################################################################"
                    + "\n # Comentarios da Carol "
                    + "\n # Classes Pertencentes: Livraria"
                    + "\n # Descrição de Funcionamento: Mostra todos as livrarias cadastradas."
                    + "\n #\n # IMPORTANTE: observe que a 1ª livraria tem 2 catalogos\n #");
   System.out.println(" ##################################################################");
   System.out.println(" ");
    List<Livraria> lista = em.createQuery("from Livraria order by id").getResultList();
        
        for(Livraria lx : lista){
            System.out.println(" ID: " + lx.getId() + 
                               "\n NOME: " + lx.getNome() + 
                               "\n SITE: " + lx.getSite());
            System.out.println("\n LISTA DE CATALOGOS: ");
            for(Catalogo c : lx.getListaCatalogo()) {
                System.out.println(" "+c.getNome() );
            }
             System.out.println("________________________________________________________________________________");
             System.out.println(" ");

        }
    
   System.out.println(" ##################################################################"
                    + "\n ##################################################################"
                    +"\n #\n # CATÁLOGOS\n #"
                    + "\n ##################################################################"
                    + "\n # Comentarios da Carol "
                    + "\n # Classes Pertencentes: Catalogo"
                    + "\n # Descrição de Funcionamento: Mostra todos as catalogos cadastrados."
                    + "\n #\n # IMPORTANTE: observe que a 1º catálogo tem 2 livros\n #");
   System.out.println(" ##################################################################");
   System.out.println(" ");  
   
   
       List<Catalogo>listacat = em.createQuery("from Catalogo order by id").getResultList();
        
        for(Catalogo ct : listacat){
            System.out.println(" ID: " + ct.getId() + 
                               "\n NOME: " + ct.getNome() + 
                               "\n DESCRIÇÃO: " + ct.getDescricao()+ 
                               "\n LIVRARIA: " + ct.getLivraria().getNome());
       System.out.println("\n LISTA DE LIVROS DESSE CATÁLOGO: ");
        for(Livro liv : ct.getListaLivro()) {
                System.out.println(" "+liv.getTitulo());
            }
             System.out.println("________________________________________________________________________________");
             System.out.println(" ");

        } 
   System.out.println(" ##################################################################"
                    + "\n ##################################################################"
                    +"\n #\n # AUTORES\n #"
                    + "\n ##################################################################"
                    + "\n # Comentarios da Carol "
                    + "\n # Classes Pertencentes: Autor"
                    + "\n # Descrição de Funcionamento: Mostra todos os autores cadastrados."
                    + "\n #\n # IMPORTANTE: a lista de livros de cada ator\n #");
   System.out.println(" ##################################################################");
   System.out.println(" ");  
        
      List<Autor> listaA = em.createQuery("from Autor order by id").getResultList();
        
        for(Autor aA : listaA){
            System.out.println(" ID: " + aA.getId() + 
                               "\n NOME: " + aA.getNome() +
                               "\n BIBLIOGRAFIA: " + aA.getBibliografia());
            System.out.println("\n LISTA DE LIVROS CADASTRADOS DESSE AUTOR: ");
            for(LivroBasico llb : aA.getListaEscrito()) {
                System.out.println(" "+llb.getTitulo());
            }
             System.out.println("________________________________________________________________________________");
             System.out.println(" ");

        }      
        
        
   System.out.println(" ##################################################################"
                    + "\n ##################################################################"
                    +"\n #\n # IDIOMA\n #"
                    + "\n ##################################################################"
                    + "\n # Comentarios da Carol "
                    + "\n # Classes Pertencentes: Idioma"
                    + "\n # Descrição de Funcionamento: Mostra todos os idiomas cadastrados." );
   System.out.println(" ##################################################################");
   System.out.println(" ");          
        
        List<Idioma> listah = em.createQuery("from Idioma order by id").getResultList();
        
        for(Idioma idi : listah){
            System.out.println(" ID: " + idi.getId() + 
                               "\n NOME: " + idi.getNome() + 
                               "\n SIGLA: " + idi.getSigla()+
                               "\n -----------------------\n");
        }
        
   System.out.println(" ##################################################################"
                    + "\n ##################################################################"
                    +"\n #\n # FORMATO\n #"
                    + "\n ##################################################################"
                    + "\n # Comentarios da Carol "
                    + "\n # Classes Pertencentes: Formato"
                    + "\n # Descrição de Funcionamento: Mostra todos os formatos cadastrados." );
   System.out.println(" ##################################################################");
   System.out.println(" ");   
    List<Formato> listaD = em.createQuery("from Formato order by id").getResultList();
        
        for(Formato f : listaD){
            System.out.println(" ID: " + f.getId() + 
                               "\n NOME: " + f.getNome()+
                               "\n -----------------------------\n");
        }

    
 

        
        
    }
}
