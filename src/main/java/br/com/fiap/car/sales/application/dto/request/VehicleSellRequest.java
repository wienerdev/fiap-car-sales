package br.com.fiap.car.sales.application.dto.request;

import br.com.fiap.car.sales.application.dto.BaseVehicleRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VehicleSellRequest extends BaseVehicleRequest {

    public VehicleSellRequest(BaseVehicleRequest baseVehicleRequest) {
        super(baseVehicleRequest);
    }
}
