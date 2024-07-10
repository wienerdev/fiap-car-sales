package br.com.fiap.car.sales.application.usecase;

import br.com.fiap.car.sales.adapter.out.feign.VehicleRegClient;
import br.com.fiap.car.sales.application.dto.BaseVehicleRequest;
import br.com.fiap.car.sales.application.dto.request.UpdateVehicleStatusRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleReserveRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleSellRequest;
import br.com.fiap.car.sales.application.dto.response.VehicleReserveResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleSellResponse;
import br.com.fiap.car.sales.application.port.ClientSaleRepositoryPort;
import br.com.fiap.car.sales.application.port.VehicleSellUseCasePort;
import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import br.com.fiap.car.sales.domain.enums.VehicleStatusEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class VehicleSellUseCase implements VehicleSellUseCasePort {

    private final VehicleRegClient vehicleRegClient;
    private final ClientSaleRepositoryPort clientSaleRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public VehicleSellResponse sellVehicle(VehicleSellRequest request) {
        updateVehicleStatus(request.getIdVeiculo(), VehicleStatusEnum.VENDIDO);
        ClientSale clientSale = createClientSale(request, SaleStatusEnum.COMPLETO);
        return modelMapper.map(clientSale, VehicleSellResponse.class);
    }

    @Override
    public VehicleReserveResponse reserveVehicle(VehicleReserveRequest request) {
        updateVehicleStatus(request.getIdVeiculo(), VehicleStatusEnum.RESERVADO);
        ClientSale clientSale = createClientSale(request, SaleStatusEnum.PENDENTE);
        return modelMapper.map(clientSale, VehicleReserveResponse.class);
    }

    private ClientSale createClientSale(BaseVehicleRequest request, SaleStatusEnum saleStatus) {
        ClientSale clientSale = clientSaleRepositoryPort.findByVehicleId(request.getIdVeiculo())
                .map(existingClientSale -> ClientSale.builder()
                        .idVenda(existingClientSale.getIdVenda())
                        .idVeiculo(request.getIdVeiculo())
                        .cpfCliente(request.getCpfCliente())
                        .statusVenda(saleStatus)
                        .codigoPagamento(generatePaymentCode())
                        .dataVenda(LocalDateTime.now())
                        .build())
                .orElseGet(() -> ClientSale.builder()
                        .idVeiculo(request.getIdVeiculo())
                        .cpfCliente(request.getCpfCliente())
                        .statusVenda(saleStatus)
                        .codigoPagamento(generatePaymentCode())
                        .dataVenda(LocalDateTime.now())
                        .build());

        return clientSaleRepositoryPort.save(clientSale);
    }

    private void updateVehicleStatus(Long idVeiculo, VehicleStatusEnum vehicleStatus) {
        vehicleRegClient.updateVehicleStatus(
                UpdateVehicleStatusRequest.builder()
                        .id(idVeiculo)
                        .status(vehicleStatus)
                        .build());
    }

    public static String generatePaymentCode() {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder base64Encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[12];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
