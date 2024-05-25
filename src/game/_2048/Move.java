package game._2048;

public class Move {
    private Block[][] blocks;
    private int score;
    private GameBoard gameBoard;
    private boolean checkLine;

    public Move( Block[][] blocks , GameBoard gameBoard ){
        this.blocks = blocks;
        this.gameBoard = gameBoard;
        this.score = gameBoard.getScore();
        this.checkLine = false;
    }

    public void up(){
        moveUp();
    }

    public void down(){
        moveDown();
    }

    public void left(){
        moveLeft();
    }

    public void right(){
        moveRight();
    }

    public boolean getCheck(){
        return checkLine;
    }

    private void moveUp(){
        checkLine = false;
        for( int j = 0 ; j<4 ; j++ ){
            int mergeLine[] = new int[4];
            int originalLine[] = new int[4];
            int index = 0;

            for( int i = 0 ; i<4 ; i++ ){
                if( blocks[i][j].getValue() > 0 ){
                    mergeLine[index] = blocks[i][j].getValue();
                    index ++ ;
                }
                originalLine[i] = blocks[i][j].getValue();
            }

            mergeLine = merge(mergeLine);
            checkMergeLine( mergeLine , originalLine );

            index = 0;
            for( int i = 0 ; i<4 ; i++ ){
                if( mergeLine[i]>0 ){
                    blocks[index][j].setValue(mergeLine[i]);
                    index ++ ;
                }
            }
            while( index < 4 ){
                blocks[index][j].setValue(0);
                index ++ ;
            }
            
        }
    }

    private void moveDown(){
        checkLine = false;
        for( int j = 0 ; j<4 ; j++ ){
            int mergeLine[] = new int[4];
            int originalLine[] = new int[4];
            int index = 0;

            for( int i = 3 ; i>=0 ; i-- ){
                if( blocks[i][j].getValue() > 0 ){
                    mergeLine[index] = blocks[i][j].getValue();
                    index ++ ;
                }
                originalLine[3-i] = blocks[i][j].getValue();
            }

            mergeLine = merge(mergeLine);
            checkMergeLine( mergeLine , originalLine );

            index = 3;
            for( int i = 0 ; i<4 ; i++ ){
                if( mergeLine[i]>0 ){
                    blocks[index][j].setValue(mergeLine[i]);
                    index -- ;
                }
            }
            while( index >= 0 ){
                blocks[index][j].setValue(0);
                index -- ;
            }
            
        }
    }

    private void moveLeft(){
        checkLine = false;
        for( int i = 0 ; i<4 ; i++ ){
            int mergeLine[] = new int[4];
            int originalLine[] = new int[4];
            int index = 0;

            for( int j = 0 ; j<4 ; j++ ){
                if( blocks[i][j].getValue() > 0 ){
                    mergeLine[index] = blocks[i][j].getValue();
                    index ++ ;
                }
                originalLine[j] = blocks[i][j].getValue();
            }
            
            mergeLine = merge(mergeLine);
            checkMergeLine( mergeLine , originalLine );

            index = 0;
            for( int j = 0 ; j<4 ; j++ ){
                if( mergeLine[j]>0 ){
                    blocks[i][index].setValue(mergeLine[j]);
                    index ++ ;
                }
            }
            while( index < 4 ){
                blocks[i][index].setValue(0);
                index ++ ;
            }
            
        }
    }

    private void moveRight(){
        checkLine = false;
        for( int i = 0 ; i<4 ; i++ ){
            int mergeLine[] = new int[4];
            int originalLine[] = new int[4];
            int index = 0;

            for( int j = 3 ; j>=0 ; j-- ){
                if( blocks[i][j].getValue() > 0 ){
                    mergeLine[index] = blocks[i][j].getValue();
                    index ++ ;
                }
                originalLine[3-j] = blocks[i][j].getValue();
            }
            
            mergeLine = merge(mergeLine);
            checkMergeLine( mergeLine , originalLine );

            index = 3;
            for( int j = 0 ; j<4 ; j++ ){
                if( mergeLine[j]>0 ){
                    blocks[i][index].setValue(mergeLine[j]);
                    index -- ;
                }
            }
            while( index >= 0 ){
                blocks[i][index].setValue(0);
                index -- ;
            }
            
        }
    }

    private int[] merge( int[] tmp ){
        for( int i = 0 ; i<3 ; i++ ){
            if( tmp[i] > 0 && tmp[i] == tmp[i+1] ){
                tmp[i] *= 2;
                score += tmp[i];
                tmp[i+1] = 0;
            }
            for( int k = i ; k>0 ; k-- ){
                if( tmp[k] > 0 && tmp[k] == tmp[k-1] ){
                    tmp[k-1] *=2 ;
                    score += tmp[k-1];
                    tmp[k] = 0;
                }
            }
        }
        gameBoard.setScore(score);
        return tmp;
    }

    private void checkMergeLine( int[] mergeLine , int[] originalLine){
        for( int i=0 ; i<4 ; i++ ){
            if( mergeLine[i] != originalLine[i] ){
                checkLine = true;
                break;
            }
        }
    }
}
