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
    private int idach;
    private int refmat; //mel table stock
    private int iduser;  // mel table user
    private String nomach; //mel table stock
    private int prixach;
    private int qtach;
    private String typeach; // vente ou location mel table stock
     
     

    public Panier() {
    }
    public Panier(String nomach, int prixach) {
        this.nomach = nomach;
        this.prixach = prixach;
    }
    public Panier(int idach,int refmat, int iduser, String nomach, int prixach, int qtach,String typeach) {
        this.idach = idach;
        this.refmat = refmat;
        this.iduser = iduser;
        this.nomach = nomach;
        this.prixach= prixach;
        this.qtach = qtach;
        this.typeach= typeach;
    }

    @Override
    public String toString() {
        return "Panier{" + "id de l'achat=" + idach + ", reference =" + refmat + ", id du user=" + iduser +", nom de l'achat="+nomach+", prix="+prixach+", quantité achetee="+qtach+", type="+typeach+ '}';
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
        if (!Objects.equals(this.nomach, other.nomach)) {
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

    public String getNomach() {
        return nomach;
    }

    public void setNomach(String nomach) {
        this.nomach = nomach;
    }

    public int getPrixach() {
        return prixach;
    }

    public void setPrixach(int prixach) {
        this.prixach = prixach;
    }

    public int getQtach() {
        return qtach;
    }

    public void setQtach(int qtach) {
        this.qtach = qtach;
    }

    public String getTypeach() {
        return typeach;
    }

    public void setTypeach(String typeach) {
        this.typeach = typeach;
    }

    
   
    
    
}
