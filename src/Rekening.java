import java.text.DecimalFormat;

public class Rekening {
    protected String namaPemilik;
    protected String nomorRekening;
    protected double saldo;

    protected static final DecimalFormat df = new DecimalFormat("#,##0.##");

    public Rekening(String namaPemilik, String nomorRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    public Rekening(String namaPemilik, String nomorRekening) {
        this(namaPemilik, nomorRekening, 0);
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(">> Setor berhasil: +" + df.format(jumlah));
        } else {
            System.out.println(">> Jumlah setor tidak valid.");
        }
    }

    public void tarik(double jumlah) {
        if (jumlah > saldo) {
            System.out.println(">> Saldo tidak mencukupi.");
        } else if (jumlah <= 0) {
            System.out.println(">> Jumlah tarik tidak valid.");
        } else {
            saldo -= jumlah;
            System.out.println(">> Penarikan berhasil: -" + df.format(jumlah));
        }
    }

    public void tampilkanInfo() {
        System.out.println("-----------------------------------");
        System.out.printf("%-20s: %s%n", "Nama Pemilik", namaPemilik);
        System.out.printf("%-20s: %s%n", "Nomor Rekening", nomorRekening);
        System.out.printf("%-20s: %s%n", "Saldo", df.format(saldo));
        System.out.println("-----------------------------------");
    }

    public double getSaldo() {
        return saldo;
    }
}
