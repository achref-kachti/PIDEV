<?php

namespace ClubBundle\Controller;

use ClubBundle\Form\ClubType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;
use ClubBundle\Entity\Club;
use Symfony\Component\HttpFoundation\Request;


class ClubController extends Controller
{
    public function indexAction()
    {
        $classe = '3A';
        return new Response('Bonjour mes étudiants: ' . $classe . '.');
    }


    public function homePageAction()
    {

        return $this->render('@Club/Club/homePage.html.twig');


    }
    public function readAction($nom)
    {
        return $this->render('@Club/Club/read.html.twig',array('n'=>$nom));
    }

    public function listAction()
    {   $formations=array();
        $formations[0]= array('ref'=>'F1','titre'=>'Formation symfony');
        $formations[1]=array('ref'=>'F2','titre'=>'Angular');

        return $this->render('@Club/Club/detail.html.twig',array('f'=>$formations));
    }

    public function showAction($titre,$ref)
    { return $this->render('@Club/Club/show.html.twig',array('r'=>$ref,'t'=>$titre));
    

    }

    public function affichertabAction()
    {
        $clubs=$this->getDoctrine()->getRepository(Club::class)->findAll();
        return $this->render('@Club/Club/read1.html.twig',array('clubs'=> $clubs));
    }
    public function supprimerAction($id)
    {
       $em=$this->getDoctrine()->getManager();
       $club= $em->getRepository(Club::class)->find($id);
       $em->remove($club);
       $em->flush();
        return $this->redirectToRoute("club_read1");
    }
    public function createAction(Request $request)
    { $club= new Club();
      $form=$this->createForm(ClubType::class, $club);
      $form=$form->handleRequest($request);
      if($form->isSubmitted()){
          $em=$this->getDoctrine()->getManager();
          $em->persist($club);
          $em->flush();
          return $this->redirectToRoute('club_read1');
      }
      return $this->render('@Club/Club/ajout.html.twig',array('f'=>$form->createView()));
    }

    public function modifAction(Request $request, $id)
    {   $em=$this->getDoctrine()->getManager();
        $club = $em->getRepository(Club::class)->find($id);
        $form=$this->createForm(ClubType::class, $club);
        $form=$form->handleRequest($request);

        if($form->isSubmitted()){
            $em=$this->getDoctrine()->getManager();

            $em->flush();
            return $this->redirectToRoute('club_read1');
        }
        return $this->render('@Club/Club/ajout.html.twig',array('f'=>$form->createView()));
    }

    public function updateAction(Request $request,$id)
    {    $em=$this->getDoctrine()->getManager();
        $club = $em->getRepository(Club::class)->find($id);
        if($request->isMethod('POST')){
            $club->setNom($request->get('nom'));
            $club->setDescription($request->get('descr'));
            $club->setAdresse($request->get('adr'));
            $club->setDomaine($request->get('domaine'));
            $em->flush();
            return $this->redirectToRoute('club_read1');
        }
        return $this->render('@Club/Club/formulaire.html.twig',array('club'=>$club));

    }

    public function trouverdomaineAction(){
        $repository=$this->getDoctrine()->getManager()->getRepository(Club::class);
        $listclubs=$repository->myfindDomaine();
        return($this->render('@Club/Club/domaine.html.twig',array('listclubs'=>$listclubs)));
    }
}