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
public class Pengembalian {
    private double dendaTerlambatDVD, dendaTerlambatBR;
    private double dendaKerusakanDVD, dendaKerusakanBR;
    private double total; 
    private int lamaTerlambat;
    
    public Pengembalian (){
        
    }
    
    void setLama(int lamaSewa, int kembali){
        if(kembali>lamaSewa) {
        this.lamaTerlambat = kembali-lamaSewa;
      }
        else this.lamaTerlambat = 0;
    }
    
    int getLama () {
        return lamaTerlambat;
    }
       
    
    void terlambatDVD (int hari, int jumlah){
        this.dendaTerlambatDVD = hari * jumlah * 500;
    }
    
    void terlambatBR (int hari, int jumlah){
        this.dendaTerlambatBR = hari * jumlah * 750;
    }
    
    void rusakDVD (int jumlah)throws Exception{
     if (jumlah >= 0) {
            this.dendaKerusakanDVD = jumlah * 10000;
        } else {
            throw new Exception("Jumlah DVD salah");
        }      
        
    }
    
    void rusakBR (int jumlah)throws Exception{
     if (jumlah >= 0) {
            this.dendaKerusakanBR = jumlah * 25000;
        } else {
            throw new Exception("Jumlah BR salah");
        }      
    }
    
    double totalDenda (){
        total = dendaTerlambatDVD + dendaTerlambatBR + dendaKerusakanDVD + dendaKerusakanBR;
        return total;
    }
    
}
