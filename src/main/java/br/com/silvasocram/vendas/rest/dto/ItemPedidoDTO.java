package br.com.silvasocram.vendas.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Long produto;
    private Long quantidade;

}
