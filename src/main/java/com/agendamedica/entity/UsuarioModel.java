package com.agendamedica.entity;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = true)
    private MedicoModel medico;

    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = true)
    private PacienteModel paciente;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id", nullable = true)
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

    public long getId() {
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

    private UsuarioModel(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.senha = builder.senha;
        this.tipoUsuario = builder.tipoUsuario;
        this.medico = builder.medico;
        this.paciente = builder.paciente;
        this.funcionario = builder.funcionario;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static class Builder {
        private Long id;
        private String email;
        private String senha;
        private TipoUsuario tipoUsuario;
        private MedicoModel medico;
        private PacienteModel paciente;
        private FuncionarioModel funcionario;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder tipoUsuario(TipoUsuario tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
            return this;
        }

        public Builder medico(MedicoModel medico) {
            this.medico = medico;
            return this;
        }

        public Builder paciente(PacienteModel paciente) {
            this.paciente = paciente;
            return this;
        }

        public Builder funcionario(FuncionarioModel funcionario) {
            this.funcionario = funcionario;
            return this;
        }

        public UsuarioModel build() {
            return new UsuarioModel(this);
        }
    }
}
