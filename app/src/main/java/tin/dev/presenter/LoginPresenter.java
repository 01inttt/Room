package tin.dev.presenter;

import android.content.Context;

import androidx.room.Room;

import tin.dev.constract.ILoginConstract;
import tin.dev.data.dao.AppDatabase;
import tin.dev.data.dao.UserDao;
import tin.dev.data.model.User;

public class LoginPresenter implements ILoginConstract.Presenter {
    private ILoginConstract.View mView;
    private AppDatabase db;
    public LoginPresenter(Context context){
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "shop.db")
                .allowMainThreadQueries()
                .createFromAsset("shop.db")
                .build();
    }
    @Override
    public void setView(ILoginConstract.View view) {
        mView = view;
    }

    @Override
    public void doLogin(String email, String password) {
        UserDao userDao = db.userDao();
        User user = userDao.findByEmail(email);
        if(user == null){
            mView.loginFailed();
        }else{
            if(user.password.equals(password)){
                mView.loginSuccess();
            }else{
                mView.loginFailed();
            }
        }
    }
}
