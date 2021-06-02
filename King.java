import java.util.*;

public class King extends Piece{

    public King(Pair locationToInsert, PlayerSpecifier givenPlayerNumber)
    {
        this.typeOfPiece = PieceType.KING;
        this.currentLocation = locationToInsert;
        this.playerNumber = givenPlayerNumber;
    }

    @Override
    public ArrayList<Pair> possiblePieceMoves(Board gameBoard)
    {
        ArrayList<Pair> listOfAllPossibleMoves = new ArrayList<>();
        int leftCoordinate = this.currentLocation.getLeft();
        int rightCoordinate = this.currentLocation.getRight();
        ArrayList<Integer> possibleLeftRightMoves = new ArrayList<>();
        possibleLeftRightMoves.add(rightCoordinate);
        ArrayList<Integer> possibleUpDownMoves = new ArrayList<>();
        possibleUpDownMoves.add(leftCoordinate);
        if (leftCoordinate -1 >= 0)
        {
            possibleUpDownMoves.add(leftCoordinate - 1);
        }
        if (leftCoordinate + 1 <= 7)
        {
            possibleUpDownMoves.add(leftCoordinate + 1);
        }
        if (rightCoordinate -1 >= 0)
        {
            possibleLeftRightMoves.add(rightCoordinate - 1);
        }
        if (rightCoordinate + 1 <= 7)
        {
            possibleLeftRightMoves.add(rightCoordinate + 1);
        }

        for (int leftRightMove : possibleLeftRightMoves)
        {
            for (int upDownMove : possibleUpDownMoves)
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(upDownMove, leftRightMove));
                if (locationCheck == null)
                {
                    listOfAllPossibleMoves.add(new Pair(upDownMove, leftRightMove));
                }
                else
                {
                    if (this.playerNumber != locationCheck.getPlayerNumber())
                    {
                        listOfAllPossibleMoves.add(new Pair(upDownMove, leftRightMove));
                    }
                }
            }
        }
        return listOfAllPossibleMoves;
    }

}
