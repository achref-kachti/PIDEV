<?php


namespace ClubBundle\Controller;
use ClubBundle\Form\RechercheType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use ClubBundle\Entity\Formation;
use ClubBundle\Form\FormationType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class FormationController extends Controller
{ public function afficherformationsAction(){
    $formations=$this->getDoctrine()->getRepository(Formation::class)->findAll();
    //var_dump($formations);
    return $this->render('@Club/Formation/affichageformation.html.twig',array('clubs'=> $formations));
}

    public function createAction(Request $request)
    { $f= new Formation();
        $form=$this->createForm(FormationType::class, $f);
        $form=$form->handleRequest($request);
        if($form->isSubmitted() and $form->isValid()){
            $em=$this->getDoctrine()->getManager();
            $em->persist($f);
            $em->flush();
            return $this->redirectToRoute('formation_aff');
        }
        return $this->render('@Club/Formation/ajout.html.twig',array('f'=>$form->createView()));
    }

    public function searchAction(Request $request)
    {  $formation= new Formation();
    $form=$this->createForm(RechercheType::class,$formation);
    $form->handleRequest($request);
    if($form->isSubmitted()){
        $formations =$this->getDoctrine()->getRepository(Formation::class)->findBy(array('titre'=>$formation->getTitre()));
    }
    else{
        $formations=$this->getDoctrine()->getRepository(Formation::class)->findAll();
        }

        return $this->render('@Club/Formation/recherche.html.twig',array("form"=>$form->createView(),'formations'=>$formations));
       }

}