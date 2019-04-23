



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Carol Lopes
 */
@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_catalogo", sequenceName = "seq_catalogo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    @NotNull(message = "O nome do catalogo não pode ser nulo")
    @Length(max = 50, message = "O nome do catalogo não pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome do catalogo não pode estar em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "A descricao do catalogo não pode ser nula")
    @NotBlank(message = "A descricao do catalogo não pode estar em branco")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "livraria", referencedColumnName = "id")
    @ForeignKey(name = "fk_livraria")
    private Livraria livraria;
    
    
    
    
    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Livro> listaLivro = new ArrayList<>();
    
    public Catalogo (){
    
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
//        this.livraria.adicionarCatalogo(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Catalogo other = (Catalogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void adicionarLivro(Livro c){
       listaLivro.add(c);
       c.setCatalogo(this);
    }
    
    public void removerLivro(Livro c){
        listaLivro.remove(c);
    }

    public List<Livro> getListaLivro() {
        return listaLivro;
    }

    public void setListaLivro(List<Livro> listaLivro) {
        this.listaLivro = listaLivro;
    }
  
}
