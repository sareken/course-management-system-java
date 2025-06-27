//SARE EKEN 22100011016
package ödev2;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AnaSayfa {

	static ArrayList<Kursiyer> kursiyerler= new ArrayList<>();
	static ArrayList<Kurs> alinanKurslar = new ArrayList<>();
	static ArrayList<Kurs> kurslar = new ArrayList<>();
	private static Scanner input = new Scanner(System.in);
	
	
	
	
	
	public static void KursEkle()
	{
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Yeni kurs ID'sini girin: ");
			int kursId = scanner.nextInt();
			scanner.nextLine(); 
			System.out.print("Kurs Adı: ");
			String kursAd = scanner.nextLine();
			boolean kursVarMi = kurslar.stream().anyMatch(Kurs -> Kurs.getKursId() == kursId);//AYNI İDDE KURS VAR MI KONTROL 
			if (kursVarMi==false) {//EGER KOŞUL SAĞLANIRSA TRUE DÖNDÜRECEK METOD 
			    Kurs yeniKurs = new Kurs(kursId, kursAd);
			    kurslar.add(yeniKurs);
			    System.out.println("Kurs eklendi.");
			} 
			else 
			{
			    System.out.println("Bu ID'ye sahip bir kurs zaten var!");
			}
		}
	}
	
	
	
	
	
	
	public static void KursListele()
	{   System.out.println("Kurs Id   Kurs Adı");
		for (Kurs kurs : kurslar) {
            System.out.printf("%-9d%-15s%n", kurs.getKursId(), kurs.getKursAd());
        }
    }
	
	
	
	
	
	
	public static void KursAra()
	{
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Aranacak kurs adı: ");
			String arananKursAdi = scanner.nextLine();

			boolean kursBulundu = false;
			for (Kurs kurs : kurslar) {
			    if (kurs.getKursAd().equals(arananKursAdi))
			    {
			        System.out.println("Kurs ID: " + kurs.getKursId());
			        System.out.println("Kurs Adı: " + kurs.getKursAd());
			        kursBulundu = true;
			        break;
			    }
			}

			if (kursBulundu == false ) {
			    System.out.println("Kurs bulunamadı.");
			}
		}
	}
	
	
	
	
	
	
	public static void KursSil()
	{
		    try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Silinecek kurs adı: ");
				String silinecekKursAdi = scanner.nextLine();

				boolean kursVarMi = kurslar.removeIf(kurs -> kurs.getKursAd().equals(silinecekKursAdi));//GİRİLEN ADDA KURS VAR MI KONTROLÜ

				if (kursVarMi) {
				    System.out.println("Kurs silindi.");
				} else {
				    System.out.println("Kurs bulunamadı veya kursu alan kursiyer bulunuyor.");
				}
			}
	}
	
	
	
	
	
	
	public static void KursiyerEkle(ArrayList <Kursiyer> kursiyerler) {
	    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Kursiyer ID'si: ");
			int kursiyerId = scanner.nextInt();
			scanner.nextLine();
			boolean kursiyerVarMi=false;
			for (Kursiyer kursiyer : kursiyerler) {
				if (kursiyer.getKursiyerId() == kursiyerId);//AYNI İDDE KURSİYER VAR MI KONTROL 
				     kursiyerVarMi =true;
				     break;
				     }
			
           if(kursiyerVarMi==true) {
			    System.out.println("Bu ID'ye sahip bir kursiyer zaten var!");
                }
           else {
   
			   System.out.print("Ad Soyad: ");
			   String kursiyerAdSoyad = scanner.nextLine();
			   System.out.print("Yaş: ");
			   int kursiyerYas = scanner.nextInt();
			   
			   ArrayList<Kurs> eklenecek_kurs = new ArrayList<Kurs>();
			  
			   System.out.print("Kac Tane Kurs 	Eklemek İstersiniz:");
			   int kurs_sayisi = scanner.nextInt();
   
			   for(int i=0;i<kurs_sayisi;i++)
			   { 
				   KursListele();//KURSLARI LİSTELEYEREK SEÇİM İSTİYOR.
				   System.out.print((i+1) + ". kursun ID'sini girin: ");
			       int ıd_kurs = scanner.nextInt();
			       System.out.println((i+1) + ". kursun ismini giriniz:");
				   String kurs_ad = scanner.next();
				   eklenecek_kurs.add(new Kurs(ıd_kurs,kurs_ad));
			  
			   }
			   kursiyerler.add(new Kursiyer(kursiyerId,kursiyerAdSoyad,kursiyerYas,eklenecek_kurs));
			   System.out.print("Kursiyer eklendi.");
    
			  }
		}

	}
	
	

	
	
	
	public static void KursiyerAra(){
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Aranacak kursiyer ad-soyad: ");
			String arananKursiyerAdSoyad = scanner.nextLine();

			boolean kursiyerBulundu = false;
			for (Kursiyer kursiyer : kursiyerler) {
			    if (kursiyer.getKursiyerAdSoyad().equals(arananKursiyerAdSoyad)) {
			        System.out.println("Kursiyer ID: " + kursiyer.getKursiyerId());
			        System.out.println("Ad Soyad: " + kursiyer.getKursiyerAdSoyad());
			        System.out.println("Yaş: " + kursiyer.getKursiyerYas());
			        kursiyerBulundu = true;
			        break;
			    }
			}

			if (kursiyerBulundu == false ) {
			    System.out.println("Kursiyer bulunamadı.");
			}
		}
	}
	
	
	
	
	
	
	
	public static void KursiyerSil()
	{
	    try (Scanner scanner = new Scanner(System.in)) {
	        System.out.print("Silinecek kursiyer ID'si: ");
	        int silinecekKursiyerId = scanner.nextInt();

	        boolean kursiyerVarMi = kursiyerler.removeIf(kursiyer -> kursiyer.getKursiyerId() == silinecekKursiyerId);

	        if (kursiyerVarMi) {
	            System.out.println("Kursiyer silindi.");
	        } else {
	            System.out.println("Kursiyer bulunamadı.");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Geçersiz giriş. Lütfen bir sayı girin");
	    }
	}
	
	
	
	
	
	
	public static void KursiyerListele()
	{
		System.out.println("Tüm Kursiyerler");
        kursiyerler.forEach(kursiyer -> System.out.println(kursiyer.getKursiyerId() + " " + kursiyer.getKursiyerAdSoyad() + " " + kursiyer.getKursiyerYas()));
    }
	
	
	
	
	
	
	
	
	public static void KursiyerAyrintiliListele()
	{
		System.out.println("Tüm Kursiyerler ve Aldıkları Kurslar");
        kursiyerler.forEach(kursiyer -> {
            System.out.println(kursiyer.getKursiyerId() + " " + kursiyer.getKursiyerAdSoyad() + " " + kursiyer.getKursiyerYas());
            kursiyer.getAlinanKurslar().forEach(kurs -> System.out.println(kurs.getKursId() + " " + kurs.getKursAd()));
        });
	}
	
	
	
	
	
	
	
	public static void KursiyerinOdeyecegiTutarHesapla(int kursiyerId)
	{
	    	int kontrol = 0;
	    	for(Kursiyer kursiyer : kursiyerler)
	        {
	   		    if(kursiyer.getKursiyerId() == kursiyerId)
	    	    {
	   		    	 System.out.println(" Borcunuz : " + kursiyer.BorcHesapla());
	                 kontrol = 1;
	    	    }
	        }
	    	if(kontrol == 0)
	    	{
	    		System.out.println(" Bu ID'de bir kursiyer bulunmamaktadır");
	    		
	    	}

    }
	
	
	
	
	
	
	public static void kurs_oku() throws IOException {
			File file = new File("kurs.txt");
			if (file.exists() == false) return;
			BufferedReader bfRd = new BufferedReader(new FileReader("kurs.txt", Charset.forName("UTF-8")));
			String satir="";	
			try {
				while(bfRd.ready()) { 
					satir = bfRd.readLine();//SATİR SATİR OKUYOR 
					
					String[] id_isim=satir.split("\\+"); //AD VE ID AYIRMA İŞLEMİ
					kurslar.add(new Kurs(Integer.parseInt(id_isim[0]), id_isim[1])); //LİSTEYE EKLEME
					
				}
			}
			catch (Exception e) {
				System.out.println("Kurs: File IO Exception:"+e.getMessage());
			}
			bfRd.close();
		}
	
	
	
	
	
	
	
	public static void kursiyer_oku() throws IOException {
	    File file = new File("kursiyer.txt");
	    if (file.exists() == false) return;
	    BufferedReader bfRd = new BufferedReader(new FileReader("kursiyer.txt", Charset.forName("UTF-8")));
	    String satir="";
	    String[] kursiyer_;
	    String[] kurs_;
	    ArrayList<Kurs> gecici_kurs = new ArrayList<Kurs>();
	    try {
	        while(bfRd.ready()) {
	            satir = bfRd.readLine();
	            int krsyer_boyut = 0, kurs_boyut = 0;
	            if (satir.startsWith("*")) {
	                gecici_kurs = new ArrayList<>();
	                satir = satir.replace("*", "");
	                kursiyer_ = satir.split("\\+");
	                krsyer_boyut = kursiyer_.length;
	                kursiyerler.add(new Kursiyer(Integer.parseInt(kursiyer_[krsyer_boyut - 3]), 
	                              kursiyer_[krsyer_boyut - 2], Integer.parseInt(kursiyer_[krsyer_boyut - 1]), gecici_kurs));
	            } else {
	                if (satir.startsWith("%")) {
	                    satir = satir.replace("%", "");
	                    kurs_ = satir.split("\\+");
	                    kurs_boyut = kurs_.length;
	                    gecici_kurs.add(new Kurs(Integer.parseInt(kurs_[kurs_boyut - 2]), kurs_[kurs_boyut - 1]));
	                }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("File IO Exception:" + e.getMessage());
	    }       
	    bfRd.close();
	}
 
		
		
		
		
	
	
	
	
	
	
	public static void kursiyer_yazdir(ArrayList<Kursiyer> kursiyerler) throws IOException {
		       File cntrl = new File("kursiyer.txt");
		       if (cntrl.exists()) cntrl.delete();
        FileWriter fwWriter = new FileWriter("kursiyer.txt", Charset.forName("UTF-8"), false);
        for (Kursiyer kursiyer : kursiyerler) {
			  fwWriter.write(String.format("*%d+%s+%d\n", kursiyer.getKursiyerId(), kursiyer.getKursiyerAdSoyad(), kursiyer.getKursiyerYas()));
			for (Kurs kurs : kursiyer.alinanKurslar) {
			  fwWriter.write("%"+String.format("%d+%s\n",kurs.getKursId(), kurs.getKursAd()));
			}
		}
        
        fwWriter.close();
    }
	
	
	
	
	
	
	
	public static void kurs_yazdir(ArrayList<Kurs> kurslar) throws IOException {
		      File cntrl = new File("kurs.txt");
		      if(cntrl.exists()) cntrl.delete();
        FileWriter fwWriter = new FileWriter("kurs.txt", Charset.forName("UTF-8"), false);
        for (Kurs kurs : kurslar) {
        	  fwWriter.write(kurs.getKursId()+"+"+kurs.getKursAd()+"\n");
		}
        fwWriter.close();
    }
	
	
	
	
	
	
	
	
	
	
   public static void main(String[] args) throws IOException {
	    kursiyer_oku();//PROGRAM CALİSTİGİNDA DOSYADAKİ BİLGİLERİ LİSTEYE ALİYOR
	    kurs_oku();
        while (true){
	    	System.out.println("1 – Kurs Ekle\n"+
	    			"2 – Kurs Listele\n"+
	    			"3 – Kurs Ara\n"+
	    			"4 – Kurs Sil\n"+
	    			"5 – Kursiyer Ekle\n"+
	    			"6 – Kursiyer Ara\n"+
	    			"7 – Kursiyer Sil\n"+
	    			"8 – Kursiyerleri Listele\n"+
	    			"9 – Kursiyerleri Ayrıntılı Listele\n"+
	    			"10 – Kursiyerin Ödeyeceği Tutarı Hesapla\n"+
	    			"11 – Çıkış");
	    	System.out.println("SECİMİNİZ : ");
	        int secim = input.nextInt();//burada bir hata alıyorum ama hatayı çözemedim.
			
	    	 switch(secim){
	    	 case 1:
	    		 KursEkle();
	    		 break;
	    	 case 2:
	    		 KursListele();
	    		 break;
	    	 case 3:
	    		 KursAra();
	    		 break;
	    	 case 4:
	    		 KursSil();
	    		 break;
	    	 case 5:
	    		 KursiyerEkle(kursiyerler);
	    		 break;
	    	 case 6:
	    		 KursiyerAra();
	    		 break;
	    	 case 7:
	    		 KursiyerSil();
	    		 break;
	    	 case 8:
	    		 KursiyerListele();
	    		 break;
	    	 case 9:	 
	    		 KursiyerAyrintiliListele();
	    		 break;
	    	 case 10:
	    		 System.out.print("Ücreti hesaplanacak kursiyer ID'si: ");
	    	     
				 int kursiyerId = input.nextInt();

	    		 KursiyerinOdeyecegiTutarHesapla(kursiyerId);
				 break;
	    	 case 11:
	    		 kurs_yazdir(kurslar);
	    
	    		 System.out.println("Kurs verileri dosyaya (kurs.txt) kaydediliyor...");
	    		 
	    		 kursiyer_yazdir(kursiyerler);
	    		 
	    		 System.out.println("Kursiyer verileri dosyaya (kursiyer.txt) kaydediliyor...");
	    		 
	    		 System.out.println("PROGRAMDAN CIKIS YAPILIYOR...");
	    		 
	    		 System.exit(0);
	    		 break;
	    	
	    	 }
	    }
	}
 }

