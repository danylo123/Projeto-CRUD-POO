package univs.edu.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import univs.edu.usuario.Usuario;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue
    private int idFuncionario;

    @Column(length = 100, nullable = false)
    private String nomeFuncionario;

    @Column(length = 50, nullable = false)
    private String cargoFuncionario;

    @Column(length = 20, nullable = false)
    private String cpfFuncionario;

    @Column(length = 20, nullable = false)
    private double salarioFuncionario;
       
    @OneToOne
    private Usuario usuario;

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the cargoFuncionario
     */
    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    /**
     * @param cargoFuncionario the cargoFuncionario to set
     */
    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    /**
     * @return the cpfFuncionario
     */
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    /**
     * @param cpfFuncionario the cpfFuncionario to set
     */
    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    /**
     * @return the salarioFuncionario
     */
    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    /**
     * @param salarioFuncionario the salarioFuncionario to set
     */
    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
