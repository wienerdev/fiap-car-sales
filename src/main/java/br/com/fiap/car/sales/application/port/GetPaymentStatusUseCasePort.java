package br.com.fiap.car.sales.application.port;

import br.com.fiap.car.sales.application.dto.request.GetPaymentStatusRequest;
import br.com.fiap.car.sales.application.dto.response.GetPaymentStatusResponse;

public interface GetPaymentStatusUseCasePort {

    GetPaymentStatusResponse getPaymentStatus(GetPaymentStatusRequest codigoPagamento);

}
