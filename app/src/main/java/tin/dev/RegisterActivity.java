package tin.dev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tin.dev.constract.IRegisterConstract;
import tin.dev.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements IRegisterConstract.View, View.OnClickListener {
    private IRegisterConstract.Presenter mPresenter;

    TextView btnLogin;
    Button btnRegister;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initGUI();
        initData();
    }

    private void initGUI() {
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        edtConfirmPassword = findViewById(R.id.confirm_password);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void initData() {
        mPresenter = new RegisterPresenter(this);
        mPresenter.setView(this);
    }

    @Override
    public void RegisterFailed() {
        Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RegisterSuccess() {
        Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register) {
            String emailData = edtEmail.getText().toString();
            String passwordData = edtPassword.getText().toString();
            String confirmPasswordData = edtConfirmPassword.getText().toString();

            mPresenter.doRegister(emailData, passwordData, confirmPasswordData);
        }
        if (v.getId() == R.id.btn_login) {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}