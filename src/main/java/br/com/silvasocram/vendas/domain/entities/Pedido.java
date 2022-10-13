package br.com.silvasocram.vendas.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATA_PEDIDO")
    private LocalDate data;

    @Column
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
}
