package entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс представляет собой репозиторий для работы с 
 * сущностью Clothing в базе данных.
 */
@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {
    List<Clothing> findByMaterial(String material); 
}
