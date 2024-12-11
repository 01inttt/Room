package tin.dev.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "thumbnail")
    public String thumbnail;

    @ColumnInfo(name = "price")
    public double price;

    @ColumnInfo(name = "quantity")
    public int quantity;

    @ColumnInfo(name = "category_id")
    public int category_id;

    @ColumnInfo(name = "created_at")
    public String created_at;

    public Product(String name, String description, String thumbnail, double price, int quantity, int category_id, String created_at) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
        this.created_at = created_at;
    }
}
