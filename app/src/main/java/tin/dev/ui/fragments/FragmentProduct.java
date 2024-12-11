package tin.dev.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import tin.dev.R;

public class FragmentProduct extends Fragment {
    private View view;
    public FragmentProduct() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_product, container, false);
        return view;
    }
}
