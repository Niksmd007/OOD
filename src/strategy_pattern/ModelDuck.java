package strategy_pattern;

public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehaviour =new FLyNoWay();
        quackBehaviour =new Quack();
    }

    @Override
    public void display() {
        System.out.println("I' model duck");
    }
}
