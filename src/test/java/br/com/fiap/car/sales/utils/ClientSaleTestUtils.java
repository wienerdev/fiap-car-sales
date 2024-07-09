package br.com.fiap.car.sales.utils;

import br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities.ClientSaleEntity;
import br.com.fiap.car.sales.application.dto.BaseVehicleRequest;
import br.com.fiap.car.sales.application.dto.VehicleDto;
import br.com.fiap.car.sales.application.dto.request.VehicleReserveRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleSellRequest;
import br.com.fiap.car.sales.application.dto.response.FindClientSaleResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleReserveResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleSellResponse;
import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import br.com.fiap.car.sales.domain.enums.VehicleStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ClientSaleTestUtils {

    private ClientSaleTestUtils() {
    }

    static LocalDateTime now = LocalDateTime.now();

    public static VehicleSellRequest generateVehicleSellRequest() {
        return new VehicleSellRequest(BaseVehicleRequest.builder().idVeiculo(1L).cpfCliente("12345678900").build());
    }

    public static VehicleReserveRequest generateVehicleReserveRequest() {
        return new VehicleReserveRequest(BaseVehicleRequest.builder().idVeiculo(1L).cpfCliente("12345678900").build());
    }

    public static FindClientSaleResponse generateFindClientSaleResponse() {
        return FindClientSaleResponse.builder()
                .idVenda(1L)
                .cpfCliente("12345678901")
                .idVeiculo(1L)
                .codigoPagamento("123456")
                .statusVenda(SaleStatusEnum.COMPLETO)
                .dataVenda(now)
                .build();
    }

    public static ClientSale generateClientSale() {
        return ClientSale.builder()
                .idVenda(1L)
                .cpfCliente("12345678901")
                .idVeiculo(1L)
                .codigoPagamento("123456")
                .statusVenda(SaleStatusEnum.COMPLETO)
                .dataVenda(now)
                .build();
    }

    public static ClientSaleEntity generateClientSaleEntity() {
        return ClientSaleEntity.builder()
                .idVenda(1L)
                .cpfCliente("12345678901")
                .idVeiculo(1L)
                .codigoPagamento("123456")
                .statusVenda(SaleStatusEnum.COMPLETO)
                .dataVenda(now)
                .build();
    }

    public static VehicleDto generateVehicleDtoAvailable() {
        return VehicleDto.builder()
                .id(1L)
                .marca("Fiat")
                .modelo("Uno")
                .ano(2021)
                .cor("Branco")
                .preco(BigDecimal.valueOf(20000.0))
                .quilometragem(0)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Manual")
                .numeroChassi("123456")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(now)
                .build();
    }

    public static VehicleDto generateVehicleDtoUnavailable() {
        return VehicleDto.builder()
                .id(1L)
                .marca("Fiat")
                .modelo("Uno")
                .ano(2021)
                .cor("Branco")
                .preco(BigDecimal.valueOf(20000.0))
                .quilometragem(0)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Manual")
                .numeroChassi("123456")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado")
                .status(VehicleStatusEnum.VENDIDO)
                .dataCadastro(now)
                .build();
    }

    public static VehicleSellResponse generateVehicleSellResponse() {
        return VehicleSellResponse.builder()
                .idVenda(1L)
                .cpfCliente("12345678901")
                .idVeiculo(1L)
                .codigoPagamento("123456")
                .statusVenda(SaleStatusEnum.COMPLETO)
                .dataVenda(now)
                .build();
    }

    public static VehicleReserveResponse generateVehicleReserveResponse() {
        return VehicleReserveResponse.builder()
                .idVenda(1L)
                .cpfCliente("12345678901")
                .idVeiculo(1L)
                .codigoPagamento("123456")
                .statusVenda(SaleStatusEnum.PENDENTE)
                .dataVenda(now)
                .build();
    }
}
