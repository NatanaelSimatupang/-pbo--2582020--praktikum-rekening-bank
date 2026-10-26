import java.util.Scanner;

public class BankMini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rekening rekening = new Rekening("001", "Ani", 100000);

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening 001 a.n. Ani");

        boolean jalan = true;
        while (jalan) {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Jumlah: ");
                    boolean berhasilSetor = rekening.setor(input.nextInt());
                    System.out.println(berhasilSetor ? "  Berhasil" : "  Ditolak");
                    break;
                case 2:
                    System.out.print("Jumlah: ");
                    boolean berhasilTarik = rekening.tarik(input.nextInt());
                    System.out.println(berhasilTarik ? "  Berhasil" : "  Ditolak");
                    break;
                case 3:
                    rekening.cetakInfo();
                    break;
                case 0:
                    jalan = false;
                    break;
                default:
                    System.out.println("Menu tidak dikenal");
            }
        }

        System.out.println();
        System.out.println("=========== SALDO AKHIR ===========");
        rekening.cetakInfo();
    }
}