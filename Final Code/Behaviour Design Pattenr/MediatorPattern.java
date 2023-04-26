interface Commander{
    void registerArmyUnits(ArmyUnit SoliderUnit , ArmyUnit TaskUnit);
    void setAttackerStatus(boolean attackstatus);
    boolean canAttack();
    void startAttack(ArmyUnit armyunit);
    void ceaseAttack(ArmyUnit armyunit);
}
class Commander1 implements Commander{
    ArmyUnit soliderunit,tankunit;
    boolean attackstatus = true;
    @Override
    public void registerArmyUnits(ArmyUnit SoliderUnit, ArmyUnit TankUnit) {        
        this.soliderunit = SoliderUnit;
        this.tankunit = TankUnit;       
    }
    @Override
    public void setAttackerStatus(boolean attackstatus) {       
        this.attackstatus = attackstatus;   
    }
    @Override
    public boolean canAttack() {
        return !attackstatus;
    }
    @Override
    public void startAttack(ArmyUnit armyunit) {
        armyunit.startAttack();
    }
    @Override
    public void ceaseAttack(ArmyUnit armyunit) {
        armyunit.stopAttack();
    }
}
class Commander2 implements Commander{
    ArmyUnit soliderunit,tankunit;
    boolean attackstatus = true;
    @Override
    public void registerArmyUnits(ArmyUnit SoliderUnit, ArmyUnit TaskUnit) {
    }
    @Override
    public void setAttackerStatus(boolean attackstatus) {   
        this.attackstatus = attackstatus;
    }
    @Override
    public boolean canAttack() {
        return attackstatus;
    }
    @Override
    public void startAttack(ArmyUnit armyunit) {
        armyunit.startAttack();
    }
    @Override
    public void ceaseAttack(ArmyUnit armyunit) {
        armyunit.stopAttack();
    }
}
interface ArmyUnit{
    void startAttack();
    void stopAttack();
}
class SoliderUnit implements ArmyUnit{
    Commander commander = null;
    SoliderUnit(Commander c){
        this.commander = c;
    }   
    @Override
    public void startAttack() {
        if(commander.canAttack() == false){         
            commander.setAttackerStatus(false);
            System.out.println("Attack is started");
        }else{          
            System.out.println("You have to wait because the attack is already started");
        }   
    }
    @Override
    public void stopAttack() {
        if(commander.canAttack()){          
            commander.setAttackerStatus(true);
            System.out.println("Attack is stoped");
        }else{          
            System.out.println("No attack is going on");
        }
    }
}
class TankUnit implements ArmyUnit{
    Commander commander = null; 
    TankUnit(Commander c){
        this.commander = c;
    }
    @Override
    public void startAttack() {
        if(commander.canAttack() == false){         
            commander.setAttackerStatus(false);
            System.out.println("Attack is started");
        }else{          
            System.out.println("You have to wait because the attack is already started");
        }   
    }
    @Override
    public void stopAttack() {
        if(commander.canAttack()){          
            commander.setAttackerStatus(true);
            System.out.println("Attack is stoped");
            
        }else{          
            System.out.println("No attack is going on");
        }
    }
}
public class MediatorPattern {
    public static void main(String args[]){
        Commander c = new Commander1();
        ArmyUnit su = new SoliderUnit(c);
        ArmyUnit tu = new TankUnit(c);
        
        c.startAttack(su);
        c.startAttack(tu);
        c.ceaseAttack(tu);
        c.startAttack(tu);
    }
}
