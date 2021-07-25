import java.util.ArrayList;

/**
 * sub-class for the knight piece
 */
public class Knight extends Piece{

    /**
     * constructor for the knight object based on the location of the piece and the player's number
     * @param locationToInsert tuple of x and y spots
     * @param givenPlayerNumber enum which is the player's side
     */
    public Knight(Pair locationToInsert, PlayerSpecifier givenPlayerNumber)
    {
        this.typeOfPiece = PieceType.KNIGHT;
        this.currentLocation = locationToInsert;
        this.playerNumber = givenPlayerNumber;
    }

    /**
     * override method which calculates the possible moves of the knight piece according to the current
     * state of the game
     * @param gameBoard board object which includes the game board set up
     * @return array list of all the possible moves
     */
    @Override
    public ArrayList<Pair> possiblePieceMoves(Board gameBoard)
    {
        ArrayList<Pair> listOfAllPossibleMoves = new ArrayList<>();
        int leftCoordinate = this.currentLocation.getLeft();
        int rightCoordinate = this.currentLocation.getRight();

        if ((leftCoordinate + 2 <= 7) && (rightCoordinate + 1 <= 7))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 2, rightCoordinate + 1));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 2, rightCoordinate + 1));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 2, rightCoordinate + 1));
                }
            }
        }

        if ((leftCoordinate + 2 <= 7) && (rightCoordinate - 1 >= 0))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 2, rightCoordinate - 1));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 2, rightCoordinate - 1));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 2, rightCoordinate - 1));
                }
            }
        }

        if ((leftCoordinate - 2 >= 0) && (rightCoordinate + 1 <= 7))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 2, rightCoordinate + 1));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 2, rightCoordinate + 1));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 2, rightCoordinate + 1));
                }
            }
        }

        if ((leftCoordinate - 2 >= 0) && (rightCoordinate - 1 >= 0))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 2, rightCoordinate - 1));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 2, rightCoordinate - 1));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 2, rightCoordinate - 1));
                }
            }
        }

        if ((leftCoordinate + 1 <= 7) && (rightCoordinate - 2 >= 0))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1, rightCoordinate - 2));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate - 2));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate - 2));
                }
            }
        }

        if ((leftCoordinate - 1 >= 0) && (rightCoordinate - 2 >= 0))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1, rightCoordinate - 2));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate - 2));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate - 2));
                }
            }
        }

        if ((leftCoordinate + 1 <= 7) && (rightCoordinate + 2 <= 7))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1, rightCoordinate + 2));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate + 2));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate + 2));
                }
            }
        }

        if ((leftCoordinate - 1 >= 0) && (rightCoordinate + 2 <= 7))
        {
            Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1, rightCoordinate + 2));
            if (locationCheck == null)
            {
                listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate + 2));
            }
            else
            {
                if (locationCheck.getPlayerNumber() != this.playerNumber)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate + 2));
                }
            }
        }

        return listOfAllPossibleMoves;
    }
}
