package br.com.fiap.car.sales.application.sale.port;

import br.com.fiap.car.sales.application.dto.request.VehicleReserveRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleSellRequest;
import br.com.fiap.car.sales.application.dto.response.VehicleReserveResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleSellResponse;

public interface VehicleSellUseCasePort {

    VehicleSellResponse sellVehicle(VehicleSellRequest request);
    VehicleReserveResponse reserveVehicle(VehicleReserveRequest request);

}
