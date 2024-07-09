package br.com.fiap.car.sales.application.sale.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.fiap.car.sales.application.dto.request.GetPaymentStatusRequest;
import br.com.fiap.car.sales.application.dto.response.GetPaymentStatusResponse;
import br.com.fiap.car.sales.application.interfaces.ClientSaleRepository;
import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.webjars.NotFoundException;

import java.util.Optional;

@SpringBootTest
public class GetPaymentStatusUseCaseTest {

    @MockBean
    private ClientSaleRepository clientSaleRepository;

    private GetPaymentStatusUseCase getPaymentStatusUseCase;

    @BeforeEach
    void setUp() {
        getPaymentStatusUseCase = new GetPaymentStatusUseCase(clientSaleRepository);
    }

    @Test
    void getPaymentStatusWhenPaymentCodeExistsAndReturnsPaymentStatus() {
        GetPaymentStatusRequest request = new GetPaymentStatusRequest("paymentCode123");
        ClientSale clientSale = new ClientSale();
        clientSale.setCodigoPagamento("paymentCode123");
        clientSale.setStatusVenda(SaleStatusEnum.COMPLETO);
        when(clientSaleRepository.findByPaymentCode("paymentCode123")).thenReturn(Optional.of(clientSale));

        GetPaymentStatusResponse response = getPaymentStatusUseCase.getPaymentStatus(request);

        assertEquals("paymentCode123", response.getCodigoPagamento());
        assertEquals(SaleStatusEnum.COMPLETO, response.getStatusVenda());
    }

    @Test
    void getPaymentStatusWhenPaymentCodeDoesNotExistThrowsNotFoundException() {
        GetPaymentStatusRequest request = new GetPaymentStatusRequest("invalidCode");
        when(clientSaleRepository.findByPaymentCode("invalidCode")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> getPaymentStatusUseCase.getPaymentStatus(request));
    }
}