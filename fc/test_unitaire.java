package fc;

import java.util.Date;

//debut de test pas dingue ...
public class test_unitaire {
    public static void main(String[] args) {
        System.out.println("\nTest sur les cartes abonnement ! \n");
        System.out.println("Testé actuellement : création, débit et blocage");
        CarteAbonnement mom = new CarteAbonnement();
        CarteAbonnement ca = new CarteAbonnement(mom);
        System.out.println(mom.toString());
        System.out.println(ca.toString());
        System.out.println(ca.debiterCarte(5.2));
        System.out.println(ca.debiterCarte(11.2));
        System.out.println(ca.getBlocage());
        System.out.println(ca.toString());
        
        System.out.println("\nTest sur les cartes Bancaire ! \n");
        System.out.println("Testé actuellement : création");
        CarteBancaire cb = new CarteBancaire("123", "456", new Date());
        System.out.println(cb);
        
        System.out.println("\nTest sur les Clients ! \n");
        System.out.println("Testé actuellement : création");
        Client client = new Client("UFR IM²AG - Bâtiment F 60, rue de la Chimie", cb);
        System.out.println(client);
        
        System.out.println("\nTest sur les Adherent ! \n");
        System.out.println("Testé actuellement : création, crédit et paiement");
        // Client.souscrire() mais pas encore implémenté.
        Adherent adherent = new Adherent(client, "Damien", "Lombard", new Date(), "d.l@etu-grenoble-alpes.fr");
        System.out.println(adherent);
        adherent.créditerCarte(adherent.titulaire, 7.5);
        System.out.println(adherent);
        adherent.paiement(18.5);
        System.out.println(adherent);

        
        System.out.println("\nTest sur les Films ! \n");
        System.out.println("Testé actuellement : création");
        Film film = new Film("Mourrir peut attentre", "James Bond", "Un 007 comme un autre.", new String[] {"Daniel Craig" , "Léa Seydoux"});
        film.afficherInformations();
        System.out.println(film);
        
        System.out.println("\nTest sur les Supports !\n");
        System.out.println("Testé actuellement : création");
        Support support = new Support(film);
        System.out.println(support.toString());
        support.afficherInformations();

        System.out.println("\nTest sur les CD !\n");
        System.out.println("Testé actuellement : création");
        CD cd = new CD(film, false);
        CD cdEndommage = new CD(film, true);
        System.out.println(cdEndommage.toString());
        cd.setEndommage(true);
        System.out.println(cd.getEndommage());
        cd.afficherInformations();
        
        System.out.println("\nTest sur les QRCode !\n");
        System.out.println("Testé actuellement : création");
        QRCode qrCode = new QRCode(film);
        System.out.println(qrCode);
        qrCode.afficherInformations();
    }
    
}
