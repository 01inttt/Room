package tin.dev.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tin.dev.data.model.Category;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories")
    List<Category> getAll();

    @Query("SELECT * FROM categories WHERE name = :name LIMIT 1")
    Category findByName(String name);

    @Insert
    void insertAll(Category... categories);

    @Delete
    void delete(Category category);
}
