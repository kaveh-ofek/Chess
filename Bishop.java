import java.util.ArrayList;

/**
 * sub-class for the bishop piece
 */
public class Bishop extends Piece{

    /**
     * constructor for the bishop object based on the location of the piece and the player's number
     * @param locationToInsert tuple of x and y spots
     * @param givenPlayerNumber enum which is the player's side
     */
    public Bishop(Pair locationToInsert, PlayerSpecifier givenPlayerNumber)
    {
        this.typeOfPiece = PieceType.BISHOP;
        this.currentLocation = locationToInsert;
        this.playerNumber = givenPlayerNumber;
    }

    /**
     * override method which calculates the possible moves of the bishop piece according to the current
     * state of the game
     * @param gameBoard board object which includes the game board set up
     * @return array list of all the possible moves
     */
    @Override
    public ArrayList<Pair> possiblePieceMoves(Board gameBoard) {
        ArrayList<Pair> listOfAllPossibleMoves = new ArrayList<>();

        // all moves to top left
        int leftCoordinate = this.currentLocation.getLeft();
        int rightCoordinate = this.currentLocation.getRight();
        while ((leftCoordinate - 1 >= 0) && (rightCoordinate - 1 >= 0))
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1,
                    rightCoordinate - 1));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1,
                        rightCoordinate - 1));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1,
                            rightCoordinate - 1));
                }
                break;
            }
            leftCoordinate = leftCoordinate - 1;
            rightCoordinate = rightCoordinate - 1;
        }

        // all moves to bottom left
        leftCoordinate = this.currentLocation.getLeft();
        rightCoordinate = this.currentLocation.getRight();
        while ((leftCoordinate + 1 <= 7) && (rightCoordinate - 1 >= 0))
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1,
                    rightCoordinate - 1));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1,
                        rightCoordinate - 1));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1,
                            rightCoordinate - 1));
                }
                break;
            }
            leftCoordinate = leftCoordinate + 1;
            rightCoordinate = rightCoordinate - 1;
        }

        // all moves to bottom right
        leftCoordinate = this.currentLocation.getLeft();
        rightCoordinate = this.currentLocation.getRight();
        while ((leftCoordinate + 1 <= 7) && (rightCoordinate + 1 <= 7))
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1,
                    rightCoordinate + 1));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1,
                        rightCoordinate + 1));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1,
                            rightCoordinate + 1));
                }
                break;
            }
            leftCoordinate = leftCoordinate + 1;
            rightCoordinate = rightCoordinate + 1;
        }

        // all moves to top right
        leftCoordinate = this.currentLocation.getLeft();
        rightCoordinate = this.currentLocation.getRight();
        while ((leftCoordinate - 1 >= 0) && (rightCoordinate + 1 <= 7))
        {
            Piece nextPiece = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1,
                    rightCoordinate + 1));
            if (nextPiece == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1,
                        rightCoordinate + 1));
            }
            else
            {
                if (nextPiece.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1,
                            rightCoordinate + 1));
                }
                break;
            }
            leftCoordinate = leftCoordinate - 1;
            rightCoordinate = rightCoordinate + 1;
        }


        return listOfAllPossibleMoves;
    }
}
