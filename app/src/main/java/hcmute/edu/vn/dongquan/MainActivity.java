package hcmute.edu.vn.dongquan;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private boolean isClicked = false;

    Animation topAnim, botAnim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Kiểm tra xem đã mở app lần đầu chưa
        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("isFirstTime", true);

        if (!isFirstTime) {
            // Nếu không phải lần đầu, chuyển ngay sang DashboardActivity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
            return;
        }

        // Nếu là lần đầu, tiếp tục hiển thị Splash Screen
        setContentView(R.layout.activity_main);

        // Load animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Ánh xạ view
        image = findViewById(R.id.image_logo);
        logo = findViewById(R.id.txt_Slogan);
        slogan = findViewById(R.id.des_layout_main);
        View rootView = findViewById(android.R.id.content);

        // Gán animation
        image.setAnimation(topAnim);
        logo.setAnimation(botAnim);
        slogan.setAnimation(botAnim);

        // Khi nhấn vào màn hình, chuyển ngay sang Dashboard
        rootView.setOnClickListener(v -> {
            if (!isClicked) {
                isClicked = true;
                goToLogin();
            }
        });

        // Đánh dấu rằng app đã mở lần đầu
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstTime", false);
        editor.apply();
    }
    private void goToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        Pair [] pairs = new Pair[2];
        pairs [0] = new Pair<View,String>(image,"logo_image");
        pairs [1] = new Pair<View,String>(logo,"logo_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
        startActivity(intent,options.toBundle());
    }
}
