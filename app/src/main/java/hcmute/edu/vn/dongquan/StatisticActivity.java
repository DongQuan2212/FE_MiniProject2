package hcmute.edu.vn.dongquan;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StatisticActivity extends AppCompatActivity {

    private TextView txtTotalKm, txtTotalCalo, txtTotalTime;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_statistic);

        // Ánh xạ các thành phần giao diện
        txtTotalKm = findViewById(R.id.txt_total_km);
        txtTotalCalo = findViewById(R.id.txt_total_calo);
        txtTotalTime = findViewById(R.id.txt_total_time);
        imgBack = findViewById(R.id.imageView8);

        // Thiết lập dữ liệu thống kê
        loadStatistics();

        // Xử lý sự kiện khi nhấn nút quay lại
        imgBack.setOnClickListener(view -> finish());
    }

    private void loadStatistics() {
        // Giả lập dữ liệu, bạn có thể thay bằng dữ liệu thực tế từ database hoặc API
        txtTotalKm.setText("10.5"); // Tổng số km
        txtTotalCalo.setText("500"); // Lượng calo đã tiêu hao
        txtTotalTime.setText("2:30"); // Tổng thời gian tập luyện (giờ:phút)
    }
}
