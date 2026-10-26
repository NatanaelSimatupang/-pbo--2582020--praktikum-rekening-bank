public class Rekening {
    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Saldo read-only: hanya ada getter, tidak ada setSaldo
    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public void cetakInfo() {
        System.out.println(String.format("%s | %-6s | %12s",
                nomor, pemilik, formatRupiah(saldo)));
    }

    // Contoh: 120000 -> Rp120.000
    private String formatRupiah(int uang) {
        String angka = Integer.toString(uang);
        StringBuilder hasil = new StringBuilder();
        int hitung = 0;
        for (int i = angka.length() - 1; i >= 0; i--) {
            hasil.insert(0, angka.charAt(i));
            hitung++;
            if (hitung % 3 == 0 && i > 0 && angka.charAt(i - 1) != '-') {
                hasil.insert(0, '.');
            }
        }
        return "Rp" + hasil;
    }
}
