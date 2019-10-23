
package univs.edu.usuario;

import org.hibernate.Session;
import org.hibernate.Transaction;
import univs.edu.util.HibernateUtil;

public class UsuarioDAO {
    private Session sessao;
    private Transaction transacao;
    
    public void salvar(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction(); //Preparar a sessão para inserir no banco
        sessao.save(usuario); //Salvar no banco
        transacao.commit(); //Executar a ação no banco
        sessao.close(); //Fechar a conexão com o banco
    }
    
    
}


