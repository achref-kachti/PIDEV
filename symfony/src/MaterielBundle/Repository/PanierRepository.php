<?php


namespace MaterielBundle\Repository;


use Doctrine\ORM\EntityRepository;
use MaterielBundle\Entity\Materiel;
use MaterielBundle\Entity\Panier;
use MaterielBundle\Entity\Users;

class PanierRepository  extends EntityRepository
{
    public function getMateriel_Panier($email)
    {  $sql="select p,m,u from MaterielBundle:panier p join p.refmat m join p.iduser u where 1=1";
        if(!empty($email))
        {
            $sql=$sql." and u.email='".$email."'";
        }

       // var_dump($sql);
        $qb=$this->getEntityManager()->
        createQuery($sql);
        return $query=$qb->getResult();
    }

    public function search_nom($nommat,$email,$trier)
    {  $sql="select p,m,u from MaterielBundle:panier p join p.refmat m join p.iduser u where 1=1";
        if(!empty($nommat))
        {
            $sql=$sql." and m.nommat='".$nommat."'";
        }
        if(!empty($email))
        {
            $sql=$sql." and u.email='".$email."'";
        }
        if($trier==true)
        {  $sql=$sql.' order by m.prixmat desc';
        }
        $qb=$this->getEntityManager()->
        createQuery($sql);
        return $query=$qb->getResult();
    }



    public function calcul_total($email)
    {
        $sql="select sum(p.qtach*m.prixmat) as tot from MaterielBundle:panier p join p.refmat m join p.iduser u  where 1=1";
        if(!empty($email))
        {
            $sql=$sql." and u.email='".$email."'";
        }
        $qb=$this->getEntityManager()->
        createQuery($sql);
        return $query=$qb->getResult();
    }

    public function panier_existe($email,$id)
    {   $verif=true; // panier non vide
        $sql="select p from MaterielBundle:panier p join p.refmat m join p.iduser u where p.refmat=".$id;
        if(!empty($email))
        {
            $sql=$sql." and u.email='".$email."'";
        }
        $qb=$this->getEntityManager()->
        createQuery($sql);
        $res=$qb->getResult();
        //var_dump(count($res));
        if(empty($res)) {$verif=false;}  //panier vide
        return $verif;
    }

    public function rech_refmat($email,$id)
    {   $sql="select p from MaterielBundle:panier p join p.refmat m join p.iduser u where 1=1";
        if(!empty($id))
        {
            $sql=$sql." and p.refmat='".$id."'";
        }
        if(!empty($email))
        {
            $sql=$sql." and u.email='".$email."'";
        }
        $qb=$this->getEntityManager()->
        createQuery($sql);
        return $query=$qb->getResult();
    }


    public function afforder()
    {   $sql="select p from MaterielBundle:panier p join p.refmat m join p.iduser u order by u.nom asc";
        $qb=$this->getEntityManager()->
        createQuery($sql);
        return $query=$qb->getResult();
    }
}