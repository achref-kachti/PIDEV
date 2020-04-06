<?php

namespace AppBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use MaterielBundle\Entity\Materiel;
use MaterielBundle\Entity\Panier;
use MaterielBundle\Entity\Users;
class DefaultController extends Controller
{
    /**
     * @Route("/", name="homepage")
     */
    public function indexAction(Request $request)
    {   var_dump($this->getUser());
        $securityContext = $this->container->get('security.authorization_checker');
        if ($securityContext->isGranted('ROLE_ADMIN'))

                return $this->redirectToRoute("materiel_afficher");

            else if ($securityContext->isGranted('ROLE_Client'))

                return $this->redirectToRoute("materiel_afficherfront");

        else
            return $this->redirectToRoute("materiel_afficherfront");


       // return new Response("Hey guys welcome back to my channel");


        // replace this example code with whatever you need
        return $this->render('default/index.html.twig', [
            'base_dir' => realpath($this->getParameter('kernel.project_dir')).DIRECTORY_SEPARATOR,
        ]);
    }
}
