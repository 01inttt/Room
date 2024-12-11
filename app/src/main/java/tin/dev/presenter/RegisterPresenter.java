package tin.dev.presenter;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import tin.dev.constract.IRegisterConstract;
import tin.dev.data.dao.AppDatabase;
import tin.dev.data.dao.UserDao;
import tin.dev.data.model.User;

public class RegisterPresenter implements IRegisterConstract.Presenter {
    private IRegisterConstract.View mView;
    private AppDatabase db;

    public RegisterPresenter(Context context) {
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "shop.db")
                .allowMainThreadQueries()
                .createFromAsset("shop.db")
                .build();
    }

    @Override
    public void setView(IRegisterConstract.View view) {
        mView = view;
    }

    @Override
    public void doRegister(String email, String password, String confirmPassword) {
        UserDao userDao = db.userDao();
        List<User> users = userDao.getAll();
        boolean successRegister = true;
        boolean isConfirmPass = password.equals(confirmPassword);

        for (User user : users) {
            if (user.email.equals(email)) {
                successRegister = false;
                break;
            }
        }
        if (successRegister && isConfirmPass) {
            User user = new User(email, password, "user");
            userDao.insertAll(user);
            mView.RegisterSuccess();
        } else {
            mView.RegisterFailed();
        }
    }
}
