package br.com.fiap.car.sales.application.sale.usecase;

import br.com.fiap.car.sales.adapter.out.feign.VehicleRegClient;
import br.com.fiap.car.sales.application.dto.BaseVehicleRequest;
import br.com.fiap.car.sales.application.dto.request.GetPaymentStatusRequest;
import br.com.fiap.car.sales.application.dto.request.UpdateVehicleStatusRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleReserveRequest;
import br.com.fiap.car.sales.application.dto.request.VehicleSellRequest;
import br.com.fiap.car.sales.application.dto.response.GetPaymentStatusResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleReserveResponse;
import br.com.fiap.car.sales.application.dto.response.VehicleSellResponse;
import br.com.fiap.car.sales.application.interfaces.ClientSaleRepository;
import br.com.fiap.car.sales.application.sale.port.GetPaymentStatusUseCasePort;
import br.com.fiap.car.sales.application.sale.port.VehicleSellUseCasePort;
import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import br.com.fiap.car.sales.domain.enums.VehicleStatusEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class GetPaymentStatusUseCase implements GetPaymentStatusUseCasePort {

    private final ClientSaleRepository clientSaleRepository;

    @Override
    public GetPaymentStatusResponse getPaymentStatus(GetPaymentStatusRequest request) {
        ClientSale clientSale = clientSaleRepository.findByPaymentCode(request.getCodigoPagamento())
                .orElseThrow(() -> new NotFoundException("Pagamento não encontrado na base de dados."));
        return GetPaymentStatusResponse.builder().codigoPagamento(clientSale.getCodigoPagamento()).statusVenda(clientSale.getStatusVenda()).build();
    }
}
