<?php


namespace MaterielBundle\Controller;
use MaterielBundle\Form\UsersType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;
use MaterielBundle\Entity\Users;
use Symfony\Component\HttpFoundation\Request;

class UsersController extends Controller
{   public function affichertabAction(Request $request)
{
    $users=$this->getDoctrine()->getRepository(Users::class)->findAll();


    return $this->render('@Materiel/Users/read1.html.twig',array('clubs'=> $users));
}
    public function supprimerAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $users= $em->getRepository(Users::class)->find($id);
        $em->remove($users);
        $em->flush();
        return $this->redirectToRoute("users_read1");
    }
    public function createAction(Request $request)
    { $users= new Users();
        $form=$this->createForm(UsersType::class, $users);
        $form->handleRequest($request);
        if($form->isSubmitted() and $form->isValid()){
            $em=$this->getDoctrine()->getManager();


            $em->persist($users);
            $em->flush();
            return $this->redirectToRoute('users_read1');
        }
        return $this->render('@Materiel/Users/ajout.html.twig',array('f'=>$form->createView()));
    }

    public function modifAction(Request $request, $id)
    {

        $users=$this->getDoctrine()->getRepository(Users::class)->find($id);

        $form=$this->createForm(UsersType::class, $users);

        $form->handleRequest($request);

        if($form->isSubmitted() and $form->isValid()){
            $em=$this->getDoctrine()->getManager();

            $em->persist($users);
            $em->flush();
            return $this->redirectToRoute('users_read1');
        }
        return $this->render('@Materiel/Users/ajout.html.twig',array('f'=>$form->createView()));
    }




}