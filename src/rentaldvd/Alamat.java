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
public class Alamat {
    private String jalan, kecamatan, desa;
    
    public Alamat(){
        
    }
    
    
    public String getJalan() {
        return jalan;
    }

   
    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    
    public String getKecamatam() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan)throws Exception {
         for (char i : kecamatan.toCharArray()){
                if (!Character.isLetter(i)){
                    throw new Exception("Harus berupa huruf!");
                }
        }
        this.kecamatan = kecamatan;
    }

   
    public String getDesa() {
        return desa;
    }

   
    public void setDesa(String desa)throws Exception {
         for (char i : desa.toCharArray()){
                if (!Character.isLetter(i)){
                    throw new Exception("Harus berupa huruf!");
                }
        }
        this.desa = desa;
    }
    
}
