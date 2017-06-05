import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by oleg on 7/3/15.
 */
public class JavaStreamLambda {
    private List<Car> carList = new ArrayList<>();
    {
        carList.add(new Car(1, "Ferrari", 3.7));
        carList.add(new Car(2, "Mercedes CLK ", 3.));
        carList.add(new Car(3, "Bentley", 5.));
        carList.add(new Car(4, "Lamborghini", 4.1));
        carList.add(new Car(5, "VAS 2109", 1.6));
        carList.add(new Car(6, "Subaru", 2.4));
        carList.add(new Car(7, "OKA", 1.0));
        carList.add(new Car(8, "Volvo", 2.2));
    }


    public List<Car> getCarList() {
        return carList;
    }

    public static void main(String[] args) {
        JavaStreamLambda shop = new JavaStreamLambda();
        List<Car> carList = shop.getCarList();
        Stream<Car> carStream = carList.parallelStream().filter(car -> (car
                .getEngine() > 2.4));

        List<Car> collect = carStream.
                map(car -> CompletableFuture.supplyAsync(() -> tuneCar(car), new ForkJoinPool())).
                map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println(carList);
        System.out.println(collect);
    }

    private static Car tuneCar(Car car) {
        System.out.println(car.getName() + " StartTune");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        car.setEngine(car.getEngine() + 1);
        return car;
    }
}
