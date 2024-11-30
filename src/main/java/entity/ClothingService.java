package entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс + предоставляет сервисный слой для работы с 
 * сущностью Clothing.
 */
@Service
public class ClothingService {
    private final ClothingRepository clothingRepository;

    /**
     * Конструктор с внедрением зависимости ClothingRepository.
     * 
     * @param clothingRepository - репозиторий для взаимодействия с базой данных.
     */
    @Autowired
    public ClothingService(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }
    
    /**
     * Получает список всех записей одежды.
     * 
     * @return список всех записей Clothing из базы данных.
     */
    public List<Clothing> findAll() {
        return clothingRepository.findAll();
    }
    
    /**
     * Сохраняет новую запись или обновляет существующую запись одежды.
     * 
     * @param clothing - объект Clothing, который нужно сохранить.
     * @return сохранённый объект Clothing.
     */
    public Clothing save(Clothing clothing) {
        return clothingRepository.save(clothing);
    }
    /**
     * Ищет запись одежды по её уникальному идентификатору.
     * 
     * @param id уникальный идентификатор записи.
     * @return  объект Clothing, если запись найдена, или пустой объект, если запись не найдена.
     */
    public Optional<Clothing> findById(Long id) {
        return clothingRepository.findById(id);
    }

    /**
     * Удаляет запись одежды по её уникальному идентификатору.
     * 
     * @param id - уникальный идентификатор записи для удаления.
     */
    public void deleteById(Long id) {
        clothingRepository.deleteById(id);
    }
    /**
     * Ищет записи одежды по указанному материалу.
     * 
     * @param material - материал одежды, по которому осуществляется поиск.
     * @return список записей Clothing, материал которых соответствует переданному значению.
     */
    public List<Clothing> findByMaterial(String material) {
        return clothingRepository.findByMaterial(material);
    }
}
