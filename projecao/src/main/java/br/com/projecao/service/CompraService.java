package br.com.projecao.service;

import br.com.projecao.model.Compra;
import br.com.projecao.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
    @Autowired
    private ComprasRepository repository;

    public void salvarComDescontoOuJuros (Compra compra) {

        if (compra.getValorCompra() < 100) {
            // Aplicar desconto de 10% para compras abaixo a 100 reais
            double desconto = compra.getValorCompra() * 0.10;
            compra.setValorCompra(compra.getValorCompra() - (desconto / 2));
            compra.setValorCompra(compra.getValorCompra() - (desconto / 2));
        } else if (compra.getValorCompra() >= 100) {
            // Aplicar juros de 10% para compras acima ou igual a 100 reais
            double juros = compra.getValorCompra() * 0.10;
            compra.setValorCompra(compra.getValorCompra() + (juros / 2));
            compra.setValorCompra(compra.getValorCompra() + (juros / 2));
        }

        repository.save(compra);
    }
}
