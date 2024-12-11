package tin.dev.data.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tin.dev.data.model.Order;
import tin.dev.data.model.User;

@Dao
public interface OrderDao {
    @Query("SELECT * FROM orders")
    List<Order> getAll();

    @Query("SELECT * FROM orders WHERE code = :code LIMIT 1")
    Order findByCode(String code);

    @Insert
    void insertAll(Order... orders);

    @Delete
    void delete(Order order);
}
