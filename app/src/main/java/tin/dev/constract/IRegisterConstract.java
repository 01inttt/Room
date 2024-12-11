package tin.dev.constract;

public interface IRegisterConstract {
    interface View{
        void RegisterFailed();
        void RegisterSuccess();
    }
    interface Presenter{
        void setView(View view);
        void doRegister(String email, String password,String confirmPassword);
    }
}
