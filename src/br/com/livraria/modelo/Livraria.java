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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Carol Lopes
 */
@Entity
@Table(name = "livraria")
public class Livraria implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_livraria", sequenceName = "seq_livraria_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_livraria", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    @NotNull(message = "O nome da livraria não pode ser nulo")
    @Length(max = 50, message = "O nome da livraria não pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome da livraria não pode estar em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Length(max = 100, message = "O site não pode ter mais que {max} caracteres")
    @Column(name = "site", length = 100, nullable = false)
    private String site;
    @OneToMany(mappedBy = "livraria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Catalogo> listaCatalogo = new ArrayList<>();

    public List<Catalogo> getListaCatalogo() {
        return listaCatalogo;
    }

  
    public Livraria(){
    
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Livraria other = (Livraria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void adicionarCatalogo(Catalogo c){
        listaCatalogo.add(c);
        c.setLivraria(this);
    }
    
    public void removerCatalogo(Catalogo c){
        listaCatalogo.remove(c);
    }
    
    
}
