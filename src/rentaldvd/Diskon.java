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
public class Diskon {
    private double diskonHari;
    private double diskonJumlah;
    private double total;
    
    public Diskon(){
        this.diskonHari = 0;
        this.diskonJumlah = 0;
    }
    
    void setDiskonH(int hari){
        if (hari <6) {
            this.diskonHari = 0;
        }
        else if(hari>=6&&hari<=12){
            this.diskonHari = hari * 500;
        }
        else if (hari>=13&&hari<=19){
            this.diskonHari = hari * 650;
        }
        else if (hari>=20&&hari<=26){
            this.diskonHari = hari * 850;
        }
        else this.diskonHari = hari * 1100;
    }
    
    void setDiskonJ(int jumlah){
        if (jumlah <6) {
            this.diskonJumlah = 0;
        }
        else if(jumlah>=6&&jumlah<=12){
            this.diskonJumlah = jumlah * 500;
        }
        else if (jumlah>=13&&jumlah<=19){
            this.diskonJumlah = jumlah * 650;
        }
        else if (jumlah>=20&&jumlah<=26){
            this.diskonJumlah = jumlah * 850;
        }
        else this.diskonJumlah = jumlah * 1100;
    }
    
    double getTotal (){
        total = diskonHari + diskonJumlah;
        return total;
    }
    

}
