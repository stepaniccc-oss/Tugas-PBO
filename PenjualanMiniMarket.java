
import java.util.Scanner;

public class PenjualanMiniMarket {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] namaProduk = new String[10];
        double[] harga = new double[10];
        int[] jumlahTerjual = new int[10];
        double[] totalPenjualan = new double[10];

        double totalPendapatan = 0;
        
        System.out.println("=== INPUT DATA PENJUALAN MINIMARKET ===");

        for (int i = 0; i < 10; i++) {

            System.out.println("\nProduk ke-" + (i + 1));

            System.out.print("Nama produk: ");
            namaProduk[i] = input.nextLine();

            do {
                System.out.print("Harga satuan: ");

                while (!input.hasNextDouble()) {
                    System.out.println("Harga harus berupa angka!");
                    input.next();
                    System.out.print("Harga satuan: ");
                }

                harga[i] = input.nextDouble();

                if (harga[i] < 0) {
                    System.out.println("Harga tidak boleh negatif!");
                }

            } while (harga[i] < 0);

            do {
                System.out.print("Jumlah terjual: ");

                while (!input.hasNextInt()) {
                    System.out.println(
                            "Jumlah harus berupa bilangan bulat!");
                    input.next();
                    System.out.print("Jumlah terjual: ");
                }

                jumlahTerjual[i] = input.nextInt();

                if (jumlahTerjual[i] < 0) {
                    System.out.println(
                            "Jumlah terjual tidak boleh negatif!");
                }

            } while (jumlahTerjual[i] < 0);

            input.nextLine();

            totalPenjualan[i] =
                    harga[i] * jumlahTerjual[i];

            totalPendapatan =
                    totalPendapatan + totalPenjualan[i];
        }

        int indeksTertinggi = 0;

        for (int i = 1; i < 10; i++) {

            if (totalPenjualan[i]
                    > totalPenjualan[indeksTertinggi]) {

                indeksTertinggi = i;
            }
        }

        System.out.println("\n=== TOTAL PENJUALAN SETIAP PRODUK ===");

        for (int i = 0; i < 10; i++) {

            System.out.println(
                    namaProduk[i] + " = Rp "
                    + totalPenjualan[i]);
        }

        System.out.println("\n=== TOTAL PENDAPATAN MINIMARKET ===");

        System.out.println("Total pendapatan: Rp "
                + totalPendapatan);

        System.out.println("\n=== PRODUK PENJUALAN TERTINGGI ===");

        System.out.println("Nama produk: "
                + namaProduk[indeksTertinggi]);

        System.out.println("Harga satuan: Rp "
                + harga[indeksTertinggi]);

        System.out.println("Jumlah terjual: "
                + jumlahTerjual[indeksTertinggi]);

        System.out.println("Total penjualan: Rp "
                + totalPenjualan[indeksTertinggi]);

        System.out.println("\n=== PRODUK BELUM TERJUAL ===");

        boolean adaProdukBelumTerjual = false;

        for (int i = 0; i < 10; i++) {

            if (jumlahTerjual[i] == 0) {

                System.out.println(namaProduk[i]);

                adaProdukBelumTerjual = true;
            }
        }

        if (adaProdukBelumTerjual == false) {

            System.out.println("Semua produk telah terjual.");
        }

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9 - i; j++) {

                if (totalPenjualan[j]
                        < totalPenjualan[j + 1]) {

                    double sementaraTotal =
                            totalPenjualan[j];

                    totalPenjualan[j] =
                            totalPenjualan[j + 1];

                    totalPenjualan[j + 1] =
                            sementaraTotal;

                    String sementaraNama =
                            namaProduk[j];

                    namaProduk[j] =
                            namaProduk[j + 1];

                    namaProduk[j + 1] =
                            sementaraNama;

                    double sementaraHarga =
                            harga[j];

                    harga[j] =
                            harga[j + 1];

                    harga[j + 1] =
                            sementaraHarga;

                    int sementaraJumlah =
                            jumlahTerjual[j];

                    jumlahTerjual[j] =
                            jumlahTerjual[j + 1];

                    jumlahTerjual[j + 1] =
                            sementaraJumlah;
                }
            }
        }

        System.out.println("\n=== SORTING PRODUK ===");

        System.out.println(
                "Produk berdasarkan total penjualan "
                + "tertinggi ke terendah:");

        System.out.printf("%-5s %-20s %-15s %-15s %-20s%n",
                "No", "Nama Produk", "Harga", "Terjual",
                "Total Penjualan");

        for (int i = 0; i < 10; i++) {

            System.out.printf("%-5d %-20s %-15.2f %-15d %-20.2f%n",
                    (i + 1),
                    namaProduk[i],
                    harga[i],
                    jumlahTerjual[i],
                    totalPenjualan[i]);
        }

        input.close();
    }
}
