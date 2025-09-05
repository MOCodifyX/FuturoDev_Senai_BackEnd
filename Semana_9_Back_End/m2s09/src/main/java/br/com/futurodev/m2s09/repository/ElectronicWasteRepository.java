package br.com.futurodev.m2s09.repository;

import br.com.futurodev.m2s09.entity.ElectronicWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicWasteRepository extends JpaRepository<ElectronicWaste, Long> {}

