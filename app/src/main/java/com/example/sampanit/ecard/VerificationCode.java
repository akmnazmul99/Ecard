package com.example.sampanit.ecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class VerificationCode extends AppCompatActivity {
    private static Button button_verification_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        onClickVerificationCodeSendButtonListener();
    }
    public void onClickVerificationCodeSendButtonListener(){
        button_verification_code = (Button)findViewById(R.id.verification_code_send_button);
        button_verification_code.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sign_up_intent = new Intent(VerificationCode.this, Main.class);
                        startActivity(sign_up_intent);
                    }
                }
        );
    }
}
