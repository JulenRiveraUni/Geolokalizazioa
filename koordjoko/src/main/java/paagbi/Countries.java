package paagbi;

public class Countries {

    private String izena;
    private double latitudeMin;
    private double latitudeMax;
    private double longitudeMin;
    private double longitudeMax;

    public Countries(String izena, double latitudeMin, double latitudeMax,double longitudeMin, double longitudeMax) {
        this.izena = izena;
        this.latitudeMin = latitudeMin;
        this.latitudeMax = latitudeMax;
        this.longitudeMin = longitudeMin;
        this.longitudeMax = longitudeMax;
    }

    public String getIzena() {
        return izena;
    }

    public boolean contains(double latitude, double longitude) {
        return latitude >= latitudeMin
                && latitude <= latitudeMax
                && longitude >= longitudeMin
                && longitude <= longitudeMax;
    }

    public double getLatitudeMin() {
        return latitudeMin;
    }
//Te voy a matah
    public double getLatitudeMax() {
        return latitudeMax;
    }

    public double getLongitudeMin() {
        return longitudeMin;
    }

    public double getLongitudeMax() {
        return longitudeMax;
    }
}