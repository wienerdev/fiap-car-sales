package br.com.fiap.car.sales.application.sale.usecase;

import br.com.fiap.car.sales.adapter.out.feign.VehicleRegClient;
import br.com.fiap.car.sales.application.dto.VehicleDto;
import br.com.fiap.car.sales.application.dto.response.FindVehicleStatusResponse;
import br.com.fiap.car.sales.utils.ClientSaleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FindVehicleSaleUseCaseTest {

    @MockBean
    private VehicleRegClient vehicleRegClient;

    @MockBean
    private ModelMapper modelMapper;

    private FindVehicleSaleUseCase findVehicleSaleUseCase;

    @BeforeEach
    void setUp() {
        findVehicleSaleUseCase = new FindVehicleSaleUseCase(vehicleRegClient, modelMapper);
    }

    @Test
    void findVehiclesToSaleSortedByCheapestPriceWhenAvailableVehiclesExistAndReturnsSortedVehicles() {
        VehicleDto vehicle1 = ClientSaleTestUtils.generateVehicleDtoAvailable();
        List<VehicleDto> vehicles = Arrays.asList(vehicle1);
        when(vehicleRegClient.findAllVehicles()).thenReturn(vehicles);
        when(modelMapper.map(any(VehicleDto.class), eq(FindVehicleStatusResponse.class)))
                .thenAnswer(invocation -> new FindVehicleStatusResponse((invocation.getArgument(0))));

        List<FindVehicleStatusResponse> result = findVehicleSaleUseCase.findVehiclesToSaleSortedByCheapestPrice();

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }

    @Test
    void findVehiclesToSaleSortedByCheapestPriceWhenNoAvailableVehiclesAndReturnsEmptyList() {
        when(vehicleRegClient.findAllVehicles()).thenReturn(Arrays.asList());

        List<FindVehicleStatusResponse> result = findVehicleSaleUseCase.findVehiclesToSaleSortedByCheapestPrice();

        assertTrue(result.isEmpty());
    }

    @Test
    void findSoldVehiclesSortedByCheapestPriceWhenSoldAndReservedVehiclesExistAndReturnsSortedVehicles() {
        VehicleDto vehicle1 = ClientSaleTestUtils.generateVehicleDtoUnavailable();
        List<VehicleDto> vehicles = Arrays.asList(vehicle1);
        when(vehicleRegClient.findAllVehicles()).thenReturn(vehicles);
        when(modelMapper.map(any(VehicleDto.class), eq(FindVehicleStatusResponse.class)))
                .thenAnswer(invocation -> new FindVehicleStatusResponse((invocation.getArgument(0))));

        List<FindVehicleStatusResponse> result = findVehicleSaleUseCase.findSoldVehiclesSortedByCheapestPrice();

        assertEquals(1, result.size());
        assertEquals(1, result.getFirst().getId());
    }

    @Test
    void findSoldVehiclesSortedByCheapestPriceWhenNoSoldOrReservedVehiclesReturnsEmptyList() {
        when(vehicleRegClient.findAllVehicles()).thenReturn(Arrays.asList());

        List<FindVehicleStatusResponse> result = findVehicleSaleUseCase.findSoldVehiclesSortedByCheapestPrice();

        assertTrue(result.isEmpty());
    }
}