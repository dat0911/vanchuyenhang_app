package com.example.datlogistics.model;

/**
 * Created by chien on 4/8/17.
 */

public class Student {
    private int mID;
    private String mName;
    private String mAddress;
    private String mPhoneNumber;
    private String mEmail;
    private String mHinhthuc;
    private String mLoaihang;
    private String mTrongluong;
    private String mNgayxuatcang;
    private String mNgaynhapcang;

    public Byte getmHinh() {
        return mHinh;
    }

    public void setmHinh(Byte mHinh) {
        this.mHinh = mHinh;
    }

    private  Byte mHinh;

    public Student() {
    }

    public Student(String mName, String mAddress, String mPhoneNumber, String mEmail, String mHinhthuc, String mLoaihang, String mTrongluong, String mNgayxuatcang, String mNgaynhapcang) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmail = mEmail;
        this.mHinhthuc = mHinhthuc;
        this.mLoaihang = mLoaihang;
        this.mTrongluong = mTrongluong;
        this.mNgayxuatcang = mNgayxuatcang;
        this.mNgaynhapcang = mNgaynhapcang;
    }

    public Student(int mID, String mName, String mAddress, String mPhoneNumber, String mEmail, String mHinhthuc, String mLoaihang, String mTrongluong, String mNgayxuatcang, String mNgaynhapcang) {
        this.mID = mID;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmail = mEmail;
        this.mHinhthuc = mHinhthuc;
        this.mLoaihang = mLoaihang;
        this.mTrongluong = mTrongluong;
        this.mNgayxuatcang = mNgayxuatcang;
        this.mNgaynhapcang = mNgaynhapcang;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmHinhthuc() {
        return mHinhthuc;
    }

    public void setmHinhthuc(String mHinhthuc) {
        this.mHinhthuc = mHinhthuc;
    }

    public String getmLoaihang() {
        return mLoaihang;
    }

    public void setmLoaihang(String mLoaihang) {
        this.mLoaihang = mLoaihang;
    }

    public String getmTrongluong() {
        return mTrongluong;
    }

    public void setmTrongluong(String mTrongluong) {
        this.mTrongluong = mTrongluong;
    }

    public String getmNgayxuatcang() {
        return mNgayxuatcang;
    }

    public void setmNgayxuatcang(String mNgayxuatcang) {
        this.mNgayxuatcang = mNgayxuatcang;
    }

    public String getmNgaynhapcang() {
        return mNgaynhapcang;
    }

    public void setmNgaynhapcang(String mNgaynhapcang) {
        this.mNgaynhapcang = mNgaynhapcang;
    }
}
