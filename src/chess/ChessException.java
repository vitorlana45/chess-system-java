package chess;

import boardgame.BoardExceptions;

public class ChessException extends BoardExceptions{
    private static final long serialVersionUID = 1L;

    public ChessException (String msg){
        super(msg);
    }
    
}
