package org.academiadecodigo.arabiannights;

import org.academiadecodigo.arabiannights.genie.Genie;
import org.academiadecodigo.arabiannights.genie.RecyclableDemon;

public class ArabianNights {

    public static void main(String[] args) {

        MagicLamp aladdin = new MagicLamp(3);

        Genie[] genies = new Genie[5];

        System.out.println("----- Created a lamp, now rubbing it -----");

        for (int i = 0; i < genies.length; i++) {
            genies[i] = aladdin.rub();
        }

        System.out.println("----- Asking every genie for two wishes -----");



        for (Genie genie : genies) {
            genie.grantWish();
            genie.grantWish();

            System.out.println("### ### NEXT GENIE ### ###");
        }





        System.out.println("----- Recharging a lamp with a demon  -----");

        RecyclableDemon demon = (RecyclableDemon) genies[4];
        aladdin.recharge(demon);

        System.out.println("----- Creating a new lamp -----");

        // instantiate another lamp
        MagicLamp willSmith = new MagicLamp(1);

        System.out.println("----- Comparing both lamps -----");

        // compare the lamps
        System.out.println("The lamps are equal: " + willSmith.equals(aladdin) + "!");
    }
}
