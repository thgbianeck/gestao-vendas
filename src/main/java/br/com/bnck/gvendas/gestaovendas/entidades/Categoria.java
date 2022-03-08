package br.com.bnck.gvendas.gestaovendas.entidades;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Criado utilizando IntelliJ IDEA.
 * Projeto: gestao-vendas
 * Usuário: Thiago Bianeck (Bianeck)
 * Data: 08/03/2022
 * Hora: 16:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nome")
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Categoria categoria = (Categoria) o;
        return codigo != null && Objects.equals(codigo, categoria.codigo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
