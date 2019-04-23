/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Carol Lopes
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable{
    @Id
    @SequenceGenerator(name = "autor_id", allocationSize = 1, sequenceName = "id_autor")
    @GeneratedValue(generator = "autor_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 50)
    @NotBlank(message = "Campo nome precisa ser informado")
    @Length(max=50, message = "Campo nome não pode conter mais que {max} caracteres")
    private String nome;    
    
    @Column(name = "bibliografia", nullable = false, columnDefinition = "text")
    @NotBlank(message = "Campo bibliografia precisa ser informado")
    private String bibliografia; 
    
    @ManyToMany
    @JoinTable(name="lBasico_autor",
            joinColumns = 
                @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false),
             inverseJoinColumns =       
                @JoinColumn(name="livroBasico", referencedColumnName = "isbn", nullable = false)
            )
    private Set<LivroBasico> listaEscrito = new HashSet<>();
    
    public Autor(){
    
    }
      
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    public void adicionarLivros(LivroBasico l){
        listaEscrito.add(l);
    }
    
    public void removerLivros(LivroBasico l){
        listaEscrito.remove(l);
    }

    public Set<LivroBasico> getListaEscrito() {
        return listaEscrito;
    }

    public void setListaEscrito(Set<LivroBasico> listaEscrito) {
        this.listaEscrito = listaEscrito;
    }
    
    
}
