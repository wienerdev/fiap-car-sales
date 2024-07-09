package br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities;

import br.com.fiap.car.sales.domain.ClientSale;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client_sale")
public class ClientSaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long idVenda;

    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @Column(name = "cpf_cliente")
    private String cpfCliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_venda")
    private SaleStatusEnum statusVenda;

    @Column(name = "codigo_pagamento")
    private String codigoPagamento;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    public ClientSale toDomain() {
        return ClientSale.builder()
                .idVenda(this.idVenda)
                .idVeiculo(this.idVeiculo)
                .cpfCliente(this.cpfCliente)
                .statusVenda(this.statusVenda)
                .codigoPagamento(this.codigoPagamento)
                .dataVenda(this.dataVenda)
                .build();
    }
}
