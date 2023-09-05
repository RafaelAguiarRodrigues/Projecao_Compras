package br.com.projecao.controller;

import br.com.projecao.model.Compra;
import br.com.projecao.model.DadosAlteracaoCompra;
import br.com.projecao.model.DadosCompra;
import br.com.projecao.repository.ComprasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class ComprasController {
    @Autowired
    private ComprasRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaForm (Long id, Model model) {
        if (id != null) {
            var compra = repository.getReferenceById(id);
            model.addAttribute("compra", compra);
        }
        return "compras/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem (Model model) {
        model.addAttribute("lista", repository.findAll());
        return "compras/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastrarCompra (DadosCompra dados) {
        var compra = new Compra(dados);
        repository.save(compra);

        return "redirect:/compras";
    }

    @PutMapping
    @Transactional
    public String alteraCompra (DadosAlteracaoCompra dados) {
        var compra = repository.getReferenceById(dados.id());
        compra.atualizarDados(dados);

        return "redirect:/compras";
    }

    @DeleteMapping
    @Transactional
    public String deletarCompra(Long id) {
        repository.deleteById(id);

        return "redirect:/compras";
    }


}
