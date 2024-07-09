package br.com.fiap.car.sales.application.dto;

import br.com.fiap.car.sales.domain.enums.VehicleStatusEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private BigDecimal preco;
    private Integer quilometragem;
    private String tipoCombustivel;
    private Integer numeroPortas;
    private String tipoTransmissao;
    private String numeroChassi;
    private String placa;
    private String descricao;
    private VehicleStatusEnum status;
    private LocalDateTime dataCadastro;

    public VehicleDto(VehicleDto dto) {
        this.id = dto.getId();
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.ano = dto.getAno();
        this.cor = dto.getCor();
        this.preco = dto.getPreco();
        this.quilometragem = dto.getQuilometragem();
        this.tipoCombustivel = dto.getTipoCombustivel();
        this.numeroPortas = dto.getNumeroPortas();
        this.tipoTransmissao = dto.getTipoTransmissao();
        this.numeroChassi = dto.getNumeroChassi();
        this.placa = dto.getPlaca();
        this.descricao = dto.getDescricao();
        this.status = dto.getStatus();
        this.dataCadastro = dto.getDataCadastro();
    }
}
