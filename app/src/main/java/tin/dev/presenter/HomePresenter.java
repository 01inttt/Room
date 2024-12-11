package tin.dev.presenter;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import tin.dev.constract.IHomeConstract;
import tin.dev.data.dao.AppDatabase;
import tin.dev.data.dao.CategoryDao;
import tin.dev.data.dao.ProductDao;
import tin.dev.data.model.Category;
import tin.dev.data.model.Product;

public class HomePresenter implements IHomeConstract.Presenter {
    private Context mContext;
    private IHomeConstract.View mView;
    private AppDatabase db;

    public HomePresenter(Context context){
        mContext = context;
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "shop.db")
                .allowMainThreadQueries()
                .createFromAsset("shop.db")
                .build();
    }

    @Override
    public void setView(IHomeConstract.View view) {
        mView = view;
    }

    @Override
    public void loadCategories() {
        CategoryDao categoryDao = db.categoryDao();
        List<Category> categoryList = categoryDao.getAll();
        mView.updateCategoriesUI(categoryList);
    }

    @Override
    public void loadProducts() {
        ProductDao productDao = db.productDao();
        List<Product> productList = productDao.getAll();
        mView.updateProductsUI(productList);
    }
}
