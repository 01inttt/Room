package tin.dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tin.dev.constract.ILoginConstract;
import tin.dev.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginConstract.View, View.OnClickListener {
    private ILoginConstract.Presenter mPresenter;
    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initGUI();
        initData();
    }

    private void initData() {
        mPresenter = new LoginPresenter(this);
        mPresenter.setView(this);
    }

    private void initGUI() {
        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login_button);
        btnRegister = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button) {
            String emailData = edtEmail.getText().toString();
            String passwordData = edtPassword.getText().toString();
            mPresenter.doLogin(emailData, passwordData);
        } else if (v.getId() == R.id.btn_register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}