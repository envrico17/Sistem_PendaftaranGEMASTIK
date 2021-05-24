/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kruwell.program;
import java.io.*;
import java.util.*;
/**
 *
 * @author LENOVO
 */
public class FileManager {
    FileWriter akun;
    String pathToCsv = "D:\\Kuliah Semester 2\\PBO\\Tugas Besar PBO\\Sistem-Pendaftaran-GEMASTIK\\SistemPendaftaranGEMASTIK\\src\\com\\kruwell\\program";
    public static void main (String args[]) {
        FileManager manager = new FileManager();
        manager.CreateFile();
    }
    public void CreateFile() {
        try {
            akun = new FileWriter(pathToCsv+"\\akun.csv",false);
            akun.append("Username");
            akun.append(",");
            akun.append("Universitas");
            akun.append(",");
            akun.append("Divisi");
            akun.append(",");
            akun.append("Nama Ketua");
            akun.append(",");
            akun.append("NIM Ketua");
            akun.append(",");
            akun.append("KTM Ketua");
            akun.append(",");
            akun.append("Nama Anggota1");
            akun.append(",");
            akun.append("NIM Anggota1");
            akun.append(",");
            akun.append("KTM Anggota1");
            akun.append(",");
            akun.append("Nama Anggota2");
            akun.append(",");
            akun.append("NIM Anggota2");
            akun.append(",");
            akun.append("KTM Anggota2");
            akun.append(",");
            akun.append("Password");
            akun.append(",");
            akun.append("Email");
            akun.append(",");
            akun.append("\n");
            akun.flush();
            akun.close();
             System.out.println("Berhasil");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("GAGAL");
        }
    }
    public void Data(String u,String v,String d,String nk,String nimk,String kk,String n1,String nim1,String ka1,String n2,String nim2,String ka2,String p,String e){
        try {
            akun = new FileWriter(pathToCsv+"\\akun.csv",true);
            akun.append(u+","+v+","+d+","+nk+","+nimk+","+kk+","+n1+","+nim1+","+ka1+","+n2+","+nim2+","+ka2+","+p+","+e);
            akun.append("\n");
            akun.flush();
            akun.close();
        }catch (IOException ee) {
            ee.printStackTrace();
        }
    }
    public String[] getData(String u,String p){
        try {
            System.out.println(","+u+" "+p);
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv+"\\akun.csv"));
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data[0].equals(u) && data[12].equals(p)){
                    return data;}
            } System.out.println("berhasil");
                    csvReader.close();
        }catch (IOException bb) {
            System.out.println("gagal");
        }
          return new String[0];
    }
    public void SaveData(Tim newData) {
       try { 
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv+"\\akun.csv"));
           
            String row = "";
            ArrayList<String> simpan = new ArrayList <String>();
            int i = 0;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                //System.out.println(data[0]+""+data[1]);
                //System.out.println(u+" "+data[0]+":"+data[0].equals(u));
                if (data[0].equals(newData.getUsername()) && data[12].equals(newData.getPassword())){
                    System.out.println("data terupdate"); 
                    simpan.add(convertData(newData));
                    System.out.println(">> "+simpan.get(i));
                }else {
                    simpan.add(String.join(",",data)+"\n");
                    System.out.println(">> "+simpan.get(i));
                }
                i++;
            }
            csvReader.close();
            FileWriter save = new FileWriter(pathToCsv+"\\akun.csv",false);
            for (int j=0;j<simpan.size();j++) {
                    System.out.println(">> "+simpan.get(j));
                save.append(simpan.get(j));
            }
            save.flush();
            save.close();
        }catch (IOException cc) {
            System.out.println("gagal");
        }
                
    }
    public String convertData(Tim tmp){
        String result = "";
        result+= tmp.getUsername()+",";
        result+= tmp.getUniversitas()+",";
        result+= tmp.getDivisi()+",";
        result+= tmp.getKetua().Nama+",";
        result+= tmp.getKetua().NIM+",";
        result+= tmp.getKetua().KTM+",";
        result+= tmp.getAnggota1().Nama+",";
        result+= tmp.getAnggota1().NIM+",";
        result+= tmp.getAnggota1().KTM+",";
        result+= tmp.getAnggota2().Nama+",";
        result+= tmp.getAnggota2().Nama+",";
        result+= tmp.getAnggota2().KTM+",";
        result+= tmp.getPassword()+",";
        result+= tmp.getEmail()+"\n";
        return result;
    }
}