public class SistemPerbankan {
  public static void main(String[] args) {

    System.out.println("===== Rekening Dasar =====");
    Rekening rekeningDasar = new Rekening("Andi", "111222333", 1000000);
    rekeningDasar.tampilkanInfo();
    rekeningDasar.setor(500000);
    rekeningDasar.tarik(300000);
    System.out.println();

    System.out.println("===== Rekening Tabungan =====");
    RekeningTabungan tabungan = new RekeningTabungan("Budi", "444555666", 2000000, 5.0);
    tabungan.tampilkanInfo();
    tabungan.setor(500000);
    tabungan.setor(1000000, 50000);
    tabungan.tarik(700000);
    System.out.println();

    System.out.println("===== Rekening Giro =====");
    RekeningGiro giro = new RekeningGiro("Citra", "777888999", 3000000, 5000);
    giro.tampilkanInfo();
    giro.setor(1000000);
    giro.tarik(800000);
  }
}
