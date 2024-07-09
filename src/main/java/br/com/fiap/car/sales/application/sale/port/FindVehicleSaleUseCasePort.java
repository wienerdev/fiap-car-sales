package br.com.fiap.car.sales.application.sale.port;

import br.com.fiap.car.sales.application.dto.response.FindVehicleStatusResponse;

import java.util.List;

public interface FindVehicleSaleUseCasePort {

    List<FindVehicleStatusResponse> findVehiclesToSaleSortedByCheapestPrice();
    List<FindVehicleStatusResponse> findSoldVehiclesSortedByCheapestPrice();
}
