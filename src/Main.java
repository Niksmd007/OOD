public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        for(DayEnum day :DayEnum.values()){
            System.out.println("day: "+day.ordinal());
        }
        DayEnum day= DayEnum.valueOf("Monday");
        System.out.println("day value: "+day.name());
    }
}