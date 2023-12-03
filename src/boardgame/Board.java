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
            throw new BoardExceptions("Posição não existente no tabuleiro");
        }
            return pieces[row][column];
    }

    public Piece piece(Position position){
          if(!positionExists(position)){
            throw new BoardExceptions("Posição não existente no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    
    public void PlacePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardExceptions("Já existe uma peça nesta posição");
        }
        pieces[position.getRow()] [ position.getColumn()] = piece;
        piece.position = position;
    }
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;

    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());

    }
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptions("Já existe uma peça nesta posição");
        }
        return piece(position) != null;
    }
}
