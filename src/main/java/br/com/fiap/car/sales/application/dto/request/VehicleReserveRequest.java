package br.com.fiap.car.sales.application.dto.request;

import br.com.fiap.car.sales.application.dto.BaseVehicleRequest;
import lombok.*;


@NoArgsConstructor
public class VehicleReserveRequest extends BaseVehicleRequest {

    public VehicleReserveRequest(BaseVehicleRequest baseVehicleRequest) {
        super(baseVehicleRequest);
    }

}
