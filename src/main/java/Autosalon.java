import java.util.ArrayList;
import java.util.List;

public class Autosalon {
    private List<Auto> auto = new ArrayList<>();
    private Customer customer = new Customer(this);
    private int iMax = 10;


    public void sellAuto() {
        System.out.printf("%s открыл продажи автомобилей!\n\n", Thread.currentThread().getName());

        try {
            while (iMax > 0) {
                Thread.sleep(3000);
                System.out.printf("%s подготовил автомобиль к продаже\n", Thread.currentThread().getName());
                auto.add(new Auto());
                customer.receiveAuto();
                iMax--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Auto buyAuto() {
        return customer.buyAuto();
    }

    List<Auto> getAuto() {
        return auto;
    }

}
