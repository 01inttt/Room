package tin.dev.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tin.dev.R;
import tin.dev.constract.IHomeConstract;
import tin.dev.constract.ISearchConstract;
import tin.dev.data.model.Product;
import tin.dev.presenter.HomePresenter;
import tin.dev.presenter.SearchPresenter;
import tin.dev.ui.adapter.ProductAdapter;

public class FragmentSearch extends Fragment implements ISearchConstract.View{
    private ISearchConstract.Presenter mPresenter;
    private View view;
    private RecyclerView rvProduct;

    EditText edtSearch;

    public FragmentSearch() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_search, container, false);
        initGUI(view);
        return view;
    }

    private void initGUI(View view) {
        edtSearch = view.findViewById(R.id.edt_search);
        rvProduct = view.findViewById(R.id.rv_product);

        rvProduct.setLayoutManager(new LinearLayoutManager(getContext()));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvProduct.setLayoutManager(gridLayoutManager);

        mPresenter = new SearchPresenter(getContext());
        mPresenter.setView(this);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.searchByKey(s.toString());
            }
        });
    }

    @Override
    public void updateProductsUI(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList);
        rvProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
