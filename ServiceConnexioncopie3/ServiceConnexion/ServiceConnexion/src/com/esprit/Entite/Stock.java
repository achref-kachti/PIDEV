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
public class Stock {
    
    
    private int refmat;
    private String nommat;
    private int catmat;  //1: chasse ou 2: pêche
    private String descmat;
    private String typemat; // vente ou location
    private int prixmat;
    private int qtmat;
     
     

    public Stock() {
    }
    public Stock(String nommat, int prixmat) {
        this.nommat = nommat;
        this.prixmat = prixmat;
    }
    public Stock(int refmat, String nommat, int catmat, String descmat, String typemat, int prixmat, int qtmat) {
        this.refmat = refmat;
        this.nommat = nommat;
        this.catmat = catmat;
        this.descmat = descmat;
        this.typemat= typemat;
        this.prixmat = prixmat;
        this.qtmat= qtmat;
    }

    @Override
    public String toString() {
        return "Stock{" + "reference=" + refmat + ", nom=" + nommat + ", categorie=" + catmat +", description="+descmat+", type="+typemat+", prix="+prixmat+", quantité="+qtmat+ '}';
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
        final Stock other = (Stock) obj;
        if (this.refmat != other.refmat) {
            return false;
        }
        if (!Objects.equals(this.nommat, other.nommat)) {
            return false;
        }
        return true;
    }

    
    public int getRef() {
        return refmat;
    }

    public void setRef(int refmat) {
        this.refmat = refmat;
    }

    public String getNom() {
        return nommat;
    }

    public void setNom(String nommat) {
        this.nommat = nommat;
    }
    
    public String getDesc() {
        return nommat;
    }

    public void setDesc(String descmat) {
        this.descmat = descmat;
    }

    public int getCategorie() {
        return catmat;
    }

    public void setCategorie(int catmat) {
        this.catmat = catmat;
    }
    
     public int getPrix() {
        return prixmat;
    }

    public void setPrix(int prixmat) {
        this.prixmat = prixmat;
    }
    
     public int getQuantite() {
        return qtmat;
    }

    public void setQuantite(int qtmat) {
        this.qtmat = qtmat;
    }
    
    public String getType() {
        return typemat;
    }

    public void setType(String typemat) {
        this.typemat = typemat;
    }
    
    
    
    
    
}
