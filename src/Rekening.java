public class Rekening {
    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Hanya getter, tidak ada setSaldo, jadi saldo read-only
    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah > 0) {
            saldo = saldo + jumlah;
            return true;
        }
        return false;
    }

    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo = saldo - jumlah;
            return true;
        }
        return false;
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, formatRupiah(saldo));
    }

    // Contoh: 120000 -> Rp120.000 (titik disisipkan tiap tiga digit dari belakang)
    private String formatRupiah(int uang) {
        String angka = String.valueOf(uang);
        String hasil = "";
        for (int i = 0; i < angka.length(); i++) {
            int sisa = angka.length() - i;
            if (i > 0 && sisa % 3 == 0) {
                hasil += ".";
            }
            hasil += angka.charAt(i);
        }
        return "Rp" + hasil;
    }
}