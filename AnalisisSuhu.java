
import java.util.Scanner;

public class AnalisisSuhu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        String[] hari = {
            "Senin", "Selasa", "Rabu", "Kamis",
            "Jumat", "Sabtu", "Minggu"
        };
        
        double[] suhu = new double[7];

        double total = 0;
        double rataRata;

        System.out.println("=== INPUT SUHU 7 HARI ===");

        for (int i = 0; i < 7; i++) {
            System.out.print("Masukkan suhu " + hari[i] + ": ");
            suhu[i] = input.nextDouble();
            total = total + suhu[i];
        }

        rataRata = total / 7;

        double tertinggi = suhu[0];
        double terendah = suhu[0];

        int indeksTertinggi = 0;
        int indeksTerendah = 0;

        for (int i = 1; i < 7; i++) {

            if (suhu[i] > tertinggi) {
                tertinggi = suhu[i];
                indeksTertinggi = i;
            }

            if (suhu[i] < terendah) {
                terendah = suhu[i];
                indeksTerendah = i;
            }
        }

        System.out.println("\n=== HASIL ANALISIS SUHU ===");

        System.out.println("Rata-rata suhu: " + rataRata + " C");

        System.out.println("Suhu tertinggi: " + tertinggi
                + " C (" + hari[indeksTertinggi] + ")");

        System.out.println("Suhu terendah: " + terendah
                + " C (" + hari[indeksTerendah] + ")");

        int jumlahDiAtas = 0;

        System.out.println("\nHari dengan suhu di atas rata-rata:");

        for (int i = 0; i < 7; i++) {

            if (suhu[i] > rataRata) {
                System.out.println(hari[i] + ": " + suhu[i] + " C");
                jumlahDiAtas++;
            }
        }

        System.out.println("Jumlah hari di atas rata-rata: "
                + jumlahDiAtas);

        double perubahanTerbesar = 0;
        int indeksPerubahan = 1;

        for (int i = 1; i < 7; i++) {

            double perubahan = suhu[i] - suhu[i - 1];

            if (perubahan < 0) {
                perubahan = perubahan * -1;
            }

            if (perubahan > perubahanTerbesar) {
                perubahanTerbesar = perubahan;
                indeksPerubahan = i;
            }
        }

        System.out.println("\n=== PERUBAHAN SUHU TERBESAR ===");

        System.out.println("Hari sebelumnya: "
                + hari[indeksPerubahan - 1]);

        System.out.println("Suhu sebelumnya: "
                + suhu[indeksPerubahan - 1] + " C");

        System.out.println("Hari perubahan: "
                + hari[indeksPerubahan]);

        System.out.println("Suhu saat itu: "
                + suhu[indeksPerubahan] + " C");

        System.out.println("Besar perubahan: "
                + perubahanTerbesar + " C");

        double[] suhuUrut = new double[7];

        for (int i = 0; i < 7; i++) {
            suhuUrut[i] = suhu[i];
        }

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6 - i; j++) {

                if (suhuUrut[j] > suhuUrut[j + 1]) {

                    double sementara = suhuUrut[j];

                    suhuUrut[j] = suhuUrut[j + 1];

                    suhuUrut[j + 1] = sementara;
                }
            }
        }

        System.out.println("\n=== SORTING SUHU ===");

        System.out.println("Suhu dari terendah ke tertinggi:");

        for (int i = 0; i < 7; i++) {
            System.out.println(suhuUrut[i] + " C");
        }

        input.close();
    }
}
