package Tim;

import java.util.List;

/**
 * Created by tim on 28-4-15.
 */
public class Opgave12 {
    public static void main(String[] args) {


        for (Integer mid : alleFilms()) {
            if (heeftRegisseur(mid)) {
                List<String> aut = autheurVanFilm(mid);
            }
        }


    }

    public static List<Integer> alleFilms() {
        return null;
    }

    public static List<String> autheurVanFilm(int mid) {
        return null;
    }

    public static boolean heeftRegisseur(int mid) {
        return false;
    }

}
