package br.gov.sp.etc.estacionamento.service;

import br.gov.sp.etc.estacionamento.model.Usuario;
import org.hibernate.annotations.processing.Find;

import java.util.List;

public interface UsuarioService {
    String cadastrarUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    String atualizarUsuario(Usuario usuario);
    String deletarUsuario(Long id);
    Usuario buscaUsuarioPorEmail(String email);
}
