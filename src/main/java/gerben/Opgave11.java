package gerben;

/**
 * Created by gerben on 28-4-15.
 */
public class Opgave11 implements Opgave {
    public void run(String[] args) {
        Opgave11Statement opgave11Statement = new Opgave11Statement();
        Opgave11PreparedStatement opgave11PreparedStatement = new Opgave11PreparedStatement();
        Opgave11Procedure opgave11Procedure = new Opgave11Procedure();


        for(int i = 0; i < 3; i++) {
            opgave11Statement.run(args);
            opgave11PreparedStatement.run(args);
            opgave11Procedure.run(args);
            System.out.println();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
