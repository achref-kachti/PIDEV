package Restaurant.Entity;

public class Restaurant {
    private int id;
    private String nom ;
    private  String lieu;
    private float rate ;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", lieu='" + lieu + '\'' +
                ", rate=" + rate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Restaurant(String nom, String lieu, float rate) {
        this.nom = nom;
        this.lieu = lieu;
        this.rate = rate;
    }
}
