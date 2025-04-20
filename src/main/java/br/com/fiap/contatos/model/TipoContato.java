package br.com.fiap.contatos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_TIPO_CONTATO")
public class TipoContato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "T_TIPO_CONTATO_SEQ")
    @SequenceGenerator(
            name = "T_TIPO_CONTATO_SEQ",
            sequenceName = "T_TIPO_CONTATO_SEQ",
            allocationSize = 1)
    public Long id;

    public String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoContato{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
