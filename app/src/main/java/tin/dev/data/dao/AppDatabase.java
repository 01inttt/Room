package tin.dev.data.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import tin.dev.data.model.Category;
import tin.dev.data.model.Order;
import tin.dev.data.model.OrderItem;
import tin.dev.data.model.Product;
import tin.dev.data.model.User;

@Database(entities = {User.class, Product.class, OrderItem.class, Order.class, Category.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract ProductDao productDao();
    public abstract OrderItemDao orderItemDao();
    public abstract OrderDao orderDao();
    public abstract CategoryDao categoryDao();
}
