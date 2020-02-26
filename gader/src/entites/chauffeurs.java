/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Lenovo
 */
public class chauffeurs {
    private int cinc;
    private String nomc;
    private String prenomc;
    
    private int num_telc;

    public chauffeurs(int cinc, String nomc, String prenomc, int num_telc) {
        this.cinc = cinc;
        this.nomc = nomc;
        this.prenomc = prenomc;
        this.num_telc = num_telc;
    }
    
    
     public chauffeurs(int cinc) {
        this.cinc = cinc;
      
    }
    
    
    
    public chauffeurs() {
        this.cinc = 0;
        this.nomc = "";
        this.prenomc = "";
        this.num_telc = 0;
    }

    public int getCinc() {
        return cinc;
    }

    public String getNomc() {
        return nomc;
    }

    public String getPrenomc() {
        return prenomc;
    }

    public int getNum_telc() {
        return num_telc;
    }

    public void setCinc(int cinc) {
        this.cinc = cinc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public void setPrenomc(String prenomc) {
        this.prenomc = prenomc;
    }

    public void setNum_telc(int num_telc) {
        this.num_telc = num_telc;
    }

    
 
    
    
    
    

}


    
    



