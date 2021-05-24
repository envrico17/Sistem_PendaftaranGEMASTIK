package com.kruwell.program;
import java.io.*;


/**
 *
 * @author LENOVO
 */
public class Peserta {
    public String Nama;
    public String NIM;
    final File KTM;
    
   public Peserta(String n,String i,File k){
        this.Nama = n;
        this.NIM = i;
        this.KTM = k;
    }
   public String getNama() {
       return this.Nama;
   }
   public String getNIM() {
       return this.NIM;
   }
   public File getKTM() {
       return this.KTM;
   }
}

