package lbf.com.lesson1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import lbf.com.lesson1.R;
import lbf.com.lesson1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}