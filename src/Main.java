import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Enter the file name to Read dataset with extension: ");
        String fileName = new Scanner(System.in).next();
        Menu menu = new Menu(fileName);
        menu.menu();
    }
}