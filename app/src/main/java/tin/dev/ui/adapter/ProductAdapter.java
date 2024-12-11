package tin.dev.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tin.dev.R;
import tin.dev.data.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;
    public ProductAdapter(List<Product> products){
        productList = products;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvName.setText(product.name);
        Picasso.get().load(product.thumbnail).into(holder.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView ivThumbnail;
        public final TextView tvName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            ivThumbnail = view.findViewById(R.id.iv_thumbnail);
            tvName = view.findViewById(R.id.tv_name);
        }
    }
}
