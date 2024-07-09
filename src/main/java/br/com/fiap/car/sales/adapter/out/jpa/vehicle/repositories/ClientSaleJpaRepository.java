package br.com.fiap.car.sales.adapter.out.jpa.vehicle.repositories;

import br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities.ClientSaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientSaleJpaRepository extends JpaRepository<ClientSaleEntity, Long> {

    Optional<ClientSaleEntity> findClientSaleEntityByIdVeiculo(Long idVeiculo);
    Optional<ClientSaleEntity> findClientSaleEntityByCodigoPagamento(String codigoPagamento);
}
