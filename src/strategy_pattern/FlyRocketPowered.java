package strategy_pattern;

public class FlyRocketPowered implements FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
