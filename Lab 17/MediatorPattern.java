interface Commander
{
    void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    void setAttackStatus(boolean attackStatus);
    boolean canAttack();
    void startAttack(ArmedUnit soldierUnit);
    void ceaseAttack(ArmedUnit soldierUnit);
}

interface ArmedUnit
{
    void attack();
}

class CommanderImpl implements Commander
{
    ArmedUnit soldierUnit, tankUnit;
    boolean attackStatus = true;

    public void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit)
    {
        this.soldierUnit = soldierUnit;
        this.tankUnit = tankUnit;
    }

    public void setAttackStatus(boolean attackStatus)
    {
        this.attackStatus = attackStatus;
    }

    public boolean canAttack()
    {
        return attackStatus;
    }

    public void startAttack(ArmedUnit soldierUnit)
    {
        if (canAttack())
        {
            soldierUnit.attack();
        }
        else
        {
            System.out.println("Soldier unit cannot attack now");
        }
    }

    public void ceaseAttack(ArmedUnit soldierUnit)
    {
        setAttackStatus(false);
    }
}

class SoldierUnit implements ArmedUnit
{
    Commander commander;

    public SoldierUnit(Commander commander)
    {
        this.commander = commander;
    }

    public void attack()
    {
        System.out.println("Soldier unit attacks");
    }
}

class TankUnit implements ArmedUnit
{
    Commander commander;

    public TankUnit(Commander commander)
    {
        this.commander = commander;
    }

    public void attack()
    {
        System.out.println("Tank unit attacks");
    }
}

public class MediatorPattern
{
    public static void main(String[] args)
    {
        Commander commander = new CommanderImpl();
        ArmedUnit soldierUnit = new SoldierUnit(commander);
        ArmedUnit tankUnit = new TankUnit(commander);

        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(soldierUnit);
    }
}
