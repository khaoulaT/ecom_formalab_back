package formalab.gestion.produits.repositories;

import formalab.gestion.produits.entities.ProductFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFileRepository extends JpaRepository<ProductFile, Long> {
    List<ProductFile> findByProductId(Long product_id);
}
