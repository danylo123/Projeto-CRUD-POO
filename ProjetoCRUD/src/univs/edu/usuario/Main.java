
package univs.edu.usuario;

import javax.swing.JOptionPane;


public class Main {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
              
        UsuarioDAO dao = new UsuarioDAO();
        
        usuario = dao.pesquisar(2);
        
        usuario.setLoginUsuario("danylo");
        usuario.setSenhaUsuario("danylo123");
        
        dao.editar(usuario);
                             
    }
}
