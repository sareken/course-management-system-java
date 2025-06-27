//SARE EKEN 22100011016
package ödev2;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Kursiyer implements Hesaplama {
	private int kursiyerId;
	private String kursiyerAdSoyad;
	private int kursiyerYas;
    public ArrayList<Kurs> alinanKurslar;
	public Kursiyer(int kursiyerId,String kursiyerAdSoyad,int kursiyerYas,ArrayList<Kurs> alinanKurslar)
	{
		this.kursiyerAdSoyad=kursiyerAdSoyad;
		this.kursiyerId=kursiyerId;
		this.kursiyerYas=kursiyerYas;
		this.alinanKurslar = alinanKurslar;
	}

	public ArrayList<Kurs> getAlinanKurslar() {
		return alinanKurslar;
	}

	public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {
		this.alinanKurslar = alinanKurslar;
	}

	
	public int getKursiyerId() {
		return kursiyerId;
	}

	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}

	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}

	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}

	public int getKursiyerYas() {
		return kursiyerYas;
	}

	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}

	 @Override
	 public double BorcHesapla() {
		 
		    int alinanKursSayisi = alinanKurslar.size();
	
            double toplamUcret = 0;
 
            
            if (alinanKursSayisi == 1) {
            	toplamUcret=500;
            	System.out.printf("Herhangi bir kampanyadan yararlanamadınız.Aylık kurs ücretiniz:"+toplamUcret);
            
            }
               
            else if (alinanKursSayisi == 2) {
                toplamUcret = 500 + 500*(80.0/100);
                System.out.printf("Kampanya 1'den yararlandınız.Aylık kurs ücretiniz:"+toplamUcret);
                
                
            }
            
            else if (alinanKursSayisi == 3) {
                toplamUcret = 500 + 500*(80.0/100) + 500*(75.0/100);
 
                System.out.printf("Kampanya 2'den yararlandınız.Aylık kurs ücretiniz: "+toplamUcret);
                
            }
            
            else {
                toplamUcret = alinanKursSayisi *(500*(90.0/100));
                System.out.printf("Kampanya 3'ten yararlandınız.Aylık kurs ücretiniz:"+toplamUcret);
                
            }
            return toplamUcret;
        }

	 }

