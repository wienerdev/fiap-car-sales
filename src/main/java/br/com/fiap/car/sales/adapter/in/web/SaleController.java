package br.com.fiap.car.sales.adapter.in.web;

import br.com.fiap.car.sales.application.dto.request.VehicleReserveRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleSellRequest;
import br.com.fiap.car.sales.application.dto.response.FindVehicleStatusResponse;
import br.com.fiap.car.sales.application.dto.response.FindClientSaleResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleReserveResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleSellResponse;
import br.com.fiap.car.sales.application.sale.port.FindClientSaleUseCasePort;
import br.com.fiap.car.sales.application.sale.port.FindVehicleSaleUseCasePort;
import br.com.fiap.car.sales.application.sale.port.VehicleSellUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle-sale")
@RequiredArgsConstructor
public class SaleController {

    private final FindVehicleSaleUseCasePort findVehicleSaleUseCasePort;
    private final FindClientSaleUseCasePort findClientSaleUseCasePort;
    private final VehicleSellUseCasePort vehicleSellUseCasePort;

    @GetMapping("/vehicles/available")
    public ResponseEntity<List<FindVehicleStatusResponse>> findAllVehiclesToSaleOrderedByCheapestPrice() {
        return new ResponseEntity<>(findVehicleSaleUseCasePort.findVehiclesToSaleSortedByCheapestPrice(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/sold")
    public ResponseEntity<List<FindVehicleStatusResponse>> findAllSoldVehiclesOrderedByCheapestPrice() {
        return new ResponseEntity<>(findVehicleSaleUseCasePort.findSoldVehiclesSortedByCheapestPrice(), HttpStatus.OK);
    }

    @GetMapping("/sales")
    public ResponseEntity<List<FindClientSaleResponse>> findAllClientSales() {
        return new ResponseEntity<>(findClientSaleUseCasePort.findAllClientSales(), HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<VehicleSellResponse> sellVehicle(@RequestBody VehicleSellRequest request) {
        return new ResponseEntity<>(vehicleSellUseCasePort.sellVehicle(request), HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<VehicleReserveResponse> reserveVehicle(@RequestBody VehicleReserveRequest request) {
        return new ResponseEntity<>(vehicleSellUseCasePort.reserveVehicle(request), HttpStatus.OK);
    }

}
