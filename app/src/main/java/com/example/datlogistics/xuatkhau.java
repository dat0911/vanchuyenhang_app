package com.example.datlogistics;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.datlogistics.adapter.CustomAdapter;
import com.example.datlogistics.data.DBManager;
import com.example.datlogistics.model.Student;
import java.util.List;

public class xuatkhau extends AppCompatActivity {

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
    private Button btnSave;
    private Button btnThemanh;
    private Button btnUpdate;
   // private ListView lvStudent;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuatkhau);
        dbManager = new DBManager(this);
        anhxa();
        studentList = dbManager.getAllStudent();
       // setAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = createStudent();
                if (student != null) {
                    dbManager.addStudent(student);
                }
                if(edtName.getText().toString().isEmpty() || editAddress.getText().toString().isEmpty()||edtPhoneNumber.getText().toString().isEmpty() || edtEmail.getText().toString().isEmpty()|| edtHthuc.getText().toString().isEmpty() || edtLoaihang.getText().toString().isEmpty()|| edtTrongluong.getText().toString().isEmpty() ||edtNgaynhapcang.getText().toString().isEmpty()||edtNgayxuatcang.getText().toString().isEmpty() ){
                    Toast.makeText(xuatkhau.this, "Bạn không được để trống thông tin",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(xuatkhau.this, dk_thanhcong.class);
                    startActivity(intent);
                }

                //updateListStudent();
//                setAdapter();
            }
        });
        btnThemanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(xuatkhau.this,load_file.class);
                startActivity(intent);
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
    private void anhxa() {
        edtName = (EditText) findViewById(R.id.edt_name);
        editAddress = (EditText) findViewById(R.id.edt_address);
        edtPhoneNumber = (EditText) findViewById(R.id.edt_number);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtHthuc = (EditText) findViewById(R.id.edt_hinhthuc);
        edtLoaihang = (EditText) findViewById(R.id.edt_loaihang_tenhang);
        edtTrongluong = (EditText) findViewById(R.id.edt_trongluong);
        edtNgayxuatcang = (EditText) findViewById(R.id.edittext_ngayxuatcang);
        edtNgaynhapcang = (EditText) findViewById(R.id.edittext_ngaynhapcang);

        btnSave = (Button) findViewById(R.id.btn_save);
        btnThemanh = (Button) findViewById(R.id.btn_themanh);
//        lvStudent = (ListView) findViewById(R.id.lv_student);
        edtId = (EditText) findViewById(R.id.edt_id);
    }

//    private void setAdapter() {
//        if (customAdapter == null) {
//            customAdapter = new CustomAdapter(this, R.layout.item_list_student, studentList);
//            lvStudent.setAdapter(customAdapter);
//        }else{
//            customAdapter.notifyDataSetChanged();
//            lvStudent.setSelection(customAdapter.getCount()-1);
//        }
//    }
    public void updateListStudent(){
        studentList.clear();
        studentList.addAll(dbManager.getAllStudent());
        if(customAdapter!= null){
            customAdapter.notifyDataSetChanged();
        }
    }

}
