import java.util.Arrays;

public class Board {
    char[][] board;
    char[][] solved;
    String[] words;
    int[][] foundCords;
    int[][] tempCords;
    int tempIndex;

    public Board(String[] wordList, char[][] gameBoard){
        this.words = wordList;
        this.board = gameBoard;
        foundCords = new int[0][2];
        solve();
        printBoard(solved);
    }

    private void solve(){
        //Cycles through word array, gets coordinates to highlight
        for(String word : words){
            //Goes through every row
            for(int r = 0; r < board.length; r++){
                //Goes through every column in a row
                for(int c = 0; c < board[r].length; c++){
                    //if first letter of word matches character at coordinates
                    if(word.charAt(0) == board[r][c]) {
                        //finds direction which word goes in, identifies location of second character
                        for (int i = 0; i < 9; i++) {
                            try {
                                if (word.charAt(1) == board[((r - 1) + (i / 3))][((c - 1) + (i % 3))]) {
                                    int r2 = ((r - 1) + (i / 3));
                                    int c2 = ((c - 1) + (i % 3));
                                    tempIndex = 2;
                                    tempCords = new int[word.length()][2];
                                    tempCords[0][0] = r;
                                    tempCords[0][1] = c;
                                    tempCords[1][0] = r2;
                                    tempCords[1][1] = c2;

                                    checkDirection(word, r, c, r2, c2, 2, determineDirection(r, c, r2, c2));
                                }
                            } catch (ArrayIndexOutOfBoundsException ex) { }
                        }
                    }
                }
            }
        }
        solved = board;
        for(int i = 0; i < foundCords.length; i++){
            solved[foundCords[i][0]][foundCords[i][1]] = Character.toUpperCase(solved[foundCords[i][0]][foundCords[i][1]]);
        }


        //printBoard(foundCords);
    }
    private boolean checkDirection(String word, int orX, int orY,int x, int y, int index, String direction){
        if(word.length() != index) {
            try {
                switch (direction) {
                    case "up":
                        if((word.charAt(index) == board[x-1][y])){
                            tempCords[tempIndex][0] = x-1;
                            tempCords[tempIndex][1] = y;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x - 1, y, index + 1, direction);
                        }
                        break;
                    case "down":
                        if((word.charAt(index) == board[x+1][y])){
                            tempCords[tempIndex][0] = x+1;
                            tempCords[tempIndex][1] = y;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x + 1, y, index + 1, direction);
                        }
                        break;
                    case "left":
                        if((word.charAt(index) == board[x][y - 1])){
                            tempCords[tempIndex][0] = x;
                            tempCords[tempIndex][1] = y-1;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x, y - 1, index + 1, direction);
                        }
                        break;
                    case "right":
                        if((word.charAt(index) == board[x][y + 1])){
                            tempCords[tempIndex][0] = x;
                            tempCords[tempIndex][1] = y+1;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x, y+1, index + 1, direction);
                        }
                        break;
                    case "udleft":
                        if((word.charAt(index) == board[x-1][y-1])){
                            tempCords[tempIndex][0] = x-1;
                            tempCords[tempIndex][1] = y-1;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x - 1, y-1, index + 1, direction);
                        }
                        break;
                    case "udright":
                        if((word.charAt(index) == board[x-1][y + 1])){
                            tempCords[tempIndex][0] = x-1;
                            tempCords[tempIndex][1] = y+1;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x - 1, y+1, index + 1, direction);
                        }
                        break;
                    case "ddleft":
                        if((word.charAt(index) == board[x+1][y-1])){
                            tempCords[tempIndex][0] = x+1;
                            tempCords[tempIndex][1] = y-1;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x +1, y-1, index + 1, direction);
                        }
                        break;
                    case "ddright":
                        if((word.charAt(index) == board[x+1][y+1])){
                            tempCords[tempIndex][0] = x+1;
                            tempCords[tempIndex][1] = y+1;
                            this.tempIndex += 1;
                            checkDirection(word, orX, orY, x + 1, y+1, index + 1, direction);
                        }
                }
            } catch (ArrayIndexOutOfBoundsException ex) { }
        }
        else if(word.length() == index){
            foundCords = append(foundCords, tempCords);
            return true;
        }
        return false;
    }

    public static int[][] append(int[][] a, int[][] b) {
        int[][] result = new int[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
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
        return "";
    }

    private void printBoard(char[][] board){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
