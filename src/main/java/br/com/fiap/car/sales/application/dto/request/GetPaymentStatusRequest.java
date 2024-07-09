package br.com.fiap.car.sales.application.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPaymentStatusRequest {

    private String codigoPagamento;
}
