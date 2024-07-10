package br.com.fiap.car.sales.adapter.in.web;

import br.com.fiap.car.sales.application.dto.request.GetPaymentStatusRequest;
import br.com.fiap.car.sales.application.dto.response.GetPaymentStatusResponse;
import br.com.fiap.car.sales.application.port.GetPaymentStatusUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/webhook")
@RequiredArgsConstructor
public class WebhookSaleController {

    private final GetPaymentStatusUseCasePort getPaymentStatusUseCasePort;

    @GetMapping("/payment-status")
    public ResponseEntity<GetPaymentStatusResponse> getPaymentStatysByPaymentCode(@RequestBody GetPaymentStatusRequest request) {
        return new ResponseEntity<>(getPaymentStatusUseCasePort.getPaymentStatus(request), HttpStatus.OK);
    }

}
