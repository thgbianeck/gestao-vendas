package br.com.bnck.gvendas.gestaovendas.entidades;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Criado utilizando IntelliJ IDEA.
 * Projeto: gestao-vendas
 * Usuário: Thiago Bianeck (Bianeck)
 * Data: 08/03/2022
 * Hora: 16:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_custo")
    private BigDecimal precoCusto;

    @Column(name = "preco_venda")
    private BigDecimal precoVenda;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private Categoria codigoCategoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Produto produto = (Produto) o;
        return codigo != null && Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
