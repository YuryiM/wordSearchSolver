public class Board {
    char[][] board;
    char[][] solved;
    String[] words;

    public Board(String[] wordList, char[][] gameBoard){
        this.words = wordList;
        this.board = gameBoard;
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
                    if(word.charAt(0) == board[r][c]){
                        //finds direction which word goes in
                        for(int i = 0; i < 9; i++){
                            try{
                                //System.out.println(((r-1) + (i/3))+ ", " + ((c-1) + (i%3)) + "  " + board[((r-1) + (i/3))][((c-1) + (i%3))] + "  " + word.charAt(1));
                                if(word.charAt(1) == board[((r-1) + (i/3))][((c-1) + (i%3))]){
                                    checkDirection(word, );
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException ex){
                            }
                        }

                    }



                }
            }
        }

    }

    private void checkDirection(String word, int xToAdd, int yToAdd, int x, int y, int index){
        try{
            if((word.charAt(index) == board[(x-1) + xToAdd][(y-1) + yToAdd]) && (word.length()-1 != index)){
                System.out.println((x-1) + xToAdd + ", " + (y-1) + yToAdd);
                checkWord(word, xToAdd, yToAdd, x, y, index+1);
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){

        }
    }

}
