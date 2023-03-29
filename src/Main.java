import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List operatorList = new ArrayList<>();
    static void checkLogin(HashMap hashMap, String login){
        if (!hashMap.containsKey(login)){
            throw new InvalidArgumentException("Неверный логин");
        }

    }
    static void checkAuthentication(HashMap hashMap, String login, String pswrd){
        if (!hashMap.get(login).equals(pswrd)){
            throw new InvalidArgumentException("Неверный логин или пароль");
        }
    }

    static void checkOperation(String operator){
        if(!operatorList.contains(operator)){
            throw new InvalidArgumentException("Неправильный оператор");
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap userMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        userMap.put("akzhol", "123");
        userMap.put("marsbekov", "qwe");
        userMap.put("amarsbekov", "qwert");

        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("*");
        operatorList.add("/");

        System.out.println("Введите логин:");
        String login = scanner.next();
        checkLogin(userMap, login);
        System.out.println("Введите пароль:");
        String pswrd = scanner.next();
        checkAuthentication(userMap, login, pswrd);


            for (int i = 0; i < 3; i++) {

                System.out.println("Введите первое число: ");
                int a = scanner.nextInt();
                System.out.println("Введите второе число: ");
                int b = scanner.nextInt();
                System.out.println("Введите арифмитеческий оператор: ");
                String o = scanner.next();
                try {
                    checkOperation(o);
                } catch (InvalidArgumentException e){
                    e.printStackTrace();
                }




                String c = a + " " + o + " " + b;
                System.out.println(c);

                if (hashMap.containsKey(c)) {
                    System.out.println(c + " = " + hashMap.get(c) + " Взято из HashMap");

                }
                else {
                    if (o.equals("+")) {
                        hashMap.put(c, a + b);
                        System.out.println(c + " = " + hashMap.get(c));
                    }
                    else if (o.equals("-")) {hashMap.put(c, a - b);
                        System.out.println(c + " = " + hashMap.get(c));

                    }
                    else if (o.equals("*")) {
                        hashMap.put(c, a * b);
                        System.out.println(c + " = " + hashMap.get(c));
                    }
                    else if (o.equals("/")) {
                        hashMap.put(c, a / b);
                        System.out.println(c + " = " + hashMap.get(c));
                    }

                }
            }
        System.out.println(hashMap.toString());

    }
}