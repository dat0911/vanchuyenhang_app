package com.example.datlogistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.datlogistics.adapter.CustomAdapter;
import com.example.datlogistics.data.DBManager;
import com.example.datlogistics.model.Student;

import java.util.List;

public class dk_thanhcong extends AppCompatActivity {
    private EditText edtName;
    private EditText editAddress;
    private EditText edtPhoneNumber;
    private EditText edtEmail;
    private EditText edtId;
    private EditText edtHthuc;
    private EditText edtLoaihang;
    private EditText edtTrongluong;
    private EditText edtNgayxuatcang;
    private EditText edtNgaynhapcang;
    private ListView lvStudent;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Student> studentList;
    private Button btnsua, btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dk_thanhcong);
        dbManager = new DBManager(this);
        initWidget();
        studentList = dbManager.getAllStudent();
        setAdapter();
        btnsua = (Button) findViewById(R.id.btn_sua);
        btnthoat = (Button) findViewById(R.id.btn_thoat);
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dk_thanhcong.this, sua_kienhang.class);
                startActivity(intent);
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dk_thanhcong.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Student student = studentList.get(position);
//                edtId.setText(String.valueOf(student.getmID()));
//                edtName.setText(student.getmName());
//                editAddress.setText(student.getmAddress());
//                edtEmail.setText(student.getmEmail());
//                edtPhoneNumber.setText(student.getmPhoneNumber());
//                edtHthuc.setText(student.getmHinhthuc());
//                edtLoaihang.setText(student.getmLoaihang());
//                edtTrongluong.setText(student.getmTrongluong());
//                edtNgayxuatcang.setText(student.getmNgayxuatcang());
//                edtNgaynhapcang.setText(student.getmNgaynhapcang());
//
//            }
//        });

        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Student student = studentList.get(position);
                int result = dbManager.deleteStudent(student.getmID());
                if (result > 0) {
                    Toast.makeText(dk_thanhcong.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListStudent();
                } else {
                    Toast.makeText(dk_thanhcong.this, "Delete fail", Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });
    }

    private Student createStudent() {
        String name = edtName.getText().toString();
        String address = String.valueOf(editAddress.getText());
        String phoneNumber = edtPhoneNumber.getText() + "";
        String email = edtEmail.getText().toString();
        String hinhthuc = edtHthuc.getText().toString();
        String loaihang = edtLoaihang.getText().toString();
        String trongluong = edtTrongluong.getText().toString();
        String ngayxuatcang = edtNgayxuatcang.getText().toString();
        String ngaynhapcang = edtNgaynhapcang.getText().toString();

        Student student = new Student(name, address, phoneNumber, email, hinhthuc, loaihang, trongluong,ngayxuatcang,ngaynhapcang );
        return student;
    }

    private void initWidget() {
        edtName = (EditText) findViewById(R.id.edt_name);
        editAddress = (EditText) findViewById(R.id.edt_address);
        edtPhoneNumber = (EditText) findViewById(R.id.edt_number);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtHthuc = (EditText) findViewById(R.id.edt_hinhthuc);
        edtLoaihang = (EditText) findViewById(R.id.edt_loaihang_tenhang);
        edtTrongluong = (EditText) findViewById(R.id.edt_trongluong);
        edtNgayxuatcang = (EditText) findViewById(R.id.edittext_ngayxuatcang);
        edtNgaynhapcang = (EditText) findViewById(R.id.edittext_ngaynhapcang);

        lvStudent = (ListView) findViewById(R.id.lv_student);
        edtId = (EditText) findViewById(R.id.edt_id);

    }

    private void setAdapter() {
        if (customAdapter == null) {
            customAdapter = new CustomAdapter(this, R.layout.item_list_student, studentList);
            lvStudent.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            lvStudent.setSelection(customAdapter.getCount()-1);
        }
    }
    public void updateListStudent(){
        studentList.clear();
        studentList.addAll(dbManager.getAllStudent());
        if(customAdapter!= null){
            customAdapter.notifyDataSetChanged();
        }
    }
}