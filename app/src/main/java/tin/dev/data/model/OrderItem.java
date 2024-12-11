package tin.dev.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_items")
public class OrderItem {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "order_id")
    public int order_id;

    @ColumnInfo(name = "product_id")
    public int product_id;

    @ColumnInfo(name = "quantity")
    public int quantity;

    @ColumnInfo(name = "price")
    public double price;

    @ColumnInfo(name = "created_at")
    public String created_at;

    public OrderItem(int order_id, int product_id, int quantity, double price, String created_at) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
    }
}
