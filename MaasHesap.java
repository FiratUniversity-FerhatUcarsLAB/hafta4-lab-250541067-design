/*
 * Ad Soyad: Avşin Pelin Bilgiç
 * Ogrenci No: 250541067
 * Tarih: 28.10.2025
 * Aciklama: Maaş Hesap Sistemi
 Bu sistem, çalışanın brüt maaşı ve mesai bilgilerini alıp net maaşını, kesintilerini ve saatlik/günlük kazancını hesaplayarak ekrana yazdırır.
 */

import java.util.Scanner;

public class MaasHesap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== MAAS HESAPLAMA SISTEMI ===");
        System.out.print("Calisan adi soyadi: ");
        String adSoyad = input.nextLine().trim();

        System.out.print("Aylik brut maas (TL): ");
        double brutMaas = input.nextDouble();

        System.out.print("Haftalik calisma saati (int): ");
        int haftalikSaat = input.nextInt();

        System.out.print("Mesai saati sayisi (int): ");
        int mesaiSaat = input.nextInt();

        double mesaiUcreti = (brutMaas / 160.0) * mesaiSaat * 1.5;
        double toplamGelir = brutMaas + mesaiUcreti;

        double sgk = toplamGelir * 0.14;
        double gelirVergisi = toplamGelir * 0.15;
        double damgaVergisi = toplamGelir * 0.00759;
        double toplamKesinti = sgk + gelirVergisi + damgaVergisi;

        double netMaas = toplamGelir - toplamKesinti;

        double kesintiOrani = (toplamKesinti / toplamGelir) * 100.0;
        double saatlikNetKazanc = netMaas / 176.0;
        double gunlukNetKazanc = netMaas / 22.0;

        System.out.println("\n=== MAAS BORDROSU ===");
        System.out.println("Calisan: " + adSoyad);
        System.out.println("------------------------------");

        System.out.println(">>> GELIRLER <<<");
        System.out.printf("%-20s: %10.2f TL%n", "Brut Maas", brutMaas);
        System.out.printf("%-20s: %10.2f TL%n", "Mesai Ucreti", mesaiUcreti);
        System.out.printf("%-20s: %10.2f TL%n", "Toplam Gelir", toplamGelir);

        System.out.println("\n>>> KESINTILER <<<");
        System.out.printf("%-20s: %10.2f TL%n", "SGK (%14)", sgk);
        System.out.printf("%-20s: %10.2f TL%n", "Gelir Vergisi (%15)", gelirVergisi);
        System.out.printf("%-20s: %10.2f TL%n", "Damga Vergisi", damgaVergisi);
        System.out.printf("%-20s: %10.2f TL%n", "Toplam Kesinti", toplamKesinti);

        System.out.println("\n>>> NET MAAS <<<");
        System.out.printf("%-20s: %10.2f TL%n", "Net Maas", netMaas);

        System.out.println("\n>>> ISTATISTIKLER <<<");
        System.out.printf("%-20s: %10.2f %% %n", "Kesinti Orani", kesintiOrani);
        System.out.printf("%-20s: %10.2f TL/saat%n", "Saatlik Net Kazanc", saatlikNetKazanc);
        System.out.printf("%-20s: %10.2f TL/gun%n", "Gunluk Net Kazanc", gunlukNetKazanc);

        input.close();
    }
}

