package formalab.gestion.produits.Repositories;

import formalab.gestion.produits.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>  {
    
}