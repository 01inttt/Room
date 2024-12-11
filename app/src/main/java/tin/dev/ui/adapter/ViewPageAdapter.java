package tin.dev.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import tin.dev.ui.fragments.FragmentAccount;
import tin.dev.ui.fragments.FragmentCart;
import tin.dev.ui.fragments.FragmentHome;
import tin.dev.ui.fragments.FragmentProduct;
import tin.dev.ui.fragments.FragmentSearch;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FragmentHome();
        } else if (position == 1) {
            return new FragmentCart();
        } else if (position == 2) {
            return new FragmentProduct();
        } else if (position == 3) {
            return new FragmentSearch();
        } else if (position == 4) {
            return new FragmentAccount();
        } else {
            return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
