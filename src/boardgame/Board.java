package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardExceptions("Erro Criando Tabuleiro: e necessario que haja ao menos 1 linha e 1 Coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
         if(!positionExists(row, column)){
            throw new BoardExceptions("Está Posicao nao existente no tabuleiro");
        }
            return pieces[row][column];
    }

    public Piece piece(Position position){
          if(!positionExists(position)){
            throw new BoardExceptions("Posicao nao existente no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    
    public void PlacePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardExceptions("Ja existe uma peca nesta posicao");
        }
        pieces[position.getRow()] [ position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptions("Esta Posiçao nao existente no tabuleiro");
        }
        if (piece(position) ==  null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }
   

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;

    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());

    }
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptions("Ja existe uma peça nesta posicao");
        }
        return piece(position) != null;
    }
}
