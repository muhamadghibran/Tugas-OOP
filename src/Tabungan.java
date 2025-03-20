public class Tabungan extends Rekening {
  private double bungaTahunan;

  public Tabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTahunan) {
    super(namaPemilik, nomorRekening, saldo);
    this.bungaTahunan = bungaTahunan;
  }

  public double hitungBunga(int bulan) {
    return saldo * (bungaTahunan / 100) * (bulan / 12.0);
  }

  @Override
  public void tampilkanInfo() {
    System.out.println("========== Rekening Tabungan ==========");
    super.tampilkanInfo();
    System.out.printf("%-20s: %.2f%%%n", "Bunga Tahunan", bungaTahunan);
    System.out.println("=========================================");
  }
}
