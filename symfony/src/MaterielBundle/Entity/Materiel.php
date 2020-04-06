<?php

namespace MaterielBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;
/**
 * Materiel
 *
 * @ORM\Table(name="materiel")
 * @ORM\Entity (repositoryClass="MaterielBundle\Repository\MaterielRepository")
 * @UniqueEntity(fields="nommat", message="Ce matériel existe déjà.")
 */
class Materiel
{
    /**
     * @var integer
     *
     * @ORM\Column(name="REFMAT", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $refmat;

    /**
     * @var string
     *
     * @ORM\Column(name="NOMMAT", type="string", length=50, nullable=false)
     * @Assert\NotBlank(message="le champ nom est obligatoire")
     */
    private $nommat;

    /**
     * @var string
     *
     * @ORM\Column(name="CATMAT", type="string", length=50, nullable=false)
     */
    private $catmat;

    /**
     * @var string
     *
     * @ORM\Column(name="DESCMAT", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="le champ description est obligatoire")
     */
    private $descmat;

    /**
     * @var string
     *
     * @ORM\Column(name="TYPEMAT", type="string", length=50, nullable=false)
     */
    private $typemat;

    /**
     * @var integer
     *
     * @ORM\Column(name="PRIXMAT", type="integer", nullable=false)
     * @Assert\NotBlank(message="le champ prix est obligatoire")
     * @Assert\Range(min=1)
     */
    private $prixmat;

    /**
     * @var integer
     *
     * @ORM\Column(name="QTMAT", type="integer", nullable=false)
     * @Assert\NotBlank(message="le champ quantité est obligatoire")
     * @Assert\Range(min=1)
     */
    private $qtmat;

    /**
     * @var string
     *
     * @ORM\Column(name="IMAGEMAT", type="string", length=250, nullable=false)
     * @Assert\NotBlank(message="le champ image est obligatoire")
     * @Assert\Image
     */
    private $imagemat;

    /**
     * Set refmat
     *
     * @param integer $refmat
     *
     * @return Materiel
     */
    public function setRefmat($refmat)
    {
        $this->refmat = $refmat;

        return $this;
    }

    /**
     * Get refmat
     *
     * @return integer
     */
    public function getRefmat()
    {
        return $this->refmat;
    }

    /**
     * Set nommat
     *
     * @param string $nommat
     *
     * @return Materiel
     */
    public function setNommat($nommat)
    {
        $this->nommat = $nommat;

        return $this;
    }

    /**
     * Get nommat
     *
     * @return string
     */
    public function getNommat()
    {
        return $this->nommat;
    }

    /**
     * Set catmat
     *
     * @param string $catmat
     *
     * @return Materiel
     */
    public function setCatmat($catmat)
    {
        $this->catmat = $catmat;

        return $this;
    }

    /**
     * Get catmat
     *
     * @return string
     */
    public function getCatmat()
    {
        return $this->catmat;
    }

    /**
     * Set descmat
     *
     * @param string $descmat
     *
     * @return Materiel
     */
    public function setDescmat($descmat)
    {
        $this->descmat = $descmat;

        return $this;
    }

    /**
     * Get descmat
     *
     * @return string
     */
    public function getDescmat()
    {
        return $this->descmat;
    }

    /**
     * Set typemat
     *
     * @param string $typemat
     *
     * @return Materiel
     */
    public function setTypemat($typemat)
    {
        $this->typemat = $typemat;

        return $this;
    }

    /**
     * Get typemat
     *
     * @return string
     */
    public function getTypemat()
    {
        return $this->typemat;
    }

    /**
     * Set prixmat
     *
     * @param integer $prixmat
     *
     * @return Materiel
     */
    public function setPrixmat($prixmat)
    {
        $this->prixmat = $prixmat;

        return $this;
    }

    /**
     * Get prixmat
     *
     * @return integer
     */
    public function getPrixmat()
    {
        return $this->prixmat;
    }

    /**
     * Set qtmat
     *
     * @param integer $qtmat
     *
     * @return Materiel
     */
    public function setQtmat($qtmat)
    {
        $this->qtmat = $qtmat;

        return $this;
    }

    /**
     * Get qtmat
     *
     * @return integer
     */
    public function getQtmat()
    {
        return $this->qtmat;
    }

    /**
     * Set imagemat
     *
     * @param string $imagemat
     *
     * @return Materiel
     */
    public function setImagemat($imagemat)
    {
        $this->imagemat = $imagemat;

        return $this;
    }

    /**
     * Get imagemat
     *
     * @return string
     */
    public function getImagemat()
    {
        return $this->imagemat;
    }
}
