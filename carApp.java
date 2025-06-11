class carApp
{
    public static void main(String args[]){
        car c = new car();
        c.brand = "suzzuki";
        c.colour = "blue";
        c.price = 1500000;
        System.out.println(c.brand);
        System.out.println(c.colour);
        System.out.println(c.price);
        c.accelerate();
    }
}
class car
{
  String brand;
  String colour;
  int price;
  void accelerate()
{
    System.out.println("A car accelerates");
}
        
}