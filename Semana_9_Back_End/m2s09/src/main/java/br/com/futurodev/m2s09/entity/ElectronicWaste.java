package br.com.futurodev.m2s09.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "electronic_waste")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElectronicWaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String type;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

}

