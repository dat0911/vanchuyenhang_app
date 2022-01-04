package com.example.datlogistics.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.datlogistics.R;
import com.example.datlogistics.model.Student;

import java.util.List;

/**
 * Created by chien on 4/10/17.
 */

public class CustomAdapter extends ArrayAdapter<Student> {

    private Context context;
    private int resoure;
    private List<Student> listStudent;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resoure=resource;
        this.listStudent=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_student,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhoneNumber = (TextView)convertView.findViewById(R.id.tv_phone_number);
            viewHolder.tvEmail  = (TextView)convertView.findViewById(R.id.tv_email);
            viewHolder.tvAddress = (TextView)convertView.findViewById(R.id.tv_address);
            viewHolder.tvHinhthuc = (TextView)convertView.findViewById(R.id.tv_hinhthuc);
            viewHolder.tvLoaihang = (TextView)convertView.findViewById(R.id.tv_loaihang);
            viewHolder.tvTrongluong = (TextView)convertView.findViewById(R.id.tv_trongluong);
            viewHolder.tvNgayxuatcang = (TextView)convertView.findViewById(R.id.tv_ngayxuatcang);
            viewHolder.tvNgaynhapcang = (TextView)convertView.findViewById(R.id.tv_ngaynhapcang);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Student student = listStudent.get(position);
        viewHolder.tvId.setText(String.valueOf(student.getmID()));
        viewHolder.tvName.setText(student.getmName());
        viewHolder.tvAddress.setText(student.getmAddress());
        viewHolder.tvEmail.setText(student.getmEmail());
        viewHolder.tvPhoneNumber.setText(student.getmPhoneNumber());
        viewHolder.tvHinhthuc.setText(student.getmHinhthuc());
        viewHolder.tvLoaihang.setText(student.getmLoaihang());
        viewHolder.tvTrongluong.setText(student.getmTrongluong());
        viewHolder.tvNgayxuatcang.setText(student.getmNgayxuatcang());
        viewHolder.tvNgaynhapcang.setText(student.getmNgaynhapcang());

        return convertView;
    }

    public class ViewHolder{

        private TextView tvId;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvEmail;
        private TextView tvPhoneNumber;
        private TextView tvHinhthuc;
        private TextView tvLoaihang;
        private TextView tvTrongluong;
        private TextView tvNgayxuatcang;
        private TextView tvNgaynhapcang;
    }
}
