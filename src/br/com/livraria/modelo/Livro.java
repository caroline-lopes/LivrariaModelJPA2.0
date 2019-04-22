/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Carol Lopes
 */
@Entity
@Table(name = "livro")
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro extends LivroBasico implements Serializable{// LIBERAR A HERANÇA
//public class Livro implements Serializable{
    
    /*----------------------------------------------------------------------------------------------
    //SÓ PRA TESTE
    @Id
    @SequenceGenerator(name = "seq_catalogo", sequenceName = "seq_catalogo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    // O ID DELE É O ISBN DE LIVRO BASICO
    //-------------------------------------------------------------------------------------------------
    */
    @NotNull(message = "O codigoBarras não pode ser nulo")
    @NotBlank(message = "O codigoBarras não pode estar em branco")
    @Column(name = "codigoBarras", nullable = false)
    private String codigoBarras;
    @NotNull(message = "O numeroPaginas não pode ser nulo")
    @NotBlank(message = "O numeroPaginas não pode estar em branco")
    @Column(name = "numeroPaginas", nullable = false)
    private String numeroPaginas;
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro", nullable = false)
    @NotNull(message = "a dataCadastro não pode ser nula!")
    private Calendar dataCadastro;
    @Column(name = "valor",  nullable = true,columnDefinition = "numeric(10,2)")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_idioma")
    private Idioma idioma;
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_formato")
    private Formato formato;
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id")
    @ForeignKey(name = "fk_catalogo")
    private Catalogo catalogo;
    
    
    public Livro(){
     ativo = Boolean.TRUE;
     
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    
    
}
