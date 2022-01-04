package com.example.datlogistics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    ImageView img;

    EditText edtuser,edtpassword;
    String ten,mk;
    Button btndangnhap, btndangky;
    private  void anhxa(){
        edtuser = (EditText) findViewById(R.id.edittextuser);
        edtpassword = (EditText) findViewById(R.id.edittextpassword);
        btndangnhap = (Button) findViewById(R.id.butondangnhap);
        btndangky = (Button) findViewById(R.id.butondangky);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        edtuser = (EditText) findViewById(R.id.edittextuser);
        edtpassword = (EditText) findViewById(R.id.edittextpassword);
        btndangnhap = (Button) findViewById(R.id.butondangnhap);
        btndangky = (Button) findViewById(R.id.butondangky);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtuser.getText().length() != 0 && edtpassword.getText().length() != 0) {
                    if (edtuser.getText().toString().equals("user") && edtpassword.getText().toString().equals("123456dat")) {
                        Toast.makeText(Login.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else  {
                    Toast.makeText(Login.this, "Tài khoản hoặc mật khẩu không được để trống!", Toast.LENGTH_LONG).show();
                }
//                else {
//                    Intent intent = new Intent(Login.this, Main.class);
//                    intent.putExtra("ten", edtuser.getText().toString());
//                    Toast.makeText(Login.this, "Đăng nhập thành công!", Toast.LENGTH_LONG).show();
//                    startActivity(intent);
//                }
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999&&resultCode==RESULT_OK){
            String setTk = data.getStringExtra("username");
            String setMk = data.getStringExtra("pass");
            edtuser.setText(setTk);
            edtpassword.setText(setMk);
        }
    }
}