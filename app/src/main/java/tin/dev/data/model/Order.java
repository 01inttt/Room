package tin.dev.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "orders")
public class Order {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "code")
    public String code;

    @ColumnInfo(name = "status")
    public String status;

    @ColumnInfo(name = "user_id")
    public int user_id;

    public Order( String code, String status, int user_id) {
        this.code = code;
        this.status = status;
        this.user_id = user_id;
    }
}
