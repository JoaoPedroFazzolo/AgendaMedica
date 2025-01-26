package com.agendamedica.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id")
    private MedicoModel medico;

    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteModel paciente;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private FuncionarioModel funcionario;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String email, String senha, TipoUsuario tipoUsuario, MedicoModel medico, PacienteModel paciente, FuncionarioModel funcionario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.medico = medico;
        this.paciente = paciente;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
}
