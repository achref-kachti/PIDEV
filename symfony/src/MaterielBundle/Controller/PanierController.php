<?php


namespace MaterielBundle\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;
use MaterielBundle\Entity\Panier;
use Symfony\Component\HttpFoundation\Request;
use MaterielBundle\Entity\Materiel;
use MaterielBundle\Entity\Users;

class PanierController extends Controller
{
    public function afficherpanierAction()
    {
        $mat=$this->getDoctrine()->getRepository(Panier::class)->afforder();
        return $this->render('@Materiel/Panier/afficherpanier.html.twig',array('mat'=> $mat));
    }

    public function supprimerpanieruserAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $mat= $em->getRepository(Panier::class)->find($id);
        $em->remove($mat);
        $em->flush();
        return $this->redirectToRoute("panier_userafficher");
    }



    public function afficherpanieruserAction(Request $request)
    {
        $repository = $this->getDoctrine()->getManager()->getRepository(Panier::class);
        $user = $this->getDoctrine()->getRepository(Users::class)->findOneByEmail($this->getUser()->getemail());
        $email = $user->getEmail();
        $panier = $repository->getMateriel_Panier($email);
        $tot= $repository->calcul_total($email);
        if ($request->isMethod('POST'))
        {
            if ($request->get('rechercher'))
            {
                $panier = $repository->search_nom($request->get('nommat'),$email,false);
               return $this->render('@Materiel/Panier/afficherpanierfront.html.twig', array('panier' => $panier,'tot' => $tot));
            }
            if ($request->get('trier'))
            {
                $panier = $repository->search_nom($request->get('nommat'),$email,true);
                return $this->render('@Materiel/Panier/afficherpanierfront.html.twig', array('panier' => $panier,'tot' => $tot));
            }
        }

        return $this->render('@Materiel/Panier/afficherpanierfront.html.twig', array('panier' => $panier,'tot' => $tot));
    }

    public function ajouterpanierAction(Request $request, $id)
    {
        $repository = $this->getDoctrine()->getManager()->getRepository(Panier::class);
        $mat= $this->getDoctrine()->getRepository(Materiel::class)->find($id);
        $user=$this->getDoctrine()->getRepository(Users::class)->findOneByEmail($this->getUser()->getemail());
        $email = $user->getEmail();
        $verif=$repository->panier_existe($email,$id);
        if($verif==false) {
            $panier=new Panier();
            $panier->setIduser($user);
            $panier->setRefmat($mat);
            $panier->setQtach(1);
            $em=$this->getDoctrine()->getManager();
            $em->persist($panier);
            $em->flush();
            return $this->redirectToRoute('panier_userafficher');
        }
        else {  $panier= $repository->rech_refmat($email,$id);
                 //var_dump($panier);

                $panier[0]->setQtach(($panier[0]->getQtach())+1);
            $em=$this->getDoctrine()->getManager();
            $em->persist($panier[0]);
            $em->flush();
            return $this->redirectToRoute('panier_userafficher');
             }


    }

}