<?php

namespace MaterielBundle\Controller;

use MaterielBundle\Form\MaterielType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;
use MaterielBundle\Entity\Materiel;
use MaterielBundle\Entity\Panier;
use MaterielBundle\Entity\Users;
use Symfony\Component\HttpFoundation\Request;


class MaterielController extends Controller
{
    public function indexAction()
    {
        return new Response("Hey guys welcome back to my channel");
    }

    public function affichertabAction(Request $request)
    {   $mat=$this->getDoctrine()->getRepository(Materiel::class)->findAll();
        if ($request->isMethod('POST'))
        {    $repository=$this->getDoctrine()->getManager()->getRepository(Materiel::class);
            if ($request->get('rechercher'))
            {
                $nommat=$request->get('nommat');
                $catmat=$request->get('catmat');
                $typemat=$request->get('typemat');
                $mat=$repository->rechercher($nommat,$catmat,$typemat);
                return $this->render('@Materiel/Materiel/affichermat.html.twig', array('mat' => $mat));
            }
            if ($request->get('trier'))
            {
                $mat = $repository->findBy(array(), array('prixmat' => 'desc'));
                return $this->render('@Materiel/Materiel/affichermat.html.twig', array('mat' => $mat));
            }
        }
        return $this->render('@Materiel/Materiel/affichermat.html.twig',array('mat'=> $mat));
    }

    public function ajoutermatAction(Request $request)
    { $mat= new Materiel();
        $form=$this->createForm(MaterielType::class, $mat);
        $form=$form->handleRequest($request);
        if($form->isSubmitted() and $form->isValid()){
            $em=$this->getDoctrine()->getManager();
            $mat->setImage($mat->getImage()->getClientOriginalName());
            $em->persist($mat);
            $em->flush();
            return $this->redirectToRoute('materiel_afficher');
        }
        return $this->render('@Materiel/Materiel/ajoutermat.html.twig',array('f'=>$form->createView()));
    }

    public function supprimermatAction($id)
{
    $em=$this->getDoctrine()->getManager();
    $mat= $em->getRepository(Materiel::class)->find($id);
    $em->remove($mat);
    $em->flush();
    return $this->redirectToRoute("materiel_afficher");
}

    public function modifiermatAction(Request $request, $id)
    {   $em=$this->getDoctrine()->getManager();
        $mat = $em->getRepository(Materiel::class)->find($id);
        $form=$this->createForm(MaterielType::class, $mat);
        $form=$form->handleRequest($request);

        if($form->isSubmitted()){
            $em=$this->getDoctrine()->getManager();

            $em->flush();
            return $this->redirectToRoute('materiel_afficher');
        }
        return $this->render('@Materiel/Materiel/ajoutermat.html.twig',array('f'=>$form->createView()));
    }

    public function cherchermatAction(Request $request)
    {
        $mat=$this->getDoctrine()->getRepository(Materiel::class)->findAll();
        if($request->isMethod('POST')) {
            $repository=$this->getDoctrine()->getManager()->getRepository(Materiel::class);
            if ($request->get('rechercher')) {

                $mat = $repository->rechercher($request->get('nommat'),$request->get('catmat'),$request->get('typermat'));
                return $this->render('@Materiel/Materiel/recherchermat.html.twig', array('mat' => $mat));
            }
        }
    }

    public function triermatAction()
    {
        $em = $this->getDoctrine()->getEntityManager();

        $mat = $em->getRepository("MaterielBundle:Materiel")->findBy(array(), array('prixmat' => 'desc'));

        return $this->render('@Materiel/Materiel/triermat.html.twig', array(
            'mat' => $mat
        ));
    }

    public function afficherfrontAction(Request $request)
    {
        $mat=$this->getDoctrine()->getRepository(Materiel::class)->findAll();
        if ($request->isMethod('POST'))
        {    $repository=$this->getDoctrine()->getManager()->getRepository(Materiel::class);
            if ($request->get('rechercher'))
            {
                $nommat=$request->get('nommat');
                $catmat=$request->get('catmat');
                $typemat=$request->get('typemat');
                $mat=$repository->rechercher($nommat,$catmat,$typemat);
                return $this->render('@Materiel/Materiel/affichermatfront.html.twig', array('mat' => $mat));
            }
            if ($request->get('trier'))
            {
                $mat = $repository->findBy(array(), array('prixmat' => 'desc'));
                return $this->render('@Materiel/Materiel/affichermatfront.html.twig', array('mat' => $mat));
            }
        }
        return $this->render('@Materiel/Materiel/affichermatfront.html.twig',array('mat'=> $mat));
    }




    public function templateAction()
    {
        //return $this->redirectToRoute("template_aff");
        return $this->render('@Materiel/Materiel/template.html.twig');


    }
    public function templatefrontAction()
    {
        //return $this->redirectToRoute("templatefront_aff");
        return $this->render('@Materiel/Materiel/templatefront.html.twig');


    }

}
