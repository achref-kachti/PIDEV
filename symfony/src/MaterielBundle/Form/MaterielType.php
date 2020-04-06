<?php

namespace MaterielBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
class MaterielType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('refmat')
            ->add('nommat')
            ->add('catmat', ChoiceType::class, array(
                'choices' => array('chasse' => 'chasse', 'peche' => 'peche'),
                'preferred_choices' => array('chasse'),
            ))
            ->add('descmat')
            ->add('typemat', ChoiceType::class, array(
                'choices' => array('vente' => 'vente', 'location' => 'location'),
                'preferred_choices' => array('vente'),
            ))
            ->add('prixmat')
            ->add('qtmat')
            ->add('imagemat',FileType::class,['data_class'=>null])
            ->add('save',  SubmitType::class,['attr'=>['formnovalidate'=>'formnovalidate']]);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'MaterielBundle\Entity\Materiel'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'materielbundle_materiel';
    }


}
