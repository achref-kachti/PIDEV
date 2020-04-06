<?php

namespace MaterielBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Panier
 *
 * @ORM\Table(name="panier", indexes={@ORM\Index(name="panier_ibfk_1", columns={"refmat"}), @ORM\Index(name="panier_ibfk_2", columns={"iduser"})})
 * @ORM\Entity (repositoryClass="MaterielBundle\Repository\PanierRepository")
 */
class Panier
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idach", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idach;

    /**
     * @var integer
     *
     * @ORM\Column(name="qtach", type="integer", nullable=false)
     */
    private $qtach;

    /**
     * @var \Materiel
     *
     * @ORM\ManyToOne(targetEntity="Materiel")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="refmat", referencedColumnName="REFMAT")
     * })
     */
    private $refmat;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser", referencedColumnName="id")
     * })
     */
    private $iduser;



    /**
     * Get idach
     *
     * @return integer
     */
    public function getIdach()
    {
        return $this->idach;
    }

    /**
     * Set qtach
     *
     * @param integer $qtach
     *
     * @return Panier
     */
    public function setQtach($qtach)
    {
        $this->qtach = $qtach;

        return $this;
    }

    /**
     * Get qtach
     *
     * @return integer
     */
    public function getQtach()
    {
        return $this->qtach;
    }

    /**
     * Set refmat
     *
     * @param \MaterielBundle\Entity\Materiel $refmat
     *
     * @return Panier
     */
    public function setRefmat(\MaterielBundle\Entity\Materiel $refmat = null)
    {
        $this->refmat = $refmat;

        return $this;
    }

    /**
     * Get refmat
     *
     * @return \MaterielBundle\Entity\Materiel
     */
    public function getRefmat()
    {
        return  $this->refmat;
    }

    /**
     * Set iduser
     *
     * @param \MaterielBundle\Entity\Users $iduser
     *
     * @return Panier
     */
    public function setIduser(\MaterielBundle\Entity\Users $iduser = null)
    {
        $this->iduser = $iduser;

        return $this;
    }

    /**
     * Get iduser
     *
     * @return \MaterielBundle\Entity\Users
     */
    public function getIduser()
    {
        return $this->iduser;
    }
}
