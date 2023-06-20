package lambdaExpressions;

public class Lambda_parameter {
    public static void main(String[] args) {
        Printable p = (s) -> s+ " chakri";
        Printable q = (s) -> s + " Reddy";

        printFormatted("hellow",p);
        printFormatted("Namaste",q);
    }

    public static void printFormatted(String s, Printable str){
        String result = str.run(s);
        System.out.println(result);
    }



}
