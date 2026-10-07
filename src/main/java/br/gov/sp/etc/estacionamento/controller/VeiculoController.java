package br.gov.sp.etc.estacionamento.controller;

import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etc.estacionamento.model.Veiculo;
import br.gov.sp.etc.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("veiculo")
public class VeiculoController {
    @Autowired
    VeiculoService service;
    @PostMapping("cadastar")
    public String cadastrar(Veiculo x){
        service.cadastroVeiculo(x);
        return "registrar-entrada";
    }
    @GetMapping("registrar-entrada")
        public String registrarEntrada(){
            return "registrar-entrada";
    }
    @GetMapping("registrar-saida")
        public String registrarSaida(Model model){
            var veiculos = service.listaVeiculo();
            model.addAttribute("veiculos", veiculos);
            return "registrar-saida";
    }
    @GetMapping("saida/{id}")
    public String getVeiculo(Model model, @PathVariable Long id){
        var veiculos = service.listaVeiculo();
        model.addAttribute("veicuolos", veiculos);
        VeiculoEntity veiculo = service.buscaVeiculoPorId(id);
        model.addAttribute("veiculo", veiculo);
        return "registrar-saida";
    }
}
