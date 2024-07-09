package br.com.fiap.car.sales.application.dto.response;

import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPaymentStatusResponse {

    private String codigoPagamento;
    private SaleStatusEnum statusVenda;

}
