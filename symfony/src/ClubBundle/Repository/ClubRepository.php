<?php


namespace ClubBundle\Repository;
use Doctrine\ORM\EntityRepository;

class ClubRepository extends EntityRepository
{public function myfindDomaine(){
    $qb=$this->getEntityManager()->
        createQuery("select c from ClubBundle:Club c Where c.domaine='info'");
    return $query=$qb->getResult();
}

}