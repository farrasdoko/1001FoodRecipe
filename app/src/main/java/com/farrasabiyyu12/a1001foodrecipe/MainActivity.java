package com.farrasabiyyu12.a1001foodrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_food_name)
    EditText etFoodName;
    @BindView(R.id.et_ingredients_name)
    EditText etIngredientsName;
    @BindView(R.id.btn_find)
    Button btnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_find)
    public void onViewClicked() {
        String q = etFoodName.getText().toString();
        String i = etIngredientsName.getText().toString();

        if (etIngredientsName.getText().toString().contains(" ")){
            etIngredientsName.setError("No Space Allowed");
        } else {
            startActivity(new Intent(MainActivity.this, RecyclerActivity.class)
                    .putExtra("i", i)
                    .putExtra("q", q));
        }
    }
}
