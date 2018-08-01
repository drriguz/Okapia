package com.riguz.okapia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class LoginActivity extends Activity {
    private Typeface typeface;
    private TextView title;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/AiDeep.otf");
        title = findViewById(R.id.titleText);
        passwordInput = findViewById(R.id.passwordInput);
        title.setTypeface(typeface);

        bindEvents();
    }

    private void bindEvents() {
        passwordInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    private void onEnterPassword() {

    }
}
