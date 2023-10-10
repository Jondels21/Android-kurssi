import java.util.ArrayList;

public class Hello {
    public static void main(String args[]) {


        Lintu haukka = new Lintu("Haukka");
        Kala kilpikonna = new Kala("Kilpikonna");

        haukka.heraa();
        kilpikonna.heraa();

        haukka.toimi();
        kilpikonna.toimi();

        haukka.lepaa();
        kilpikonna.lepaa();




        ArrayList<Elain> elaimet = new ArrayList<>();

        elaimet.add(new Lintu("Haukka"));
        elaimet.add(new Elain("Elain"));
        elaimet.add(new Kala("Kilpikonna"));
        for(Elain e : elaimet){
            e.heraa();
        }
        for(Elain e : elaimet){
            e.toimi();
        }
        for(Elain e : elaimet){
            e.lepaa();
        }

    }
}
