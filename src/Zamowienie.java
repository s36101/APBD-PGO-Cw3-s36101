import java.util.ArrayList;

public class Zamowienie {
    private int numerZamowienia;
    private KlientKawiarni klient;
    private ArrayList<ProduktMenu> produkty;
    private boolean oplacone;
    private static int kolejnyNumer = 1;

    public Zamowienie(KlientKawiarni klient) {
        this.numerZamowienia = pobierzKolejnyNumer();
        this.klient = klient;
        this.produkty = new ArrayList<>();
        this.oplacone = false;
    }

    public static int pobierzKolejnyNumer() { return kolejnyNumer++; }

    public void dodajProdukt(ProduktMenu produkt) { produkty.add(produkt); }

    public double policzWartosc() {
        double suma = 0;
        for (ProduktMenu p : produkty) { suma += p.getCena(); }
        return suma;
    }

    public int policzLiczbeProduktow() { return produkty.size(); }

    public void oznaczJakoOplacone() { this.oplacone = true; }

    @Override
    public String toString() {
        String status = oplacone ? "Opłacone" : "Nieopłacone";
        return "Zamówienie nr " + numerZamowienia + " | Status: " + status + "\n" +
                "Klient: " + klient.getPelneDane() + "\n" +
                "Lista produktów: " + produkty.toString();
    }
}