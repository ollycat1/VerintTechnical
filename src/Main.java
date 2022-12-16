import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Pages pages = new Pages();
        List<Integer> pageList = pages.getPages(1, 50, 10);
        System.out.print(pageList);
    }
}
