package br.com.silvasocram.vendas.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    private Produto produto;

    @Column
    private Long quantidade;

}
