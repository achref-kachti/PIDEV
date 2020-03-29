/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.util.Objects;

/**
 *
 * @author sarah
 */
public class AfficherMatrielPanier {
    private int idach;
    private int refmat;
    private int iduser;
    private String nommat;
    private int prixmat;
    private String imagemat;
    private String prenom;
    private int qtach;

    public AfficherMatrielPanier(int idach, int refmat, int iduser, String nommat, int prixmat, String imagemat, String prenom, int qtach) {
        this.idach = idach;
        this.refmat = refmat;
        this.iduser = iduser;
        this.nommat = nommat;
        this.prixmat = prixmat;
        this.imagemat = imagemat;
        this.prenom = prenom;
        this.qtach = qtach;
    }

    public AfficherMatrielPanier() {
    }

    public AfficherMatrielPanier(String nommat, int prixmat, String imagemat, String prenom, int qtach) {
        this.nommat = nommat;
        this.prixmat = prixmat;
        this.imagemat = imagemat;
        this.prenom = prenom;
        this.qtach = qtach;
    }
    public AfficherMatrielPanier(String nommat,  String prenom, int qtach) {
        this.nommat = nommat;
       
        this.prenom = prenom;
        this.qtach = qtach;
    }
     public AfficherMatrielPanier(String nommat,  String prenom, String imagemat, int qtach) {
        this.nommat = nommat;
       this.imagemat = imagemat;

        this.prenom = prenom;
        this.qtach = qtach;
    }

    public AfficherMatrielPanier(String imagemat) {
        this.imagemat = imagemat;
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

    public String getNommat() {
        return nommat;
    }

    public void setNommat(String nommat) {
        this.nommat = nommat;
    }

    public int getPrixmat() {
        return prixmat;
    }

    public void setPrixmat(int prixmat) {
        this.prixmat = prixmat;
    }

    public String getImagemat() {
        return imagemat;
    }

    public void setImagemat(String imagemat) {
        this.imagemat = imagemat;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String nom) {
        this.prenom = prenom;
    }

    public int getQtach() {
        return qtach;
    }

    public void setQtach(int qtach) {
        this.qtach = qtach;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idach;
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
        final AfficherMatrielPanier other = (AfficherMatrielPanier) obj;
        if (this.idach != other.idach) {
            return false;
        }
        if (!Objects.equals(this.nommat, other.nommat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AfficherMatrielPanier{" + "idach=" + idach + ", refmat=" + refmat + ", iduser=" + iduser + ", nommat=" + nommat + ", prixmat=" + prixmat + ", imagemat=" + imagemat + ", prenom=" + prenom + ", qtach=" + qtach + '}';
    }
    
    
    
    
}
