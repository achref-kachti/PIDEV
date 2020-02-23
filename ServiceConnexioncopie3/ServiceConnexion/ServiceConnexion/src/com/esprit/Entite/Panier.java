/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;
import java.util.Objects;
/**
 *
 * @author sarah
 */
public class Panier {
    private int idach;  //id achat
    private int refmat; //mel table materiel
    private int iduser;  // mel table user
    private int qtach;
    
     
     

    public Panier() {
    }
    
    public Panier(int refmat, int iduser) {
       
        this.refmat = refmat;
        this.iduser = iduser;
       
        
    }
     public Panier(int idach,int refmat, int iduser) {
        this.idach=idach;
        this.refmat = refmat;
        this.iduser = iduser;
       
        
    }
    
    
    public Panier(int idach,int refmat, int iduser, int qtach) {
        this.idach = idach;
        this.refmat = refmat;
        this.iduser = iduser;
        this.qtach = qtach;
        
    }

    @Override
    public String toString() {
        return "Panier{" + "id de l'achat=" + idach + ", reference du materiel =" + refmat + ", id du user=" + iduser +", quantité achetee="+qtach+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Panier other = (Panier) obj;
        if (this.idach != other.idach) {
            return false;
        }
        if (!Objects.equals(this.idach, other.idach)) {
            return false;
        }
        return true;
    }

    public int getIdach() {
        return idach;
    }

    public void setIdach(int idach) {
        this.idach = idach;
    }

    public int getRefmat() {
        return refmat;
    }

    public void setRefmat(int refmat) {
        this.refmat = refmat;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    
    public int getQtach() {
        return qtach;
    }

    public void setQtach(int qtach) {
        this.qtach = qtach;
    }

   
    
   
    
    
}
