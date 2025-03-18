package hcmute.edu.vn.dongquan;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    ImageView logoImage;
    TextView logoName, slogan;
    TextInputLayout username, password, email, phone;
    TextView btnSignUp;
    Button btnLoginAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        // Ánh xạ các View
        logoImage = findViewById(R.id.logo_image);
        logoName = findViewById(R.id.logo_name);
        slogan = findViewById(R.id.logo_text);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.Phone);
        btnSignUp = findViewById(R.id.btn_signup);
        btnLoginAccount = findViewById(R.id.btn_login_account);

        // Chuyển về màn hình Login khi nhấn nút "Bạn đã có tài khoản"
        btnLoginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(logoImage, "logo_image");
                pairs[1] = new Pair<View, String>(logoName, "logo_name");
                pairs[2] = new Pair<View, String>(slogan, "logo_text");
                pairs[3] = new Pair<View, String>(username, "input_username_tran");
                pairs[4] = new Pair<View, String>(password, "input_password_tran");
                pairs[5] = new Pair<View, String>(btnSignUp, "btn_login_tran");
                pairs[6] = new Pair<View, String>(btnLoginAccount, "btn_login_signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
                startActivity(intent, options.toBundle());
                finish();
            }
        });
    }
}
