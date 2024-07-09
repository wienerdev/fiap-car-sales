package br.com.fiap.car.sales.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseVehicleRequest {

    private Long idVeiculo;
    private String cpfCliente;

    public BaseVehicleRequest(BaseVehicleRequest baseVehicleRequest) {
        this.idVeiculo = baseVehicleRequest.getIdVeiculo();
        this.cpfCliente = baseVehicleRequest.getCpfCliente();
    }

}
