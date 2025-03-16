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

public class LoginActivity extends AppCompatActivity {

    Button callSignUp;
    ImageView image;
    TextView logoText,slogan,btnLogin;

    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        image = findViewById(R.id.logo_image);
        callSignUp = findViewById(R.id.btn_signup_account);
        logoText= findViewById(R.id.logo_name);
        slogan= findViewById(R.id.logo_text);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        btnLogin= findViewById(R.id.btn_login);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                Pair [] pairs = new Pair[7];
                pairs[0] = new Pair<View,String>(image,"logo_image");
                pairs[1] = new Pair<View,String>(logoText,"logo_name");
                pairs[2] = new Pair<View,String>(slogan,"logo_text");
                pairs[3] = new Pair<View,String>(username,"input_username_tran");
                pairs[4] = new Pair<View,String>(password,"input_password_tran");
                pairs[5] = new Pair<View,String>(btnLogin,"btn_login_tran");
                pairs[6] = new Pair<View,String>(callSignUp,"btn_login_signup_tran");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });



    }
}