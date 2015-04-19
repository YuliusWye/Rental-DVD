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
public class BiayaSewa {
    private double hargaSewaDVD;
    private double hargaSewaBR;
    private double total;
    private double diskonDVD;
    private double diskonBR;   
    
    public BiayaSewa(){
        
    }
    
    void setHargaSewaDVD (int lamaSewa, int jmlDVD){
        Diskon diskon = new Diskon();
        diskon.setDiskonH(lamaSewa);
        diskon.setDiskonJ(jmlDVD);
        this.diskonDVD = diskon.getTotal();
        this.hargaSewaDVD = jmlDVD * lamaSewa * 2000;
    }
    
     
      void setHargaSewaBR (int lamaSewa, int jmlBR){
        Diskon diskon = new Diskon();
        diskon.setDiskonH(lamaSewa);
        diskon.setDiskonJ(jmlBR);
        this.diskonBR = diskon.getTotal();
        this.hargaSewaBR = jmlBR * lamaSewa * 5000;
    }
    
    double totalBiaya (){
        total = (hargaSewaDVD + hargaSewaBR) - (diskonDVD + diskonBR);
        return total;
    }
    
    double totalDiskon (){
        total = diskonDVD + diskonBR;
        return total;
    }
    
}
