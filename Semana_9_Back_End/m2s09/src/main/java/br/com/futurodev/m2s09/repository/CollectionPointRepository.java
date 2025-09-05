package br.com.futurodev.m2s09.repository;

import br.com.futurodev.m2s09.entity.CollectionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {

    @Query("SELECT DISTINCT cp " +
            "FROM CollectionPoint cp " +
            "JOIN cp.acceptedMaterials m " +
            "JOIN m.electronicWaste ew " +
            "WHERE LOWER(ew.type) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<CollectionPoint> findByElectronicWasteNameContaining(@Param("name") String name);

}

