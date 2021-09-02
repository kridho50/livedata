package com.example.livedata.models;

import com.google.gson.annotations.SerializedName;

public class Office {

    /**
     * id : 1
     * Nama_Makanan : sayur sop
     * Energi : 72.0
     * Karbohidrat : 1.00
     * Protein : 1.30
     * Lemak : 2.00
     * Berat_Makanan : 100
     * Harga : 5000
     * type : s
     */

    @SerializedName("id")
    private String id;
    @SerializedName("Nama_Makanan")
    private String NamaMakanan;
    @SerializedName("Energi")
    private String Energi;
    @SerializedName("Karbohidrat")
    private String Karbohidrat;
    @SerializedName("Protein")
    private String Protein;
    @SerializedName("Lemak")
    private String Lemak;
    @SerializedName("Berat_Makanan")
    private String BeratMakanan;
    @SerializedName("Harga")
    private String Harga;
    @SerializedName("type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMakanan() {
        return NamaMakanan;
    }

    public void setNamaMakanan(String NamaMakanan) {
        this.NamaMakanan = NamaMakanan;
    }

    public String getEnergi() {
        return Energi;
    }

    public void setEnergi(String Energi) {
        this.Energi = Energi;
    }

    public String getKarbohidrat() {
        return Karbohidrat;
    }

    public void setKarbohidrat(String Karbohidrat) {
        this.Karbohidrat = Karbohidrat;
    }

    public String getProtein() {
        return Protein;
    }

    public void setProtein(String Protein) {
        this.Protein = Protein;
    }

    public String getLemak() {
        return Lemak;
    }

    public void setLemak(String Lemak) {
        this.Lemak = Lemak;
    }

    public String getBeratMakanan() {
        return BeratMakanan;
    }

    public void setBeratMakanan(String BeratMakanan) {
        this.BeratMakanan = BeratMakanan;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
