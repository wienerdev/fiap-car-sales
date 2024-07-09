package br.com.fiap.car.sales.adapter.out.jpa.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import br.com.fiap.car.sales.adapter.out.jpa.ClientSaleJpaRepositoryAdapter;
import br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities.ClientSaleEntity;
import br.com.fiap.car.sales.adapter.out.jpa.vehicle.repositories.ClientSaleJpaRepository;
import br.com.fiap.car.sales.domain.ClientSale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ClientSaleJpaRepositoryAdapterTest {

    @Mock
    private ClientSaleJpaRepository clientSaleJpaRepository;

    @InjectMocks
    private ClientSaleJpaRepositoryAdapter clientSaleJpaRepositoryAdapter;

    @BeforeEach
    void setUp() {
        clientSaleJpaRepositoryAdapter = new ClientSaleJpaRepositoryAdapter(clientSaleJpaRepository);
    }

    @Test
    void findAll_whenRecordsExist_returnsListOfClientSales() {
        ClientSaleEntity clientSaleEntity = mock(ClientSaleEntity.class);
        when(clientSaleJpaRepository.findAll()).thenReturn(List.of(clientSaleEntity, clientSaleEntity));
        when(clientSaleEntity.toDomain()).thenCallRealMethod();

        List<ClientSale> result = clientSaleJpaRepositoryAdapter.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void findAll_whenNoRecordsExist_returnsEmptyList() {
        when(clientSaleJpaRepository.findAll()).thenReturn(List.of());

        List<ClientSale> result = clientSaleJpaRepositoryAdapter.findAll();

        assertTrue(result.isEmpty());
    }

    @Test
    void findByVehicleId_whenRecordExists_returnsClientSale() {
        Long vehicleId = 1L;
        ClientSaleEntity clientSaleEntity = mock(ClientSaleEntity.class);
        when(clientSaleJpaRepository.findClientSaleEntityByIdVeiculo(vehicleId)).thenReturn(Optional.of(clientSaleEntity));
        when(clientSaleEntity.toDomain()).thenCallRealMethod();

        Optional<ClientSale> result = clientSaleJpaRepositoryAdapter.findByVehicleId(vehicleId);

        assertTrue(result.isPresent());
    }

    @Test
    void findByVehicleId_whenRecordDoesNotExist_returnsEmpty() {
        Long vehicleId = 1L;
        when(clientSaleJpaRepository.findClientSaleEntityByIdVeiculo(vehicleId)).thenReturn(Optional.empty());

        Optional<ClientSale> result = clientSaleJpaRepositoryAdapter.findByVehicleId(vehicleId);

        assertTrue(result.isEmpty());
    }

    @Test
    void findByPaymentCode_whenRecordExists_returnsClientSale() {
        String paymentCode = "paymentCode123";
        ClientSaleEntity clientSaleEntity = mock(ClientSaleEntity.class);
        when(clientSaleJpaRepository.findClientSaleEntityByCodigoPagamento(paymentCode)).thenReturn(Optional.of(clientSaleEntity));
        when(clientSaleEntity.toDomain()).thenCallRealMethod();

        Optional<ClientSale> result = clientSaleJpaRepositoryAdapter.findByPaymentCode(paymentCode);

        assertTrue(result.isPresent());
    }

    @Test
    void findByPaymentCode_whenRecordDoesNotExist_returnsEmpty() {
        String paymentCode = "paymentCode123";
        when(clientSaleJpaRepository.findClientSaleEntityByCodigoPagamento(paymentCode)).thenReturn(Optional.empty());

        Optional<ClientSale> result = clientSaleJpaRepositoryAdapter.findByPaymentCode(paymentCode);

        assertTrue(result.isEmpty());
    }

    @Test
    void save_whenCalled_savesAndReturnsClientSale() {
        ClientSale clientSale = mock(ClientSale.class);
        ClientSaleEntity clientSaleEntity = mock(ClientSaleEntity.class);
        when(clientSale.toEntity()).thenReturn(clientSaleEntity);
        when(clientSaleJpaRepository.save(clientSaleEntity)).thenReturn(clientSaleEntity);
        when(clientSaleEntity.toDomain()).thenReturn(clientSale);

        ClientSale result = clientSaleJpaRepositoryAdapter.save(clientSale);

        assertEquals(clientSale, result);
    }
}