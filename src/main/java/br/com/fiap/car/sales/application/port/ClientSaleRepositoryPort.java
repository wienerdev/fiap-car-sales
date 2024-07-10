package br.com.fiap.car.sales.application.port;


import br.com.fiap.car.sales.domain.ClientSale;

import java.util.List;
import java.util.Optional;

public interface ClientSaleRepositoryPort {

    List<ClientSale> findAll();
    Optional<ClientSale> findByVehicleId(Long id);
    Optional<ClientSale> findByPaymentCode(String codigoPagamento);
    ClientSale save(ClientSale vehicle);
}
