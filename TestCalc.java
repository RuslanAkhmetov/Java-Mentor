import java.io.*;

public class TestCalc{
    public static void main(String[] args) throws IOException {
        Calculator calc;
        String formula=" ";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(true){
                System.out.println("Input formula for exit type \" exit \":");
                formula = input.readLine();
                if (!formula.equals("exit")){
                    calc = new Calculator(formula);
                    System.out.println("output :" + calc.Calculate());
                } else {
                    break;
                }
            }
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());

        }
    }

}