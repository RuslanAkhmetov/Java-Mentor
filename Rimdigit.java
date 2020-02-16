import java.util.HashMap;
import java.util.Map;

class Rimdigit{
    private final static String[] rimarr = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII","IX","X"};
    private static Map <String, Integer> rimmap = new HashMap<String, Integer>(){{
        put("I", 1); 
        put("II", 2); 
        put("III", 3); 
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};
        
    public static String GetRimN(int arabdigit) {
        if (arabdigit <1 || arabdigit > 10){
            throw new IllegalArgumentException("Number " + arabdigit + " is incorrect more than 10 or less 1");
        } else {
            return rimarr[arabdigit];
        }
    }

    public static int GetArabN(String s){
        if (rimmap.containsKey(s)){
            return rimmap.get(s);
        } else{
            throw new IllegalArgumentException("String " + s + " is incorrect more than 10");
        }
    }

    public static boolean IsArab(String str) {
        int digitsys=0;                                // 0-not defined, 1 - arab, 2- rim
        char[] ch = str.toCharArray();
        int i=0, j=0, n=0;
        for (i=0;i<ch.length; i++){
            switch (ch[i]){
                case '*':
                case '/':
                case '+':
                case '-':
                    break;
                default:
                    if (Character.isDigit(ch[i])){
                        if  (digitsys==0 || digitsys==1 ){
                            digitsys = 1;
                        } else {
                            throw new IllegalArgumentException("String " + str + " contans arab and rim numbers");
                        }
                    } 

                    if (Character.isLetter(ch[i])) {
                        if  (rimmap.containsKey(Character.toString( ch[i])) && (digitsys==0 || digitsys==2 ) ){
                                digitsys=2;
                        } else{
                            throw new IllegalArgumentException("String " + str + " contans arab and rim numbers or illegial character " + ch[i]);
                        }
                    }  
            }
        }
        return digitsys==1 ? true: false; 
    }


    public static void main(String[] args){
        int i=0;
        try{
                /*for (i=1; i <11; i++){
                    System.out.println(GetRimN(i));
                }*/
                System.out.println(IsArab("II+D"));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        

    }
}