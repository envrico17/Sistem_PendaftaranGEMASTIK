/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruwell.program;
import java.io.*;
/**
 *
 * @author LENOVO
 */
public class Tim {
    Peserta Ketua;
    Peserta Anggota1;
    Peserta Anggota2;
    String Universitas;
    String Email;
    String Divisi;
    String Username;
    String Password;
    
    public String getUniversitas() {
        return Universitas;
    }
    public Peserta getKetua() {
        return Ketua;
    }
    public String getDivisi() {
        return Divisi;
    }
    public String getEmail() {
        return Email;
    }
    public Peserta getAnggota1() {
        return Anggota1;
    }
    public Peserta getAnggota2() {
        return Anggota2;
    }
    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public void setData(String s,String p,String user,String d,String e) {
        Universitas = s;
        Password = p;
        Username = user;
        Divisi = d;
        Email = e;
    }
    public void setData(String n,String i,File k) {
        this.Ketua = new Peserta(n,i,k);
    }
    public void setAnggota1(String n,String i,File k) {
        this.Anggota1 = new Peserta(n,i,k);
    }
    public void setAnggota2(String n,String i,File k) {
        this.Anggota2 = new Peserta(n,i,k);
    }
}
