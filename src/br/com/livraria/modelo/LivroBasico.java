/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Carol Lopes
 */
@Entity
@Table(name = "livroBasico")
@Inheritance(strategy = InheritanceType.JOINED)
public class LivroBasico implements Serializable{
    
    @Id
    @NotNull(message = "Campo titulo não pode ser nulo.")
    @NotBlank(message = "Campo titulo não pode estar em branco.")
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    
    @NotNull(message = "Campo titulo não pode ser nulo.")
    @NotBlank(message = "Campo titulo não pode estar em branco.")
    @Length(max = 255, message = "Campo titulo não pode conter mais que {max} caracteres")
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    @NotNull(message = "Campo resumo não pode ser nulo.")
    @NotBlank(message = "Campo resumo não pode estar em branco.")
    @Length(max = 500, message = "Campo resumo não pode conter mais que {max} caracteres")
    @Column(name = "resumo", nullable = false, length = 500)
    private String resumo;
    @NotNull(message = "Campo editora não pode ser nulo.")
    @NotBlank(message = "Campo editora não pode estar em branco.")
    @Length(max = 50, message = "Campo editora não pode conter mais que {max} caracteres")
    @Column(name = "editora", nullable = false, length = 50)
    private String editora;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPublicacao", nullable = false)
    @NotNull(message = "a dataPublicacao não pode ser nula!")
    private Calendar dataPublicacao;
    
    @ManyToMany
    @JoinTable(name="lBasico_autor",
            joinColumns = 
                @JoinColumn(name = "libroBasico", referencedColumnName = "isbn", nullable = false),
             inverseJoinColumns =       
                @JoinColumn(name="autor", referencedColumnName = "id", nullable = false)
            )
    private Set<Autor> listaAutor = new HashSet<>();
    
    public LivroBasico(){
     
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }

    
    
    
    public void adicionarAutores(Autor a){
        listaAutor.add(a);
    }
    
    public void removerAutores(Autor a){
        listaAutor.remove(a);
    }
    
}
