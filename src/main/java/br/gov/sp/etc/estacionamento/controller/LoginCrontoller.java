package br.gov.sp.etc.estacionamento.controller;

import br.gov.sp.etc.estacionamento.model.Usuario;
import br.gov.sp.etc.estacionamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginCrontoller {
    private static final Logger log = LoggerFactory.getLogger(LoginCrontoller.class);

    @Autowired
    UsuarioService service;

    @GetMapping ("/")
    public String index() {
        return "login";
    }
    @GetMapping ("/cadastro")
    public String cadastrar() {
        return "tela-cadastro";
    }
    @PostMapping ("/efetuar-cadastro")
        public String efetuarCadastro(Usuario usuario){
            log.info(usuario.toString());
            service.cadastrarUsuario(usuario);
            return "cadastro-success";
    }

    public String autenticar(String email, String senha){
        Usuario xpto = service.buscaUsuarioPorEmail(email);
        if(xpto != null && senha.equals(xpto.getSenha())){
            return "painel";
        }else {
            return "erro";
        }
    }
}
