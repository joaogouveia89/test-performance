package joaogouveia89.github.io.testedeperformance.model;

public class Result {
    private int cpus;
    private double frequency;
    private double ram;
    private String brand;
    private int algorithm;
    private int elements;
    private long timeLapsed;
    private int temperatureDifference;
    private String imei;

    public Result() {
    }

    public Result(int cpus, double frequency, double ram, String brand, int algorithm, int elements, long timeLapsed, int temperatureDifference, String imei) {
        this.cpus = cpus;
        this.frequency = frequency;
        this.ram = ram;
        this.brand = brand;
        this.algorithm = algorithm;
        this.elements = elements;
        this.timeLapsed = timeLapsed;
        this.temperatureDifference = temperatureDifference;
        this.imei = imei;
    }

    public int getCpus() {
        return cpus;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(int algorithm) {
        this.algorithm = algorithm;
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    public long getTimeLapsed() {
        return timeLapsed;
    }

    public void setTimeLapsed(long timeLapsed) {
        this.timeLapsed = timeLapsed;
    }

    public int getTemperatureDifference() {
        return temperatureDifference;
    }

    public void setTemperatureDifference(int temperatureDifference) {
        this.temperatureDifference = temperatureDifference;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "Result{" +
                "cpus=" + cpus +
                ", frequency=" + frequency +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                ", algorithm=" + algorithm +
                ", elements=" + elements +
                ", timeLapsed=" + timeLapsed +
                ", temperatureDifference=" + temperatureDifference +
                ", imei='" + imei + '\'' +
                '}';
    }
}
