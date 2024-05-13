package fr.fms.dao;

import fr.fms.entities.Category;
import fr.fms.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
