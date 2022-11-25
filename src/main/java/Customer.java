public class Customer {
    private Autosalon autosalon;

    public Customer(Autosalon autosalon) {
        this.autosalon = autosalon;
    }

    public synchronized Auto buyAuto() {
        try {
            System.out.printf("%s зашёл в автосалон\n", Thread.currentThread().getName());
            Thread.sleep(2000);
            while (autosalon.getAuto().size() == 0) {
                System.out.println("Нет автомобилей в наличии");
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("%s уехал домой на новом автомобиле\n", Thread.currentThread().getName());

        return autosalon.getAuto().remove(0);
    }

    public synchronized void receiveAuto() {
        try {
            Thread.sleep(1000);
            notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
