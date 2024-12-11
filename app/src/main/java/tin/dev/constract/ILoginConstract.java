package tin.dev.constract;

public interface ILoginConstract {
    interface View{
        void loginFailed();
        void loginSuccess();
    }
    interface Presenter{
        void setView(View view);
        void doLogin(String email, String password);
    }
}
