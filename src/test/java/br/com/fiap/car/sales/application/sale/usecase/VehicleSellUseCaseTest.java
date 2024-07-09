package br.com.fiap.car.sales.application.sale.usecase;

import br.com.fiap.car.sales.adapter.out.feign.VehicleRegClient;
import br.com.fiap.car.sales.application.dto.request.VehicleReserveRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleSellRequest;
import br.com.fiap.car.sales.application.dto.response.VehicleReserveResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleSellResponse;
import br.com.fiap.car.sales.application.interfaces.ClientSaleRepository;
import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import br.com.fiap.car.sales.utils.ClientSaleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class VehicleSellUseCaseTest {

    @MockBean
    private VehicleRegClient vehicleRegClient;

    @MockBean
    private ClientSaleRepository clientSaleRepository;

    @MockBean
    private ModelMapper modelMapper;

    private VehicleSellUseCase vehicleSellUseCase;

    @BeforeEach
    void setUp() {
        vehicleSellUseCase = new VehicleSellUseCase(vehicleRegClient, clientSaleRepository, modelMapper);
    }

    @Test
    void sellVehicleUpdatesVehicleStatusAndCreatesSaleSuccessfully() {
        VehicleSellRequest request = ClientSaleTestUtils.generateVehicleSellRequest();
        ClientSale clientSale = ClientSaleTestUtils.generateClientSale();
        VehicleSellResponse expectedResponse = ClientSaleTestUtils.generateVehicleSellResponse();

        when(clientSaleRepository.findByVehicleId(1L)).thenReturn(Optional.empty());
        when(clientSaleRepository.save(any(ClientSale.class))).thenReturn(clientSale);
        when(modelMapper.map(any(ClientSale.class), eq(VehicleSellResponse.class))).thenReturn(expectedResponse);

        VehicleSellResponse response = vehicleSellUseCase.sellVehicle(request);

        assertEquals(SaleStatusEnum.COMPLETO, response.getStatusVenda());
        verify(vehicleRegClient).updateVehicleStatus(any());
    }

    @Test
    void reserveVehicleUpdatesVehicleStatusAndCreatesReservationSuccessfully() {
        VehicleReserveRequest request = ClientSaleTestUtils.generateVehicleReserveRequest();
        ClientSale clientSale = ClientSaleTestUtils.generateClientSale();
        VehicleReserveResponse expectedResponse = ClientSaleTestUtils.generateVehicleReserveResponse();

        when(clientSaleRepository.findByVehicleId(1L)).thenReturn(Optional.empty());
        when(clientSaleRepository.save(any(ClientSale.class))).thenReturn(clientSale);
        when(modelMapper.map(any(ClientSale.class), eq(VehicleReserveResponse.class))).thenReturn(expectedResponse);

        VehicleReserveResponse response = vehicleSellUseCase.reserveVehicle(request);

        assertEquals(SaleStatusEnum.PENDENTE, response.getStatusVenda());
        verify(vehicleRegClient).updateVehicleStatus(any());
    }

}