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
import java.util.*;

import java.util.Date;
import java.text.SimpleDateFormat;
 
import org.joda.time.DateTime;
import org.joda.time.Days;

public class RentalDVD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        // TODO code application logic here
    boolean stop= false;
    int i;
    
	      
    HashMap<String,Anggota> map = new HashMap<String,Anggota>();
    Scanner input = new Scanner(System.in);
    
    do{
		daftarMenu();
            int pil= input.nextInt();
            switch(pil){

                case 1: { 
                    kop("      Registrasi Anggota       ");          
                    Anggota anggota = new Anggota();
                    String id = null;
                    Alamat alm1 = new Alamat();
                    
                    System.out.print("Masukan Nama : "); 
                    
                    
                        {boolean error = true;
                        while(error) {
                            try {
                            anggota.setNama(input.next());
                            error = false;
                            } catch (Exception e) {
                                 System.out.println("Terjadi error : " +e.getMessage());
                                 }
                            }
                        }            
                    
                    
                    System.out.print("Masukan Nomor Identitas: "); 
                    
                    
                      {boolean error = true;
                      while(error) {
                           try {
                            id = input.next();
                            anggota.setNoID(id);
                            error = false;
                            } catch (Exception e) {
                                System.out.println("Terjadi error : " +e.getMessage());
                                }
                            }
                         }            
        
                    
                    System.out.print("Masukan Alamat Jalan : ");
                    input.nextLine();
                    alm1.setJalan(input.nextLine());     
                    
                    
                    System.out.print("Masukan Alamat Desa/Kelurahan : "); 
                    
                        {boolean error = true;
                        while(error) {
                        try {            
                            alm1.setDesa(input.next());
                            error = false;
                        } catch (Exception e) {
                               System.out.println("Terjadi error : " +e.getMessage());
                                  }
                              }
                        }            
                    
                    System.out.print("Masukan Alamat Kecamatan : "); 
                    
                        {boolean error = true;
                        while(error) {
                        try {            
                            alm1.setKecamatan(input.next());
                            error = false;
                         } catch (Exception e) {
                                 System.out.println("Terjadi error : " +e.getMessage());
                                   }
                               }
                        }
        
                    anggota.setAlamat(alm1);                  
                    map.put(id,anggota);                    
                    break;                        
                }
                
                case 2: {                   
                     kop("       Informasi Penyewaan       ");
                    Anggota anggota=null;
                    String tanggal=null,x,id=null;
                    Diskon diskon = new Diskon();
                    
                    System.out.print("Masukan Nomor Identitas : "); 
                    
                         {boolean error = true;
                            while(error) {
                              try {
                                 id = input.next();  
                                 Integer.parseInt(id);
                                 
                           } catch (Exception e) {
                                    System.out.println("Terjadi error : " +e.getMessage());
                                    input.nextInt();
                                    }
                                }
                           }     
                    anggota = map.get(id);
                            
                    System.out.println("*Nama Penyewa : " + anggota.getNama());
                    System.out.print("Masukan Jumlah keping DVD yang disewa(ketik 0 jika tidak ada) : "); 
                   
                            {boolean error = true;
                                while(error) {
                            try {
                                anggota.setDVD(input.nextInt());
                                error = false;
                            } catch (Exception e) {
                                    System.out.println("Terjadi error : " +e.getMessage());
                                    }
                                }
                            }
       
                    System.out.print("Masukan Jumlah keping BlueRay yang disewa ( ketik 0 jika tidak ada) : "); 
       
                            {boolean error = true;
                             while(error) {
                            try {
                                  anggota.setBR(input.nextInt());
                                  error = false;
                            } catch (Exception e) {
                                    System.out.println("Terjadi error : " +e.getMessage());
                                    }
                                }
                           }           
       
       
                      System.out.print("Tanggal sewa (dd-MM-yyyy) : "); 
       
       
                        {boolean error = true;
                        while(error) {
                        try {
                               tanggal = input.next();
                               error = false;
                         } catch (Exception e) {
                                  System.out.println("Terjadi error : " +e.getMessage());
                                 }
                             }
                         }
       
       
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        Date d1 = null;
                        try {
                            d1 = format.parse(tanggal);
                        DateTime dt1 = new DateTime(d1);
                        anggota.setTanggal(dt1);
                        } catch (Exception e) {
                      
                        }
                    
                    System.out.print("Berapa hari DVD akan disewa? : ");
       
       
                        {boolean error = true;
                        while(error) {
                        try {
                              anggota.setHari(input.nextInt());
                              error = false;
                         } catch (Exception e) {
                                 System.out.println("Terjadi error : " +e.getMessage());
                                 }
                             }
                         }    
       
       
                    BiayaSewa biaya = new BiayaSewa();
                    biaya.setHargaSewaDVD(anggota.getHari(), anggota.getDVD());
                    biaya.setHargaSewaBR(anggota.getHari(), anggota.getBR());
                    
                    
                    kop("       Informasi Pembayaran       ");
                    System.out.println("Nama Penyewa : " + anggota.getNama());
                    System.out.println("Nomor Identitas : " + anggota.getNoID());
                    System.out.println("Alamat Rumah : " + anggota.getAlamat().getJalan() + "," + anggota.getAlamat().getDesa() + "," + anggota.getAlamat().getKecamatam());
                    System.out.println("Jumlah DVD yang disewa : " + anggota.getDVD());
                    System.out.println("Jumlah BR yang disewa : " + anggota.getBR());
                    System.out.println("Tanggal pinjam  : " + tanggal );
                    System.out.println("Lama peminjaman : " + anggota.getHari());
                    System.out.println("Potongan harga : Rp. " + biaya.totalDiskon() + ",-" ); 
                    System.out.println("Jumlah yang harus dibayar : Rp." + biaya.totalBiaya() + ",-");
                   
                    
                    break;
                }
                case 3: {
                    kop("       Pengembalian dan Denda       ");
                    int c=0,b=0;
                    String x=null, tanggalKembali=null;
                    System.out.print("Masukan Nomor Identitas : ");
       
                             {boolean error = true;
                             while(error) {
                             try {
                                  x = input.next();
                                  error = false;
                             } catch (Exception e) {
                                      System.out.println("Terjadi error : " +e.getMessage());
                                      }
                                  }
                             }
       
                    Anggota anggota = map.get(x);       
                    Pengembalian kembali = new Pengembalian();
                    
                    System.out.println("Tanggal Pengembalian : " );
       
                             {boolean error = true;
                              while(error) {
                              try {            
                                  tanggalKembali = input.next();
                                  error = false;
                              } catch (Exception e) {
                                         System.out.println("Terjadi error : " +e.getMessage());
                                          }
                                       }
                                 }                 
       
       SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        Date d2;
                        DateTime dt2=null;
                        try {
                            d2 = format.parse(tanggalKembali);
                        dt2 = new DateTime(d2);
                        } catch (Exception e) {
                            
                        }
                     int j = Days.daysBetween(anggota.getTanggal(), dt2).getDays(); 
                     kembali.setLama(anggota.getHari(), j);
                     int a = kembali.getLama();
                
                    System.out.print("Jumlah keping DVD rusak (0 jika tidak ada)");
       
                        {boolean error = true;
                        while(error) {
                        try {
                             b = input.nextInt();
                             error = false;
                        } catch (Exception e) {
                                 System.out.println("Terjadi error : " +e.getMessage());
                                }
                            }
                        }
       
                    System.out.print("Jumlah keping Blue Ray rusak (0 jika tidak ada)");
       
                        {boolean error = true;
                         while(error) {
                        try {
                             c = input.nextInt();
                             error = false;
                        } catch (Exception e) {
                                   System.out.println("Terjadi error : " +e.getMessage());
                                }
                             }
                         }
       
                    kembali.terlambatDVD(a, anggota.getDVD());
                    kembali.terlambatBR(a, anggota.getBR());
                    kembali.rusakDVD(b);
                    kembali.rusakBR(c);
                    
                    kop("       Informasi Denda       ");
                    System.out.println("Nama Penyewa : " + anggota.getNama());
                    System.out.println("Nomor Identitas : " + anggota.getNama());
                    System.out.println("Alamat Rumah : " + anggota.getAlamat().getJalan() + "," + anggota.getAlamat().getDesa() + "," + anggota.getAlamat().getKecamatam());
                    
                        
                    System.out.println("Lama keterlambatan : " + a + " hari");
                    System.out.println("Jumlah DVD yang rusak : " + b + " keping");
                    System.out.println("Jumlah BR yang rusak : " + c + " keping");
                    System.out.println("Jumlah denda yang harus dibayar : Rp." + kembali.totalDenda() + ",-");
                 
                    break;
                }
              
                case 4: { 
                    stop = true;
                }
                default: {
                    break;
                
        }
    }
 }
        while(stop==false)
 }
    
    
    static void kop(String k){
        String grs="==================================";
        System.out.println(grs);
        System.out.println(k);
        System.out.println(grs);

    }
    
    static void daftarMenu(){
	kop ("     Program Penyewaan DVD     ");
	System.out.println ("1. Daftar menjadi anggota");
	System.out.println ("2. Informasi Penyewaan");
        System.out.println ("3. Pengembalian DVD");      
	System.out.println ("4. Keluar");
    }
   
}
