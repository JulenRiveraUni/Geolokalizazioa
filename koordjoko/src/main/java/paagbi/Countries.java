package paagbi;


public class Countries {

    private String name;

    private double latitudeMin;
    private double latitudeMax;
    private double longitudeMin;
    private double longitudeMax;

    public Countries(String name, double latitudeMin, double latitudeMax, double longitudeMin, double longitudeMax) {

        this.name = name;
        this.latitudeMin = latitudeMin;
        this.latitudeMax = latitudeMax;
        this.longitudeMin = longitudeMin;
        this.longitudeMax = longitudeMax;
    }

    public String getName() {
        return name;
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
