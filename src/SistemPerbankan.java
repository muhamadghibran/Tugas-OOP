import java.util.ArrayList;

public class SistemPerbankan {
  public static void main(String[] args) {
    ArrayList<Rekening> nasabahList = new ArrayList<>();

    Tabungan tabungan = new Tabungan("Budi", "T001", 2000000, 5.0);
    Giro giro = new Giro("Citra", "G001", 3000000, 1000000);
    Deposito deposito = new Deposito("Dewi", "D001", 5000000, 12, 7.0);

    nasabahList.add(tabungan);
    nasabahList.add(giro);
    nasabahList.add(deposito);

    tabungan.setor(500000);
    tabungan.setor(1000000, true);
    tabungan.tarik(700000);
    System.out.printf("Bunga untuk 6 bulan: %s%n", Rekening.df.format(tabungan.hitungBunga(6)));

    giro.setor(1000000);
    giro.tarik(4000000);

    System.out.println("Bunga Deposito: " + Rekening.df.format(deposito.hitungBunga()));
    deposito.tarik(1000000);

    System.out.println("\n========== Daftar Semua Rekening ==========");
    for (Rekening r : nasabahList) {
      r.tampilkanInfo();
    }

    Rekening tertinggi = nasabahList.get(0);
    Rekening terendah = nasabahList.get(0);
    for (Rekening r : nasabahList) {
      if (r.getSaldo() > tertinggi.getSaldo()) {
        tertinggi = r;
      }
      if (r.getSaldo() < terendah.getSaldo()) {
        terendah = r;
      }
    }
    System.out.println("\nRekening dengan saldo tertinggi:");
    tertinggi.tampilkanInfo();

    System.out.println("\nRekening dengan saldo terendah:");
    terendah.tampilkanInfo();

    System.out.println("\n--- Simulasi Transfer ---");
    transfer(tabungan, giro, 300000);
    System.out.println("Setelah transfer:");
    tabungan.tampilkanInfo();
    giro.tampilkanInfo();
  }

  public static void transfer(Rekening from, Rekening to, double jumlah) {
    System.out.println("Melakukan transfer sebesar " + Rekening.df.format(jumlah)
        + " dari " + from.namaPemilik + " ke " + to.namaPemilik);
    if (from instanceof Giro && to instanceof Tabungan) {
      from.tarik(jumlah);
      to.setor(jumlah - 5000, false);
      System.out.println(">> Transfer dengan biaya administrasi Rp5.000");
    } else {

      from.tarik(jumlah);
      to.setor(jumlah, false);
    }
  }
}
