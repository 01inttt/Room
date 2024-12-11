package tin.dev.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tin.dev.data.model.Product;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Query("SELECT * FROM products WHERE name LIKE '%' || :name || '%'")
    List<Product> findByName(String name);

    @Insert
    void insertAll(Product... products);

    @Delete
    void delete(Product product);
}
