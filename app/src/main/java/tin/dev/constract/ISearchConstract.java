package tin.dev.constract;
import java.util.List;

import tin.dev.data.model.Category;
import tin.dev.data.model.Product;

public interface ISearchConstract {
    interface View{
        void updateProductsUI(List<Product> productList);
    }
    interface Presenter{
        void setView(View view);
        void searchByKey(String key);
    }
}
