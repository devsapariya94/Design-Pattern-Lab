interface Shape
{
    void draw();
 }

class Rectangle implements Shape
{
    public void draw()
    {
        System.out.println("Rectangle is created");
    }
}

class Square implements Shape
{
    public void draw()
    {
        System.out.println("Square is created");
    }
}

class Circle implements Shape
{
    public void draw()
    {
       System.out.println("Circle is created");
    }
}

class ShapeMaker
{
    private Shape circle;
    private Shape rectangle;
    private Shape square;
 
    public ShapeMaker() {
       circle = new Circle();
       rectangle = new Rectangle();
       square = new Square();
    }
 
    public void drawCircle()
    {
       circle.draw();
    }

    public void drawRectangle()
    {
       rectangle.draw();
    }

    public void drawSquare()
    {
       square.draw();
    }
}

public class main {
    public static void main(String[] args) {
        ShapeMaker shapemaker = new ShapeMaker();

        
        
    }
}
