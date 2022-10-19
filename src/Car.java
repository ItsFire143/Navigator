import java.util.Scanner;

public class Car implements Runnable {
    private int distance;
    private int speed;
    private int time = 0;
    private int lastTime;
    private int lastDistance;
    private int averageSpeed;

    @Override
    public void run() {
        Scanner takeDistance = new Scanner(System.in);
        distance = takeDistance.nextInt();
        distance = distance*1000;
        int distanceInput = distance;

        while (distance > 0) {
            speed = (int) (Math.random()*110 + 1);
            distance -= speed;
            time++;
            averageSpeed = distance / time;
            lastTime = distance / speed;
            lastDistance = distanceInput - distance;
            if (distance < 0){
                System.out.println("Приехали");
                System.out.println("Средняя скорость: " + 0 + " м/с");
                System.out.println("Оставшееся расстояние: " + 0 + " м");
                System.out.println("Примерно осталось времени: " + 0 + " с");
                System.out.println("Расстояние: " + 0);
            } else {
                System.out.println("Средняя скорость: " + averageSpeed + " м/с");
                System.out.println("Оставшееся расстояние: " + lastDistance + " м");
                System.out.println("Примерно осталось времени: " + lastTime + " с");
                System.out.println("Расстояние: " + distance);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
