package br.com.futurodev.m2s09.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "collection_point_material")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionPointMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collection_point_id", nullable = false)
    private CollectionPoint collectionPoint;

    @ManyToOne
    @JoinColumn(name = "electronic_waste_id", nullable = false)
    private ElectronicWaste electronicWaste;

    @Column(nullable = false)
    private Integer maxCapacity;

}
