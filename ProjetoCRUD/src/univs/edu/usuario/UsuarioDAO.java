package univs.edu.usuario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;

public class UsuarioDAO {

    private Session sessao;
    private Transaction transacao;

    public void salvar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        if (usuario.getIdUsuario() == 0) {
            sessao.save(usuario); //Salvar no banco
            JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
        } else {
            editar(usuario);
            JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
        }
        transacao.commit(); //Executar a ação no banco
        sessao.close(); //Fechar a conexão com o banco
    }

    public void excluir(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        sessao.delete(usuario); //Exclui do banco
        transacao.commit(); //Executar a ação no banco
        sessao.close(); //Fechar a conexão com o banco
    }

    public void editar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        sessao.update(usuario); //Atualiza do banco
        transacao.commit(); //Executar a ação no banco
        sessao.close(); //Fechar a conexão com o banco
    }

    public Usuario pesquisar(int idUsuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
        sessao.close();
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        List<Usuario> usuario = sessao.createCriteria(Usuario.class).list();
        sessao.close();
        return usuario;
    }

    public Usuario autenticarUsuario(String loginUsuario, String senhaUsuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("loginUsuario", loginUsuario)).add(Restrictions.eq("senhaUsuario", senhaUsuario)).uniqueResult();
        sessao.close();
        
        return usuario != null ? usuario : null;
    }
    
    public List<Usuario> pesquisar(String campo, String valor){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        List<Usuario> usuario = sessao.createCriteria(Usuario.class).add(Restrictions.ilike(campo, "%"+valor+"%")).list();
        sessao.close();
        return usuario;
    }
    
}
