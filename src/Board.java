public class Board {
    char[][] board;
    char[][] solved;
    String[] words;
    int[][] foundsCord;

    public Board(String[] wordList, char[][] gameBoard){
        this.words = wordList;
        this.board = gameBoard;
        int charCount = 0;
        for(String word : wordList){ charCount+= word.length(); }
        foundsCord = new int[charCount][2];
        solve();
    }

    private void solve(){
        //Cycles through word array
        for(String word : words){
            //Goes through every row
            for(int r = 0; r < board.length; r++){
                //Goes through every column in a row
                for(int c = 0; c < board[r].length; c++){

                    int index = 0;
                    //if first letter of word matches character at coordinates
                    if(word.charAt(0) == board[r][c]) {
                        //finds direction which word goes in
                        for (int i = 0; i < 9; i++) {
                            try {
                                //determineDirection();
                                //System.out.println(((r-1) + (i/3))+ ", " + ((c-1) + (i%3)) + "  " + board[((r-1) + (i/3))][((c-1) + (i%3))] + "  " + word.charAt(1));
                                if (word.charAt(1) == board[((r - 1) + (i / 3))][((c - 1) + (i % 3))]) {
                                    int r2 = ((r - 1) + (i / 3));
                                    int c2 = ((c - 1) + (i % 3));
                                    System.out.println(determineDirection(r, c, ((r - 1) + (i / 3)), ((c - 1) + (i % 3))));
                                    System.out.println(r + " " + c + " " + board[r][c]);
                                    System.out.println(r2 + " " + c2 + " " + board[r2][c2]);

                                    checkDirection(word, r2, c2, 2, determineDirection(r, c, r2, c2));

                                }
                            } catch (ArrayIndexOutOfBoundsException ex) { }
                        }
                    }
                }
            }
        }
    }
    private void checkDirection(String word, int x, int y, int index, String direction){
        if(word.length() != index) {
            try {
                switch (direction) {
                    case "up":
                        if((word.charAt(index) == board[x-1][y])){
                            System.out.println(x-1 +" " + y + " " + board[x-1][y]);
                            checkDirection(word, x - 1, y, index + 1, direction);
                        }
                        break;
                    case "down":
                        if((word.charAt(index) == board[x+1][y])){
                            System.out.println(x+1 +" " + y + " " + board[x+1][y]);
                            checkDirection(word, x + 1, y, index + 1, direction);
                        }
                        break;
                    case "left":
                        if((word.charAt(index) == board[x][y - 1])){
                            System.out.println(x +" " + (y-1));
                            checkDirection(word, x, y - 1, index + 1, direction);
                        }
                        break;
                    case "right":
                        if((word.charAt(index) == board[x][y + 1])){
                            System.out.println(x +" " + (y+1 )+ " " + board[x][y+1]);
                            checkDirection(word, x, y+1, index + 1, direction);
                        }
                        break;
                    case "udleft":
                        if((word.charAt(index) == board[x-1][y-1])){
                            System.out.println(x-1 +" " + (y-1));
                            checkDirection(word, x - 1, y-1, index + 1, direction);
                        }
                        break;
                    case "udright":
                        if((word.charAt(index) == board[x-1][y + 1])){
                            System.out.println(x-1 +" " + (y+1));
                            checkDirection(word, x - 1, y+1, index + 1, direction);
                        }
                        break;
                    case "ddleft":
                        if((word.charAt(index) == board[x+1][y-1])){
                            System.out.println(x+1 +" " + (y-1));
                            checkDirection(word, x +1, y-1, index + 1, direction);
                        }
                        break;
                    case "ddright":
                        if((word.charAt(index) == board[x+1][y+1])){
                            System.out.println(x+1 +" " + (y+1) + " " + board[x+1][y+1]);
                            checkDirection(word, x + 1, y+1, index + 1, direction);
                        }
                }
            } catch (ArrayIndexOutOfBoundsException ex) { }
        }
    }

    /*
    @parameter x1 :: beginning x-coordinate of word
    @parameter y1 :: beginning y-coordinate of word
    @parameter x2 :: x test case for direction
    @parameter y2 :: y test case for direction
     */
    public String determineDirection(int x1, int y1, int x2, int y2){
        // u = "up" d = "down"; d = "down" ; ex. "ddleft" = "down diagonal left"
        if(x1 - x2 == 1 && y1- y2==0){ return "up"; }
        else if(x1 - x2 == -1 && y1- y2 ==0){ return "down"; }
        else if(x1 - x2 == 0 && y1 - y2 == 1){ return "left"; }
        else if(x1- x2 == 0 && y1- y2 == -1){ return "right"; }
        else if(x1 - x2 == 1 && y1 - y2 == 1){ return "udleft"; }
        else if(x1 - x2 == 1 && y1 - y2 == -1){ return "udright"; }
        else if(x1 - x2 == -1 && y1 - y2 == 1){ return "ddleft"; }
        else if(x1 - x2 == -1 && y1 - y2 == -1){ return "ddright"; }
        return "Not a valid test!";
    }
}
