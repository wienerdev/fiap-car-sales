package br.com.fiap.car.sales.application.sale.port;

import br.com.fiap.car.sales.application.dto.response.FindClientSaleResponse;

import java.util.List;

public interface FindClientSaleUseCasePort {

    List<FindClientSaleResponse> findAllClientSales();

}
