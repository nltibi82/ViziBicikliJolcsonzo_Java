package vizibicikli_kolcsonzo_java;


public class Loan {
    private String name;
    private String identify;
    private int sHour;
    private int sMin;
    private int eHour;
    private int eMin;
    public Loan(){};
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public int getsHour() {
        return sHour;
    }

    public void setsHour(int sHour) {
        this.sHour = sHour;
    }

    public int getsMin() {
        return sMin;
    }

    public void setsMin(int sMin) {
        this.sMin = sMin;
    }

    public int geteHour() {
        return eHour;
    }

    public void seteHour(int eHour) {
        this.eHour = eHour;
    }

    public int geteMin() {
        return eMin;
    }

    public void seteMin(int eMin) {
        this.eMin = eMin;
    }
}
