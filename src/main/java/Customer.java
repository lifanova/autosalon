public class Customer {
    public static final int MILLIS_FOR_BUY = 2000;
    public static final int MILLIS_FOR_RECEIVE = 1000;
    private Autosalon autosalon;

    public Customer(Autosalon autosalon) {
        this.autosalon = autosalon;
    }

    public synchronized Auto buyAuto() {
        try {
            System.out.printf("%s зашёл в автосалон\n", Thread.currentThread().getName());
            Thread.sleep(MILLIS_FOR_BUY);
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
            Thread.sleep(MILLIS_FOR_RECEIVE);
            notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Autosalon getAutosalon() {
        return autosalon;
    }

    public void setAutosalon(Autosalon autosalon) {
        this.autosalon = autosalon;
    }
}
