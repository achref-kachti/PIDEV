<?php


namespace MaterielBundle\Repository;
use Doctrine\ORM\EntityRepository;

class MaterielRepository extends EntityRepository
{
    public function rechercher($nommat, $catmat,$typemat)
{
    $sql="select m from MaterielBundle:materiel m Where 1=1";
    if(!empty($nommat))
    {
        $sql=$sql." and m.nommat='".$nommat."'";
    }
    if(!empty($catmat))
    {
        $sql=$sql." and m.catmat='".$catmat."'";
    }
    if(!empty($typemat))
    {
        $sql=$sql." and m.typemat='".$typemat."'";
    }

    var_dump($sql);
    $qb=$this->getEntityManager()->
    createQuery($sql);


    return $query=$qb->getResult();



}



}