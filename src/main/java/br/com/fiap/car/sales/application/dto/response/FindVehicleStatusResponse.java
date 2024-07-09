package br.com.fiap.car.sales.application.dto.response;

import br.com.fiap.car.sales.application.dto.VehicleDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FindVehicleStatusResponse extends VehicleDto {

    public FindVehicleStatusResponse(VehicleDto dto) {
        super(dto);
    }



}
