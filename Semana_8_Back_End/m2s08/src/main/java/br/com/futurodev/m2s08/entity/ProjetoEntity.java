package br.com.futurodev.m2s08.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projetos")
@Data
@NoArgsConstructor
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false, length = 100)
    private String regiao;

    @Column(name = "estimativa_co2", nullable = false)
    private Double estimativaReducaoCO2;

    // Relacionamento com OrganizacaoEntity
    @ManyToOne
    @JoinColumn(name = "organizacao_id", nullable = false)
    private OrganizacaoEntity organizacao;
}

