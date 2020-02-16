
public class Calculator{
    String str;                   // Main string
    int [] arg;
    char operand;  
    String  err;
    boolean isarab;
    float result;                 //Calculation result
    
    public Calculator (String str) {
        this.str = str;
        this.arg=new int[2];
        this.isarab= Rimdigit.IsArab(str);
        this.err="";
        float result=0;
    }

    private  boolean setArguments(){
        String num="";
        boolean open =false; 
        char[] ch = str.toCharArray();
        int i=0, n=0;
        for (i=0;i<ch.length; i++){
            switch (ch[i]){
                case '*':
                case '/':
                case '+':
                case '-':
                    if (num.length()==0 ) {
                        err ="String " + str + " begins from operand";
                        throw new IllegalArgumentException(err);
                    } else {
                       
                        if (!isarab){
                            arg[n]=Rimdigit.GetArabN(num);
                        } else{
                            arg[n]=Integer.valueOf(num);
                        } 
                        n++;
                        num="";
                        operand= ch[i];    
                    }
                    break;
                case ' ':
                    break;
                default:
                    if (Character.isDigit(ch[i]) || Character.isLetter(ch[i])){
                        num += Character.toString(ch[i]);
                    } else {
                        err ="String \"" + str + "\" contains illegial character" + Character.toString(ch[i]);
                    throw new IllegalArgumentException(err);
                    }
            }
           
        } 
        
        if(num.length() !=0){
            if (!isarab){
                arg[n]=Rimdigit.GetArabN(num.toString());
            } else{
                arg[n]=Integer.valueOf(num.toString());
            }  
        }
        return true;
    }

    public String Calculate(){
        setArguments();
        switch (operand){
            case '*':
                result = arg[0]*arg[1];
                break;
            case '/':
                result = (float)arg[0]/(float)arg[1];
                break;
            case '+':
                result = arg[0]+arg[1];
            break;
            case '-':
                result = arg[0]-arg[1];
                break;
            default:
                err ="String \"" + str + "\" contains illegial operand" + Character.toString(operand);
                throw new IllegalArgumentException(err); 
        }
        if(isarab){
            return String.valueOf(result);
        } else{
            if (Math.round(result) == result){
                return Rimdigit.GetRimN(Math.round(result));
            } else {
                err ="Result \"" + String.valueOf(result) + "\" can't be converted to rim number";
                throw new IllegalArgumentException(err); 
            }
        }
    }
    public static void main(String[] args){
        int i=0;
        try{
            Calculator calc = new Calculator("X/III");
            String otvet = calc.Calculate();
            System.out.println(calc.arg[0] + Character.toString(calc.operand) + calc.arg[1] );
            System.out.print(calc.result);

            System.out.println("\n"+otvet);
        } catch (IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());
        }
    }
}