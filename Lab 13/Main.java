import java.util.*;

class TreeFlyWeight
{
    String Type;
    String color;

    public TreeFlyWeight(String type, String color)
    {
        System.out.println("\nFlyweight Object: type" + type + "created !!");
        Type = type;
        this.color = color;
    }
}

class Tree
{
    int x;
    int y;
    TreeFlyWeight tf;

    public Tree(TreeFlyWeight t)
    {
        tf = t;
    }

    public void plantTree(int x,int y)
    {
        this.x = x;
        this.y = y;
        System.out.println("Tree type " + tf.Type + " planted at X: " + x +" and Y: " + y);
    }
}

class TreeFactory
{
    Map<String, TreeFlyWeight> tm = new HashMap<String, TreeFlyWeight>();
    TreeFlyWeight tfw = null;

    public TreeFlyWeight createTree(String type)
    {
        if(tm.containsKey(type))
        {
            tfw = tm.get(type);
        }
        else
        {
            if(type.equalsIgnoreCase("Neem-Tree"))
            {
                tfw = new TreeFlyWeight("Neem-Tree" , "Green");
            }
            else if(type.equalsIgnoreCase("Oak-Tree"))
            {
                tfw = new TreeFlyWeight("Oak-Tree", "Orange");
            }
            else
            {
                System.out.println("Invalid Type of trees");
                tm.put(type, tfw);
            }
        }

        return tfw;

    }
}

public class Main
{
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of trees to be planted: ");
        n = sc.nextInt();
        Random rand = new Random();
        ArrayList<String> types = new ArrayList<String>();
        types.add("Neem-Tree");
        types.add("Oak-Tree");

        String[][] forest = new String[10][10];

        while(n != 0)
        {
            String type = types.get(rand.nextInt(2));
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            
            if(type.equals("Neem-Tree"))
            {
                forest[x][y] = "N";
            }
            else if(type.equals("Oak-Tree"))
            {
                forest[x][y] = "O";
            }

            TreeFactory tf = new TreeFactory();
            TreeFlyWeight tfw = tf.createTree(type);
            Tree t = new Tree(tfw);
            t.plantTree(x, y);
            n--;
        }

        System.out.println("\nForest: ");
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(forest[i][j] == null)
                {
                    System.out.print("_ ");
                }
                else
                {
                    System.out.print(forest[i][j] + " ");
                }
            }
            System.out.println();
        }

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(forest[i][j] == "N")
                {
                    n++;
                }
                else if(forest[i][j] == "O")
                {
                    n--;
                }
            }
        }

        System.out.println("\nLeft area of forest is dense with: " + (n > 0 ? "Neem-Tree" : "Oak-Tree"));
    }
}