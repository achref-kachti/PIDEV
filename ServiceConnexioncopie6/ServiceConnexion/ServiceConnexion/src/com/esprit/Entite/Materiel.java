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
public class Materiel {
    private int refmat;  //réference materiel(clé primaire)
    private String nommat; // nom matériel
    private String catmat;  // catégorie : chasse ou pêche
    private String descmat; //description matériel
    private String typemat; // type: vente ou location
    private int prixmat; // prix matériel
    private int qtmat; // quantité matériel disponible
    private String imagemat;  //photo matériel
     

    public Materiel() {
    }
    public Materiel(String nommat, int prixmat) {
        this.nommat = nommat;
        this.prixmat = prixmat;
    }
    public Materiel(int refmat, String nommat, String catmat, String descmat, String typemat, int prixmat, int qtmat,String imagemat) {
        this.refmat = refmat;
        this.nommat = nommat;
        this.catmat = catmat;
        this.descmat = descmat;
        this.typemat= typemat;
        this.prixmat = prixmat;
        this.qtmat= qtmat;
        this.imagemat=imagemat;
    }

    @Override
    public String toString() {
        return "Materiel{" + "reference=" + refmat + ", nom=" + nommat + ", categorie=" + catmat +", description="+descmat+", type="+typemat+", prix="+prixmat+", quantité="+qtmat+", image="+imagemat+ '}';
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
        final Materiel other = (Materiel) obj;
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

    public String getCategorie() {
        return catmat;
    }

    public void setCategorie(String catmat) {
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
    
     public String getImage() {
        return imagemat;
    }

    public void setImage(String imagemat) {
        this.imagemat = imagemat;
    }
    
    
    
    
       
}
