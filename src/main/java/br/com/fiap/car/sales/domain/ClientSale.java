package br.com.fiap.car.sales.domain;

import br.com.fiap.car.sales.adapter.out.jpa.vehicle.entities.ClientSaleEntity;
import br.com.fiap.car.sales.domain.enums.SaleStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientSale {

    private Long idVenda;
    private Long idVeiculo;
    private String cpfCliente;
    private SaleStatusEnum statusVenda;
    private String codigoPagamento;
    private LocalDateTime dataVenda;

    public ClientSale(ClientSale clientSale) {
        this.idVenda = clientSale.getIdVenda();
        this.idVeiculo = clientSale.getIdVeiculo();
        this.cpfCliente = clientSale.getCpfCliente();
        this.statusVenda = clientSale.getStatusVenda();
        this.codigoPagamento = clientSale.getCodigoPagamento();
        this.dataVenda = clientSale.getDataVenda();
    }

    public ClientSaleEntity toEntity() {
        return ClientSaleEntity.builder()
                .idVenda(this.idVenda)
                .idVeiculo(this.idVeiculo)
                .cpfCliente(this.cpfCliente)
                .statusVenda(this.statusVenda)
                .codigoPagamento(this.codigoPagamento)
                .dataVenda(this.dataVenda)
                .build();
    }
}
