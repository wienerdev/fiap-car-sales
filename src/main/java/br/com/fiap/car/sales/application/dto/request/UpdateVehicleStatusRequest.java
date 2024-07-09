package br.com.fiap.car.sales.application.dto.request;

import br.com.fiap.car.sales.domain.enums.VehicleStatusEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateVehicleStatusRequest {

    private Long id;
    private VehicleStatusEnum status;
}
