public class RekeningTabungan extends Rekening {
  private double bungaTahunan; // persentase bunga per tahun

  public RekeningTabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTahunan) {
    super(namaPemilik, nomorRekening, saldo);
    this.bungaTahunan = bungaTahunan;
  }

  public double hitungBungaBulanan() {
    return saldo * (bungaTahunan / 100) / 12;
  }

  @Override
  public void tampilkanInfo() {
    System.out.println("========== Rekening Tabungan ==========");
    super.tampilkanInfo();
    System.out.printf("%-20s: %.2f%%%n", "Bunga Tahunan", bungaTahunan);
    System.out.printf("%-20s: %s%n", "Bunga Bulanan", df.format(hitungBungaBulanan()));
    System.out.println("=========================================");
  }

  public void setor(double jumlah, double bonus) {
    if (jumlah > 0) {
      saldo += jumlah + bonus;
      System.out.println(">> Setor berhasil: +" + df.format(jumlah) + " dengan bonus: +" + df.format(bonus));
    } else {
      System.out.println(">> Jumlah setor tidak valid.");
    }
  }
}
