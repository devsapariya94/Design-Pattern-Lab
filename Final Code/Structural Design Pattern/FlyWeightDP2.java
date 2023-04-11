import java.util.HashMap;
import java.util.Map;

class PlayerFlyWeight
{
    String type;
    String task;
    String colorCode;

    public PlayerFlyWeight(String type)
    {
        if(type.equals("CT"))
        {
            this.colorCode = "ORANGE";
            this.task = "Defuse Bomb";
        }
        else if(type.equals("T"))
        {
            this.colorCode = "GREEN";
            this.task = "Plant Bomb";
        }
    }
}

class Player
{
    String weapon;
    int pos_x;
    int pos_y;
    PlayerFlyWeight pf;

    public Player(PlayerFlyWeight pf)
    {
        this.pf = pf;
    }

    public void createPlayer(int pos_x, int pos_y)
    {
        this.pos_x = pos_x;
        this.pos_y = pos_y;

        System.out.println("Player Position is : " + pos_x  + " , "+ pos_y);
    }
}

class PlayerFactory
{
    static int count_terrorist;
    static int count_counter_terrorist;

    Map<String, PlayerFlyWeight> player_map = new HashMap<String, PlayerFlyWeight>();   
    PlayerFlyWeight plw = null;

    public PlayerFlyWeight createPlayer(String type)
    {
        if(player_map.containsKey(type))
        {
            plw = player_map.get(type);
        }
        else if(type.equalsIgnoreCase("Terrorist"))
        {
            plw = new PlayerFlyWeight("T");
            count_terrorist++;
        }
        else if(type.equalsIgnoreCase("CT"))
        {
            plw = new PlayerFlyWeight("CT");
            count_counter_terrorist++;
        }
        else
        {
            System.out.println("Invalid player type!");
        }
        player_map.put(type, plw);
        return plw;
    }
}

public class FlyWeightDP2 
{
    public static void main(String[] args) 
    {
        PlayerFactory playerFactory = new PlayerFactory();

        // Create Counter Terrorists
        PlayerFlyWeight ctFlyweight = playerFactory.createPlayer("CT");
        Player ct1 = new Player(ctFlyweight);
        ct1.createPlayer(0,0);

        PlayerFlyWeight ctFlyweight2 = playerFactory.createPlayer("CT");
        Player ct2 = new Player(ctFlyweight2);
        ct2.createPlayer(0,10);

        // Create Terrorists
        PlayerFlyWeight tFlyweight = playerFactory.createPlayer("T");
        Player t1 = new Player(tFlyweight);
        t1.createPlayer(10,0);

        PlayerFlyWeight tFlyweight2 = playerFactory.createPlayer("T");
        Player t2 = new Player(tFlyweight2);
        t2.createPlayer(10,10);

        // Show Stats
        System.out.println("Number of Counter Terrorists created: " + PlayerFactory.count_counter_terrorist);
        System.out.println("Number of Terrorists created: " + PlayerFactory.count_terrorist);
    }
}
