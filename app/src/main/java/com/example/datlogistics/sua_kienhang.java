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

public class sua_kienhang extends AppCompatActivity {

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
    private Button btncapnhat;
     private ListView lvStudent;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Student> studentList;
    private Button btnhuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_kienhang);
        dbManager = new DBManager(this);
        initWidget();
        studentList = dbManager.getAllStudent();
         setAdapter();
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Student student = createStudent();
//                if (student != null) {
//                    dbManager.addStudent(student);
//                }
//                Intent intent = new Intent(sua_kienhang.this, dk_thanhcong.class);
//                startActivity(intent);
//                updateListStudent();
//                setAdapter();
//            }
//        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sua_kienhang.this, dk_thanhcong.class);
                startActivity(intent);
            }
        });
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Student student = studentList.get(position);
                edtId.setText(String.valueOf(student.getmID()));
                edtName.setText(student.getmName());
                editAddress.setText(student.getmAddress());
                edtEmail.setText(student.getmEmail());
                edtPhoneNumber.setText(student.getmPhoneNumber());
                edtHthuc.setText(student.getmHinhthuc());
                edtLoaihang.setText(student.getmLoaihang());
                edtTrongluong.setText(student.getmTrongluong());
                edtNgayxuatcang.setText(student.getmNgayxuatcang());
                edtNgaynhapcang.setText(student.getmNgaynhapcang());

                //btnSave.setEnabled(false);
               btncapnhat.setEnabled(true);
            }
        });
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                student.setmName(edtName.getText()+"");
                student.setmAddress(editAddress.getText()+"");
                student.setmEmail(edtEmail.getText()+"");
                student.setmPhoneNumber(edtPhoneNumber.getText()+"");
                student.setmHinhthuc(edtHthuc.getText()+"");
                student.setmLoaihang(edtLoaihang.getText()+"");
                student.setmTrongluong(edtTrongluong.getText()+"");
                student.setmNgayxuatcang(edtNgayxuatcang.getText()+"");
                student.setmNgaynhapcang(edtNgaynhapcang.getText()+"");


                int result = dbManager.updateStudent(student);
                if(result>0){
                    updateListStudent();
                }
              //  btnSave.setEnabled(true);
                btncapnhat.setEnabled(false);

            }
        });
        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Student student = studentList.get(position);
                int result = dbManager.deleteStudent(student.getmID());
                if(result>0){
                    Toast.makeText(sua_kienhang.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListStudent();
                }else{
                   Toast.makeText(sua_kienhang.this, "Delete fail", Toast.LENGTH_SHORT).show();
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

        btnhuy = (Button) findViewById(R.id.btn_huy);
        lvStudent = (ListView) findViewById(R.id.lv_student);
        edtId = (EditText) findViewById(R.id.edt_id);
        btncapnhat = (Button) findViewById(R.id.btn_capnhat);
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
