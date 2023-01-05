abstract class Bill {
    private static int nextBillID = 1;
    private int billID;
    private int billUnit;
    private float billUnitRate;
    
    public Bill(int billUnit, float billUnitRate) {
        this.billID = nextBillID++;
        this.billUnit = billUnit;
        this.billUnitRate = billUnitRate;
    }
    
    public abstract float calculateBill();
    
    public abstract void printBill();

    public int getBillID() {
        return billID;
    }

    public float getBillUnitRate() {
        return billUnitRate;
    }

    public int getBillUnit() {
        return billUnit;
    }
}

class MobileBill extends Bill {
    private float callRate;
    private float callMin;
    
    public MobileBill(int billUnit, float billUnitRate, float callRate, float callMin) {
        super(billUnit, billUnitRate);
        this.callRate = callRate;
        this.callMin = callMin;
    }
    
    @Override
    public float calculateBill() {
        float callCost = callMin * callRate;
        float dataCost = super.getBillUnit() * super.getBillUnitRate();
        return callCost + dataCost;
    }
    
    @Override
    public void printBill() {
        System.out.printf("Mobile bill for bill ID %d:\n", super.getBillID());
        System.out.printf("  Call cost: %.2f\n", callMin * callRate);
        System.out.printf("  Data cost: %.2f\n", super.getBillUnit() * super.getBillUnitRate());
        System.out.printf("  Total cost: %.2f\n", calculateBill());
    }
}

class ElectricityBill extends Bill {
    public ElectricityBill( int billUnit, float billUnitRate) {
        super( billUnit, billUnitRate);
    }
    
    @Override
    public float calculateBill() {
        return super.getBillUnit() * super.getBillUnitRate();
    }
    
    @Override
    public void printBill() {
        System.out.printf("Electricity bill for bill ID %d: %.2f\n", super.getBillID(), calculateBill());
    }
}


class GasBill extends Bill {
    public GasBill(int billUnit, float billUnitRate) {
        super(billUnit, billUnitRate);
    }
    
    @Override
    public float calculateBill() {
        return super.getBillUnit() * super.getBillUnitRate();
    }
    
    @Override
    public void printBill() {
        System.out.printf("Gas bill for bill ID %d: %.2f\n", super.getBillID(), calculateBill());
    }
}


public class Billing{
    public static void main(String[] args) {
        MobileBill m1 = new MobileBill(10,2,2,200);
        m1.printBill();

        MobileBill m2 = new MobileBill(15,3,3,150);
        m2.printBill();

        ElectricityBill e1 = new ElectricityBill(100, 5);
        e1.printBill();

        GasBill g1 = new GasBill(50, 10);
        g1.printBill();
    }
}