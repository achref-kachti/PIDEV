<?php

namespace ClubBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\DateType;

class FormationType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('titre')->
        add('description')->
        add('dateDebut',DateType::class,['widget'=>'single_text','format'=>'yyyy-MM-dd'])->
        add('dateFin',DateType::class,['widget'=>'single_text','format'=>'yyyy-MM-dd'])->
        add('nbParticipant')
            ->add('club',EntityType::class,array(
                'class'=>'ClubBundle:Club',
                'choice_label'=>'nom',
                'multiple'=>false
            ))
        ->add('Valider',SubmitType::class,['attr'=>['formnovalidate'=>'formnovalidate']]);
          ;
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'ClubBundle\Entity\Formation'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'clubbundle_formation';
    }


}
