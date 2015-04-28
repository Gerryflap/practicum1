package Tim;

/**
 * Created by tim on 28-4-15.
 */
public class Opgave11 implements Opgave {
    public static void main(String[] args) {
        int iters=100;
        long startTime = System.currentTimeMillis();
        // voorbereidende statements buiten de loop
        // bijvoorbeeld Statement st = conn.createStatement();
        for (int i=0; i<iters; i++) {
            // statements die je 100x wilt doen
        }
        // afrondende statements buiten de loop (bijv “st.close();”)
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / (1.0*iters);
        System.out.println("Gemeten tijd: "+elapsedTime+" ms");
    }

    public static String getQuery() {
        return
                "SELECT haut.name FROM Person haut, Writes hw\n" +
                "WHERE haut.pid = hw.pid\n" +
                "AND NOT EXISTS (SELECT aut.name FROM Person aut, Movie m, Writes w\n" +
                "WHERE aut.pid = w.pid\n"  +
                "AND aut.name = haut.name\n" +
                "AND w.mid = m.mid\n" +
                "AND (EXISTS (SELECT d FROM Directs d\n" +
                        "WHERE m.mid = d.mid)));";

    }
}
