package br.com.fiap.car.sales.application.sale.usecase;

import br.com.fiap.car.sales.application.dto.response.FindClientSaleResponse;
import br.com.fiap.car.sales.application.interfaces.ClientSaleRepository;
import br.com.fiap.car.sales.application.sale.port.FindClientSaleUseCasePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClientSaleUseCase implements FindClientSaleUseCasePort {

    private final ClientSaleRepository clientSaleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FindClientSaleResponse> findAllClientSales() {
        return clientSaleRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, FindClientSaleResponse.class))
                .toList();
    }
}
