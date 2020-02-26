/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;



/**
 *
 * @author Lenovo
 */
public class ChauffeurVehicule {
    
    private int cinc;
    private String nomc;
    private int matricule;
    private int capacite;
    
    
    
    
    
    

    public int getCinc() {
        return cinc;
    }

    public void setCinc(int cinc) {
        this.cinc = cinc;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public ChauffeurVehicule(int cinc, String nomc, int matricule, int capacite) {
        this.cinc = cinc;
        this.nomc = nomc;
        this.matricule = matricule;
        this.capacite = capacite;
    }
    
    
    
     public ChauffeurVehicule() {
       
    }
    
}
