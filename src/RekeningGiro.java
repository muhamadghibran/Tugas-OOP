public class RekeningGiro extends Rekening {
  private double biayaAdministrasi;

  public RekeningGiro(String namaPemilik, String nomorRekening, double saldo, double biayaAdministrasi) {
    super(namaPemilik, nomorRekening, saldo);
    this.biayaAdministrasi = biayaAdministrasi;
  }

  @Override
  public void tarik(double jumlah) {
    double totalTarik = jumlah + biayaAdministrasi;
    if (totalTarik > saldo) {
      System.out.println(">> Saldo tidak mencukupi untuk penarikan dan biaya administrasi.");
    } else if (jumlah <= 0) {
      System.out.println(">> Jumlah penarikan tidak valid.");
    } else {
      saldo -= totalTarik;
      System.out.println(">> Penarikan berhasil: -" + df.format(jumlah)
          + " (biaya administrasi: " + df.format(biayaAdministrasi) + ")");
    }
  }

  @Override
  public void tampilkanInfo() {
    System.out.println("=========== Rekening Giro ===========");
    super.tampilkanInfo();
    System.out.printf("%-30s: %s%n", "Biaya Administrasi per Transaksi", df.format(biayaAdministrasi));
    System.out.println("=====================================");
  }
}
