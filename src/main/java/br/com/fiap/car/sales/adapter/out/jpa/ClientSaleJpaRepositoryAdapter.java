package br.com.fiap.car.sales.adapter.out.jpa;

import br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities.ClientSaleEntity;
import br.com.fiap.car.sales.adapter.out.jpa.vehicle.repositories.ClientSaleJpaRepository;
import br.com.fiap.car.sales.application.interfaces.ClientSaleRepository;
import br.com.fiap.car.sales.domain.ClientSale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientSaleJpaRepositoryAdapter implements ClientSaleRepository {

    private final ClientSaleJpaRepository clientSaleJpaRepository;


    @Override
    public List<ClientSale> findAll() {
        return clientSaleJpaRepository.findAll().stream().map(ClientSaleEntity::toDomain).toList();
    }

    @Override
    public Optional<ClientSale> findByVehicleId(Long id) {
        return clientSaleJpaRepository.findClientSaleEntityByIdVeiculo(id)
                .map(ClientSaleEntity::toDomain);
    }

    @Override
    public Optional<ClientSale> findByPaymentCode(String codigoPagamento) {
        return clientSaleJpaRepository.findClientSaleEntityByCodigoPagamento(codigoPagamento)
                .map(ClientSaleEntity::toDomain);
    }

    @Override
    public ClientSale save(ClientSale sale) {
        return clientSaleJpaRepository.save(sale.toEntity()).toDomain();
    }

}
