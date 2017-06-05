/**
 * Created by oleg on 7/3/15.
 */
public class Car {
    private Integer id;
    private String name;
    private Double engine;


    public Car(Integer id, String name, Double engine) {
        this.id = id;
        this.name = name;
        this.engine = engine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}
