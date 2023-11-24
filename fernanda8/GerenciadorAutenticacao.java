import java.util.ArrayList;
import java.util.List;

public class GerenciadorAutenticacao {
    private List<Usuario> listaUsuarios;

    public GerenciadorAutenticacao() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Administrador("adm@email.com", "adm123"));
    }

    public Usuario autenticar(String email, String senha) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}
