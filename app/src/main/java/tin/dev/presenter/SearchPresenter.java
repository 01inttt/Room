package tin.dev.presenter;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import tin.dev.constract.IHomeConstract;
import tin.dev.constract.ISearchConstract;
import tin.dev.data.dao.AppDatabase;
import tin.dev.data.dao.CategoryDao;
import tin.dev.data.dao.ProductDao;
import tin.dev.data.model.Category;
import tin.dev.data.model.Product;

public class SearchPresenter implements ISearchConstract.Presenter {
    private Context mContext;
    private ISearchConstract.View mView;
    private AppDatabase db;

    public SearchPresenter(Context context){
        mContext = context;
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "shop.db")
                .allowMainThreadQueries()
                .createFromAsset("shop.db")
                .build();
    }

    @Override
    public void setView(ISearchConstract.View view) {
        mView = view;
    }

    @Override
    public void searchByKey(String key) {
        ProductDao productDao = db.productDao();
        List<Product> productList = productDao.findByName(key);
        mView.updateProductsUI(productList);
    }
}
