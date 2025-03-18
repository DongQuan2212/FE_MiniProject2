package hcmute.edu.vn.dongquan;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Animation topAnim, botAnim,leftAnim;
    private ImageView imageAvatar;
    private TextView textView, txtFullname, textAll;
    private LinearLayout btnCurrentActivity;
    private MaterialCardView materialCardView;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageAvatar = findViewById(R.id.image_avatar);
        txtFullname = findViewById(R.id.txt_fullname);
        textView = findViewById(R.id.txt_hello);
        textAll = findViewById(R.id.txt_all);
        btnCurrentActivity=findViewById(R.id.btn_current_activite);
        recyclerView = findViewById(R.id.list_activities);
        materialCardView = findViewById(R.id.card_list_activites);
        fab = findViewById(R.id.fab);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_animation);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        fab.setAnimation(botAnim);
        imageAvatar.setAnimation(topAnim);
        txtFullname.setAnimation(topAnim);
        textView.setAnimation(topAnim);



        imageAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(imageAvatar, "image_avatar");
                pairs[1] = new Pair<View, String>(txtFullname, "txt_fullname");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentSessionActivity.class);
                startActivity(intent);

            }
        });
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();

            }
        });
        textAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);

            }
        });


    }
    private void showCustomDialog() {
        // Inflate layout của dialog
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_tracking_info, null);
        // Tạo AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        TextView tv_calo_current = dialogView.findViewById(R.id.txt_calo_current);
        TextView tv_km_current = dialogView.findViewById(R.id.txt_km_current);
        TextView tv_time_current = dialogView.findViewById(R.id.txt_time_current);
        TextView tv_date_current = dialogView.findViewById(R.id.txt_date_current);
        ImageView btnDelete = dialogView.findViewById(R.id.btn_delete_activity_current);
        ImageView btn_back = dialogView.findViewById(R.id.btn_back);

        dialog.show();
        btn_back.setOnClickListener(v -> dialog.dismiss());
    }
}