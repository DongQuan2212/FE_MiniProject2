package hcmute.edu.vn.dongquan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView btnBackMain, imageAvatar;
    private TextView txtFullName, txtEmail;
    private View btnThongKe, btnYourActivity, btnChangePassword, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        // Ánh xạ các View
        btnBackMain = findViewById(R.id.dialog_map);
        imageAvatar = findViewById(R.id.image_avatar);
        txtFullName = findViewById(R.id.txt_fullname);
        txtEmail = findViewById(R.id.txt_email);
        btnThongKe = findViewById(R.id.btn_thongke);
        btnYourActivity = findViewById(R.id.btn_your_activity);
        btnChangePassword = findViewById(R.id.btn_change_password);
        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(view -> {
            // Xử lý đăng xuất
            logoutUser();
        });
        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void logoutUser() {
        // Thực hiện đăng xuất (xoá dữ liệu, chuyển sang màn hình đăng nhập)
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}
