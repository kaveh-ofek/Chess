import java.util.ArrayList;

/**
 * sub-class for the rook piece
 */
public class Rook extends Piece{

    /**
     * constructor for the rook object based on the location of the piece and the player's number
     * @param locationToInsert tuple of x and y spots
     * @param givenPlayerNumber enum which is the player's side
     */
    public Rook(Pair locationToInsert, PlayerSpecifier givenPlayerNumber)
    {
        this.typeOfPiece = PieceType.ROOK;
        this.currentLocation = locationToInsert;
        this.playerNumber = givenPlayerNumber;
    }

    /**
     * override method which calculates the possible moves of the rook piece according to the current
     * state of the game
     * @param gameBoard board object which includes the game board set up
     * @return array list of all the possible moves
     */
    @Override
    public ArrayList<Pair> possiblePieceMoves(Board gameBoard)
    {
        ArrayList<Pair> listOfAllPossibleMoves = new ArrayList<>();

        // all moves to top
        int leftCoordinate = this.currentLocation.getLeft();
        int rightCoordinate = this.currentLocation.getRight();
        while (leftCoordinate - 1 >= 0)
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1,
                    rightCoordinate));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1,
                        rightCoordinate));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1,
                            rightCoordinate));
                }
                break;
            }
            leftCoordinate = leftCoordinate - 1;
        }

        // all moves to left
        leftCoordinate = this.currentLocation.getLeft();
        rightCoordinate = this.currentLocation.getRight();
        while (rightCoordinate - 1 >= 0)
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate,
                    rightCoordinate - 1));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate,
                        rightCoordinate - 1));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate,
                            rightCoordinate - 1));
                }
                break;
            }
            rightCoordinate = rightCoordinate - 1;
        }

        // all moves to right
        leftCoordinate = this.currentLocation.getLeft();
        rightCoordinate = this.currentLocation.getRight();
        while (rightCoordinate + 1 <= 7)
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate,
                    rightCoordinate + 1));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate,
                        rightCoordinate + 1));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate,
                            rightCoordinate + 1));
                }
                break;
            }
            rightCoordinate = rightCoordinate + 1;
        }

        // all moves to bottom
        leftCoordinate = this.currentLocation.getLeft();
        rightCoordinate = this.currentLocation.getRight();
        while (leftCoordinate + 1 <= 7)
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1,
                    rightCoordinate));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1,
                        rightCoordinate));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1,
                            rightCoordinate));
                }
                break;
            }
            leftCoordinate = leftCoordinate + 1;
        }


        return listOfAllPossibleMoves;
    }
}
