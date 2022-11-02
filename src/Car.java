import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Car implements Runnable {
    private double distance;
    private double speed;
    private double time;
    private double lastTime;
    private double lastDistance;
    private double averageSpeed;

    @Override
    public void run() {
        Scanner takeDistance = new Scanner(System.in);
        distance = takeDistance.nextInt();
        distance = distance*1000;
        double distanceInput = distance;

        while (distance > 0) {
            speed = (int) (Math.random()*110 + 1);
            distance -= speed;
            time++;
            averageSpeed = distance / time;
            lastTime = distance / speed;
            //lastDistance = distanceInput - distance;
            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.CEILING);
            //Double d = n.doubleValue();
            //System.out.println(df.format());
            /*

            */
            if (distance < 0){
                System.out.println("Приехали");
                System.out.println("Средняя скорость: " + 0 + " км/ч");
                System.out.println("Оставшееся расстояние: " + 0 + " км");
                System.out.println("Примерно осталось времени: " + 0 + " с");
            } else {
                System.out.println("Средняя скорость: " + df.format(averageSpeed * 1000/3600) + " км/ч");
                System.out.println("Оставшееся расстояние: " + df.format(distance/1000) + " км");
                System.out.println("Примерно осталось времени: " + df.format(lastTime) + " с");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
