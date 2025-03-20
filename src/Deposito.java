public class Deposito extends Rekening {
  private int jangkaWaktuBulan;
  private double sukuBunga;

  public Deposito(String namaPemilik, String nomorRekening, double saldo, int jangkaWaktuBulan, double sukuBunga) {
    super(namaPemilik, nomorRekening, saldo);
    this.jangkaWaktuBulan = jangkaWaktuBulan;
    this.sukuBunga = sukuBunga;
  }

  // Menghitung bunga deposito
  public double hitungBunga() {
    return saldo * (sukuBunga / 100) * (jangkaWaktuBulan / 12.0);
  }

  @Override
  public void tarik(double jumlah) {
    if (jumlah <= 0) {
      System.out.println(">> Jumlah tarik tidak valid.");
    } else if (jumlah > saldo) {
      System.out.println(">> Saldo tidak mencukupi.");
    } else {
      // Penarikan sebelum jatuh tempo dikenakan denda 10% dari saldo
      double denda = saldo * 0.10;
      saldo -= (jumlah + denda);
      System.out.println(">> Penarikan berhasil: -" + df.format(jumlah)
          + " dengan denda: " + df.format(denda));
    }
  }

  @Override
  public void tampilkanInfo() {
    System.out.println("=========== Rekening Deposito ===========");
    super.tampilkanInfo();
    System.out.printf("%-25s: %d bulan%n", "Jangka Waktu", jangkaWaktuBulan);
    System.out.printf("%-25s: %.2f%%%n", "Suku Bunga", sukuBunga);
    System.out.printf("%-25s: %s%n", "Bunga Deposito", df.format(hitungBunga()));
    System.out.println("=========================================");
  }
}
