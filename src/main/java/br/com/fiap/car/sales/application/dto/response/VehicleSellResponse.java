package br.com.fiap.car.sales.application.dto.response;

import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleSellResponse {

    private Long idVenda;
    private Long idVeiculo;
    private String cpfCliente;
    private SaleStatusEnum statusVenda;
    private String codigoPagamento;
    private LocalDateTime dataVenda;

}
