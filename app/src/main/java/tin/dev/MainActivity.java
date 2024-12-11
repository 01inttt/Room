package tin.dev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import tin.dev.ui.adapter.ViewPageAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPageAdapter adapter = new ViewPageAdapter(this);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    bottomNavigationView.getMenu().findItem(R.id.menu_trangChu).setChecked(true);
                } else if (position == 1) {
                    bottomNavigationView.getMenu().findItem(R.id.menu_gioHang).setChecked(true);
                } else if (position == 2) {
                    bottomNavigationView.getMenu().findItem(R.id.menu_hangHoa).setChecked(true);
                } else if (position == 3) {
                    bottomNavigationView.getMenu().findItem(R.id.menu_timKiem).setChecked(true);
                } else if (position == 4) {
                    bottomNavigationView.getMenu().findItem(R.id.menu_taiKhoan).setChecked(true);
                }
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_trangChu) {
                    viewPager.setCurrentItem(0, false);
                    return true;
                } else if (item.getItemId() == R.id.menu_gioHang) {
                    viewPager.setCurrentItem(1, false);
                    return true;
                } else if (item.getItemId() == R.id.menu_hangHoa) {
                    viewPager.setCurrentItem(2, false);
                    return true;
                } else if (item.getItemId() == R.id.menu_timKiem) {
                    viewPager.setCurrentItem(3, false);
                    return true;
                } else if (item.getItemId() == R.id.menu_taiKhoan) {
                    viewPager.setCurrentItem(4, false);
                    return true;
                }
                return false;
            }
        });
    }
}