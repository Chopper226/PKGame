package game._2048;

public class Move {
    private Block[][] blocks;
    private int score;

    public Move( Block[][] blocks , int score ){
        this.blocks = blocks;
        this.score = score;
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

    private void moveUp(){
        for( int j = 0 ; j<4 ; j++ ){
            int tmp[] = new int[4];
            int index = 0;
            for( int i = 0 ; i<4 ; i++ ){
                if( blocks[i][j].getValue() > 0 ){
                    tmp[index] = blocks[i][j].getValue();
                    index ++ ;
                }
            }
            tmp = merge(tmp);
            index = 0;
            for( int i = 0 ; i<4 ; i++ ){
                if( tmp[i]>0 ){
                    blocks[index][j].setValue(tmp[i]);
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
        for( int j = 0 ; j<4 ; j++ ){
            int tmp[] = new int[4];
            int index = 0;
            for( int i = 3 ; i>=0 ; i-- ){
                if( blocks[i][j].getValue() > 0 ){
                    tmp[index] = blocks[i][j].getValue();
                    index ++ ;
                }
            }
            tmp = merge(tmp);
            index = 3;
            for( int i = 0 ; i<4 ; i++ ){
                if( tmp[i]>0 ){
                    blocks[index][j].setValue(tmp[i]);
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
        for( int i = 0 ; i<4 ; i++ ){
            int tmp[] = new int[4];
            int index = 0;
            for( int j = 0 ; j<4 ; j++ ){
                if( blocks[i][j].getValue() > 0 ){
                    tmp[index] = blocks[i][j].getValue();
                    index ++ ;
                }
            }
            tmp = merge(tmp);
            index = 0;
            for( int j = 0 ; j<4 ; j++ ){
                if( tmp[j]>0 ){
                    blocks[i][index].setValue(tmp[j]);
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
        for( int i = 0 ; i<4 ; i++ ){
            int tmp[] = new int[4];
            int index = 0;
            for( int j = 3 ; j>=0 ; j-- ){
                if( blocks[i][j].getValue() > 0 ){
                    tmp[index] = blocks[i][j].getValue();
                    index ++ ;
                }
            }
            tmp = merge(tmp);
            index = 3;
            for( int j = 0 ; j<4 ; j++ ){
                if( tmp[j]>0 ){
                    blocks[i][index].setValue(tmp[j]);
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
        return tmp ;
    }
}
