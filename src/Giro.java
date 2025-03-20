public class Giro extends Rekening {
  private double limitPenarikan;

  public Giro(String namaPemilik, String nomorRekening, double saldo, double limitPenarikan) {
    super(namaPemilik, nomorRekening, saldo);
    this.limitPenarikan = limitPenarikan;
  }

  @Override
  public void tarik(double jumlah) {
    if (jumlah <= 0) {
      System.out.println(">> Jumlah tarik tidak valid.");
    } else {
      double kekurangan = jumlah - saldo;
      if (kekurangan > 0) {
        if (kekurangan <= limitPenarikan) {
          saldo = saldo - jumlah;
          System.out.println(">> Penarikan (overdraft) berhasil: -" + df.format(jumlah));
        } else {
          System.out.println(">> Penarikan melebihi limit giro.");
        }
      } else {
        saldo -= jumlah;
        System.out.println(">> Penarikan berhasil: -" + df.format(jumlah));
      }
    }
  }

  @Override
  public void tampilkanInfo() {
    System.out.println("=========== Rekening Giro ===========");
    super.tampilkanInfo();
    System.out.printf("%-30s: %s%n", "Limit Penarikan", df.format(limitPenarikan));
    System.out.println("=====================================");
  }
}
