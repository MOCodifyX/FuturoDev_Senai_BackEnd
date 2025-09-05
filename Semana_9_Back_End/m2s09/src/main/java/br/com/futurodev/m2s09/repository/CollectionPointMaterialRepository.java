package br.com.futurodev.m2s09.repository;

import br.com.futurodev.m2s09.entity.CollectionPointMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionPointMaterialRepository extends JpaRepository<CollectionPointMaterial, Long> {}

