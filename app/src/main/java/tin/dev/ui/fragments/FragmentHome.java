package tin.dev.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tin.dev.R;
import tin.dev.constract.IHomeConstract;
import tin.dev.constract.IRegisterConstract;
import tin.dev.data.model.Category;
import tin.dev.data.model.Product;
import tin.dev.presenter.HomePresenter;
import tin.dev.ui.adapter.CategoryAdapter;
import tin.dev.ui.adapter.ProductAdapter;

public class FragmentHome extends Fragment implements IHomeConstract.View {
    private IHomeConstract.Presenter mPresenter;
    private View view;
    private RecyclerView rvProduct;
    private RecyclerView rvCategory;

    public FragmentHome() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_home, container, false);
        initGUI(view);

        return view;
    }

    private void initGUI(View view) {
        rvProduct = view.findViewById(R.id.rv_product);
        rvProduct.setLayoutManager(new LinearLayoutManager(getContext()));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvProduct.setLayoutManager(gridLayoutManager);

        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));


        mPresenter = new HomePresenter(getContext());
        mPresenter.setView(this);

        mPresenter.loadCategories();
        mPresenter.loadProducts();
    }

    @Override
    public void updateCategoriesUI(List<Category> categoryList) {
        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        rvCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateProductsUI(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList);
        rvProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

