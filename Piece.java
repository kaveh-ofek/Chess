import java.util.*;
public abstract class Piece {
    protected PieceType typeOfPiece;
    protected Pair currentLocation;
    protected PlayerSpecifier playerNumber;

    public abstract ArrayList<Pair> possiblePieceMoves(Board gameBoard);
    public boolean movePiece(Pair newLocation, Board gameBoard, PlayerSpecifier playerNumber)
    {
        boolean isPieceMoved = false;
        ArrayList<Pair> allPossibleMoves = this.possiblePieceMoves(gameBoard);
        for (int i = 0; i < allPossibleMoves.size(); i++)
        {
            if (allPossibleMoves.get(i).isIdenticalPair(newLocation))
            {
                Piece pieceAtLocation = gameBoard.getPieceFromLocation(newLocation);
                if (pieceAtLocation != null)
                {
                    gameBoard.removeFromPieceList(pieceAtLocation, playerNumber);
                }
                gameBoard.putNull(this.currentLocation);
                gameBoard.putPiece(newLocation, this, playerNumber);
                isPieceMoved = true;
                this.currentLocation = newLocation;
                break;
            }
        }
        return isPieceMoved;
    }
    public void tempMovePiece(Pair newLocation, Board gameBoard, PlayerSpecifier playerNumber)
    {
        gameBoard.putNull(this.currentLocation);
        gameBoard.putPiece(newLocation, this, playerNumber);
        this.currentLocation = newLocation;
    }
    public Pair getCurrentLocation()
    {
        return this.currentLocation;
    }
    public PlayerSpecifier getPlayerNumber()
    {
        return this.playerNumber;
    }

}
