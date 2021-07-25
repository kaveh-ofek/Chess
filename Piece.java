import java.util.*;

/**
 * abstract class for the general piece object
 */
public abstract class Piece {
    protected PieceType typeOfPiece;
    protected Pair currentLocation;
    protected PlayerSpecifier playerNumber;

    /**
     * The method which calculates the possible moves of the piece according to the current
     * state of the game
     * @param gameBoard board object which includes the game board set up
     * @return array list of all the possible moves
     */
    public abstract ArrayList<Pair> possiblePieceMoves(Board gameBoard);

    /**
     * override method that implements the movement mechanics the pieces (but pawn)
     * @param newLocation location to move
     * @param gameBoard board object which includes the game board set up
     * @param playerNumber enum which is the player's side
     * @return true if the piece moved successfully, false otherwise
     */
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

    /**
     * The method will move a piece to a new location, saving the piece on the wanted spot.
     * @param newLocation location to move
     * @param gameBoard board object which includes the game board set up
     * @param playerNumber enum which is the player's side
     * @return the piece of the wanted spot or null if theres no piece
     */
    public Piece tempMovePiece(Pair newLocation, Board gameBoard, PlayerSpecifier playerNumber)
    {
        Piece newLocationPiece = gameBoard.getPieceFromLocation(newLocation);
        gameBoard.putNull(this.currentLocation);
        gameBoard.putPiece(newLocation, this, playerNumber);
        this.currentLocation = newLocation;

        return newLocationPiece;
    }

    /**
     * The method will return the location of the current piece object
     * @return location as Pair
     */
    public Pair getCurrentLocation()
    {
        return this.currentLocation;
    }

    /**
     * The method will return the owner of the current piece object
     * @return player recognizer
     */
    public PlayerSpecifier getPlayerNumber()
    {
        return this.playerNumber;
    }

}
