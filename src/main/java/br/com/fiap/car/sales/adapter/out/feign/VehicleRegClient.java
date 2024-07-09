package br.com.fiap.car.sales.adapter.out.feign;

import br.com.fiap.car.sales.application.dto.VehicleDto;
import br.com.fiap.car.sales.application.dto.request.UpdateVehicleStatusRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "fiap-car-reg", url = "http://localhost:8080/api/v1/vehicle")
public interface VehicleRegClient {

    @RequestMapping(method = RequestMethod.GET)
    List<VehicleDto> findAllVehicles();

    @RequestMapping(method = RequestMethod.PUT)
    VehicleDto updateVehicleStatus(UpdateVehicleStatusRequest dto);
}
