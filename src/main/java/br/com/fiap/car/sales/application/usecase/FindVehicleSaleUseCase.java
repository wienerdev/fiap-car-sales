package br.com.fiap.car.sales.application.usecase;

import br.com.fiap.car.sales.adapter.out.feign.VehicleRegClient;
import br.com.fiap.car.sales.application.dto.VehicleDto;
import br.com.fiap.car.sales.application.dto.response.FindVehicleStatusResponse;
import br.com.fiap.car.sales.application.port.FindVehicleSaleUseCasePort;
import br.com.fiap.car.sales.domain.enums.VehicleStatusEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindVehicleSaleUseCase implements FindVehicleSaleUseCasePort {

    private final VehicleRegClient vehicleRegClient;
    private final ModelMapper modelMapper;


    @Override
    public List<FindVehicleStatusResponse> findVehiclesToSaleSortedByCheapestPrice() {
        List<VehicleDto> vehicles = vehicleRegClient.findAllVehicles().stream()
                .filter(entity -> entity.getStatus().equals(VehicleStatusEnum.DISPONIVEL))
                .sorted(Comparator.comparing(VehicleDto::getPreco))
                .toList();

        return vehicles.stream()
                .map(entity -> modelMapper.map(entity, FindVehicleStatusResponse.class))
                .toList();
    }

    @Override
    public List<FindVehicleStatusResponse> findSoldVehiclesSortedByCheapestPrice() {
        List<VehicleDto> vehicles = vehicleRegClient.findAllVehicles().stream()
                .filter(entity -> entity.getStatus().equals(VehicleStatusEnum.VENDIDO) || entity.getStatus().equals(VehicleStatusEnum.RESERVADO))
                .sorted(Comparator.comparing(VehicleDto::getPreco))
                .toList();
        return vehicles.stream().map(entity -> modelMapper.map(entity, FindVehicleStatusResponse.class)).toList();
    }
}
