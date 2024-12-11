package tin.dev.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tin.dev.data.model.OrderItem;
import tin.dev.data.model.User;

@Dao
public interface OrderItemDao {
    @Query("SELECT * FROM order_items")
    List<OrderItem> getAll();

    @Query("SELECT * FROM order_items WHERE order_id = :orderId LIMIT 1")
    OrderItem findByOrderID(String orderId);

    @Insert
    void insertAll(OrderItem... orderItems);

    @Delete
    void delete(OrderItem orderItem);
}
