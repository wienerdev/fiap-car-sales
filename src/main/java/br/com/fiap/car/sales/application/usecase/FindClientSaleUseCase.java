package br.com.fiap.car.sales.application.usecase;

import br.com.fiap.car.sales.application.dto.response.FindClientSaleResponse;
import br.com.fiap.car.sales.application.port.ClientSaleRepositoryPort;
import br.com.fiap.car.sales.application.port.FindClientSaleUseCasePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClientSaleUseCase implements FindClientSaleUseCasePort {

    private final ClientSaleRepositoryPort clientSaleRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public List<FindClientSaleResponse> findAllClientSales() {
        return clientSaleRepositoryPort.findAll().stream()
                .map(entity -> modelMapper.map(entity, FindClientSaleResponse.class))
                .toList();
    }
}
