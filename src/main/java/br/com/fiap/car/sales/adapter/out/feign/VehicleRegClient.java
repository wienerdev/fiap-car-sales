package br.com.fiap.car.sales.adapter.out.feign;

import br.com.fiap.car.sales.application.dto.VehicleDto;
import br.com.fiap.car.sales.application.dto.request.UpdateVehicleStatusRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "fiap-car-reg", url = "https://fiap-car-reg-api-2-wienerdev-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/api/v1")
public interface VehicleRegClient {

    @GetMapping("/vehicle")
    List<VehicleDto> findAllVehicles();

    @PostMapping("/vehicle")
    VehicleDto updateVehicleStatus(UpdateVehicleStatusRequest dto);
}
