package br.com.fiap.car.sales.application.usecase;

import br.com.fiap.car.sales.application.dto.request.GetPaymentStatusRequest;
import br.com.fiap.car.sales.application.dto.response.GetPaymentStatusResponse;
import br.com.fiap.car.sales.application.port.ClientSaleRepositoryPort;
import br.com.fiap.car.sales.application.port.GetPaymentStatusUseCasePort;
import br.com.fiap.car.sales.domain.ClientSale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class GetPaymentStatusUseCase implements GetPaymentStatusUseCasePort {

    private final ClientSaleRepositoryPort clientSaleRepositoryPort;

    @Override
    public GetPaymentStatusResponse getPaymentStatus(GetPaymentStatusRequest request) {
        ClientSale clientSale = clientSaleRepositoryPort.findByPaymentCode(request.getCodigoPagamento())
                .orElseThrow(() -> new NotFoundException("Pagamento não encontrado na base de dados."));
        return GetPaymentStatusResponse.builder().codigoPagamento(clientSale.getCodigoPagamento()).statusVenda(clientSale.getStatusVenda()).build();
    }
}
