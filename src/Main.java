import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        char[][] board1 = {{'x','v','e','r','t','i','c','a','l','l'},
                           {'r','o','o','a','f','f','l','s','a','b'},
                           {'a','c','r','i','l','i','a','t','o','a'},
                           {'n','d','o','d','k','o','n','x','d','c'},
                           {'d','r','k','e','s','o','o','d','d','k'},
                           {'o','e','e','p','z','e','g','l','i','w'},
                           {'m','s','i','i','h','o','a','e','r','a'},
                           {'a','l','r','k','r','r','i','r','e','r'},
                           {'k','o','d','i','d','e','d','r','c','d'},
                           {'h','e','l','w','s','l','e','u','t','h'}};
        /*
        char[][] board1 = {{'w','v','e','r','t','i','c','a','l','l'},
                {'r','o','o','a','f','f','l','s','a','b'},
                {'a','c','r','i','l','i','a','t','o','a'},
                {'n','d','o','d','k','o','n','w','d','c'},
                {'d','r','k','e','s','o','o','d','d','k'},
                {'o','e','e','p','z','e','g','l','i','w'},
                {'m','s','i','i','h','o','a','e','r','a'},
                {'a','l','r','k','r','r','i','r','e','r'},
                {'k','o','d','i','d','e','d','r','c','d'},
                {'h','e','l','w','s','l','e','u','t','h'}};*/
        String[] words = {"wikipedia"};//, "find", "random", "sleuth", "backward", "vertical", "diagonal", "wikipedia", "horizontal", "word search"};//keyboard.next().split(",");
        Board testBoard1 = new Board(words, board1);
    }
}
