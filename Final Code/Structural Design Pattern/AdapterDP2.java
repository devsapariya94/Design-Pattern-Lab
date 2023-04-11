import java.util.Arrays;

interface MathProcessing {
    int performOperation(double[] numbers, String ops);

}

class BasicMathProcessing implements MathProcessing {
    public int performOperation(double[] numbers, String ops) {
        
        if (ops=="+"){
            int ans=0;
            for (int i = 0; i < numbers.length; i++) {
                ans+=numbers[i];
            }
            return ans;
        }
    
        else if (ops=="*"){
            int ans=1;
            for (int i = 0; i < numbers.length; i++) {
                ans*=numbers[i];
            }
            return ans;
        }
        return 0;
       
    }
    
}


class AdvanceMathProcessing {
  
    public double calculateAverage(double[] numbers) {
       int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }
    
  
    public double[] sortData(double[] numbers) {
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }
    
    public int searchData(double[] numbers, double key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public double[] replace(double[] numbers, double oldValue, double newValue) {
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == oldValue) {
                numbers[i] = newValue;
            }
        }
        return numbers;
        
    }
}










class MathProcessingAdapter implements MathProcessing {
    private AdvanceMathProcessing advanceMathProcessing;

    public MathProcessingAdapter(AdvanceMathProcessing advanceMathProcessing) {
        this.advanceMathProcessing = advanceMathProcessing;
    }

    public int performOperation(double[] numbers, String ops) {
        return ((MathProcessing) advanceMathProcessing).performOperation(numbers, ops);
       
    }

    public double calculateAverage(double[] numbers) {
        return advanceMathProcessing.calculateAverage(numbers);
    }

    public double[] sortData(double[] numbers) {
        return advanceMathProcessing.sortData(numbers);
    }

    public int searchData(double[] numbers, double key) {
        return advanceMathProcessing.searchData(numbers, key);
    }

    public double[] replace(double[] numbers, double oldValue, double newValue) {
        return advanceMathProcessing.replace(numbers, oldValue, newValue);
    }
}


public class AdapterDP2 {
    public static void main(String[] args) {
        double[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        MathProcessingAdapter mathProcessingAdapter = new MathProcessingAdapter(new AdvanceMathProcessing());
        System.out.println("Average: " + mathProcessingAdapter.calculateAverage(numbers));
        System.out.println("Sorted Data: " + Arrays.toString(mathProcessingAdapter.sortData(numbers)));
        System.out.println("Search Data: " + mathProcessingAdapter.searchData(numbers, 5));
        System.out.println("Replace Data: " + Arrays.toString(mathProcessingAdapter.replace(numbers, 5, 50)));
    }
}
