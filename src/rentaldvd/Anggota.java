/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaldvd;

/**
 *
 * @author Yulius
 */

import org.joda.time.DateTime;
public class Anggota {
        
    private String nama;
    private String id;
    private Alamat alamat;
    private int jmlDVD,jmlBR, hariSewa;
    DateTime waktu;
    
   
    
    public Anggota(){
        
    }
    
    void setNama(String nama) throws Exception{
    for (char i : nama.toCharArray()){
                if (!Character.isLetter(i)){
                    throw new Exception("Harus berupa huruf!");
                }
        } 
        this.nama = nama;
    }
    
    void setNoID(String id)throws Exception{
       try {
            Integer.parseInt(id);
        } catch (Exception e) {
            throw new Exception("Harus berupa angka");
        } 
        this.id=id;
    }
    
    String getNama(){
        return nama;
    }
    
    String getNoID(){
        return id;
    }
    
    void setAlamat(Alamat alamat){
        this.alamat = alamat;
    }
    
    Alamat getAlamat(){
        return alamat;
    }
    
    void setDVD(int jmlDVD) throws Exception{
    if (jmlDVD >= 0) {
            this.jmlDVD = jmlDVD;
        } else {
            throw new Exception("Jumlah DVD salah");
        }    
        
    }
    
    int getDVD (){
        return jmlDVD;
    }
    
    void setBR (int jmlBR)throws Exception{
    if (jmlBR >= 0) {
            this.jmlBR = jmlBR;
        } else {
            throw new Exception("Jumlah DVD salah");
        }    
        
    }
    
    int getBR (){
        return jmlBR;
    }
    
    void setHari(int hariSewa)throws Exception{
     if (hariSewa > 0) {
            this.hariSewa = hariSewa;
        } else {
            throw new Exception("Salah input!!!");
        }   
    }
    
    int getHari () {
        return hariSewa;
    }
   
   void setTanggal(DateTime waktu){
        this.waktu = waktu;
    
    }
   
    
    DateTime getTanggal (){
        return waktu;
    }
}
