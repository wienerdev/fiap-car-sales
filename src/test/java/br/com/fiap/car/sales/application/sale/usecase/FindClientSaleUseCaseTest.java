package br.com.fiap.car.sales.application.sale.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities.ClientSaleEntity;
import br.com.fiap.car.sales.application.dto.response.FindClientSaleResponse;
import br.com.fiap.car.sales.application.interfaces.ClientSaleRepository;
import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.utils.ClientSaleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class FindClientSaleUseCaseTest {

    @MockBean
    private ClientSaleRepository clientSaleRepository;

    @MockBean
    private ModelMapper modelMapper;

    private FindClientSaleUseCase findClientSaleUseCase;

    @BeforeEach
    void setUp() {
        findClientSaleUseCase = new FindClientSaleUseCase(clientSaleRepository, modelMapper);
    }

    @Test
    void findAllClientSalesWhenNoSalesExistAndreturnsEmptyList() {
        when(clientSaleRepository.findAll()).thenReturn(List.of());

        List<FindClientSaleResponse> result = findClientSaleUseCase.findAllClientSales();

        assertEquals(0, result.size());
    }

    @Test
    void findAllClientSales_whenSalesExist_returnsListOfSales() {
        ClientSale clientSaleMock = ClientSaleTestUtils.generateClientSale();
        var expectedResponse = ClientSaleTestUtils.generateFindClientSaleResponse();
        List<ClientSale> sales = Arrays.asList(clientSaleMock);
        when(clientSaleRepository.findAll()).thenReturn(sales);
        when(modelMapper.map(any(), eq(FindClientSaleResponse.class))).thenReturn(expectedResponse);

        List<FindClientSaleResponse> result = findClientSaleUseCase.findAllClientSales();

        assertEquals(1, result.size());
        assertEquals(expectedResponse, result.getFirst());
    }
}