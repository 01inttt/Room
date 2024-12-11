package tin.dev.constract;

import java.util.List;

import tin.dev.data.model.Category;
import tin.dev.data.model.Product;

public interface IHomeConstract {
    interface View{
        void updateCategoriesUI(List<Category> categoryList);
        void updateProductsUI(List<Product> productList);
    }
    interface Presenter{
        void setView(View view);
        void loadCategories();
        void loadProducts();
    }
}
