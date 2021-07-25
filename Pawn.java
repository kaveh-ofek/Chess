import java.util.ArrayList;
import java.util.Scanner;

/**
 * sub-class for the pawn piece
 */
public class Pawn extends Piece{

    /**
     * constructor for the pawn object based on the location of the piece and the player's number
     * @param locationToInsert tuple of x and y spots
     * @param givenPlayerNumber enum which is the player's side
     */
    public Pawn(Pair locationToInsert, PlayerSpecifier givenPlayerNumber)
    {
        this.typeOfPiece = PieceType.PAWN;
        this.currentLocation = locationToInsert;
        this.playerNumber = givenPlayerNumber;
    }

    /**
     * override method which calculates the possible moves of the pawn piece according to the current
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

        if (this.playerNumber == PlayerSpecifier.FIRST)
        {
            if (leftCoordinate == 6)
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 2, rightCoordinate));
                if (locationCheck == null)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 2, rightCoordinate));
                }
            }
            if ((leftCoordinate - 1 >= 0) && (rightCoordinate + 1 <= 7))
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1, rightCoordinate + 1));
                if (locationCheck != null)
                {
                    if (locationCheck.getPlayerNumber() != this.getPlayerNumber())
                    {
                        listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate + 1));
                    }
                }
            }
            if ((leftCoordinate - 1 >= 0) && (rightCoordinate - 1 >= 0))
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1, rightCoordinate - 1));
                if (locationCheck != null)
                {
                    if (locationCheck.getPlayerNumber() != this.getPlayerNumber())
                    {
                        listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate - 1));
                    }
                }
            }
            if (leftCoordinate - 1 >= 0)
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate - 1, rightCoordinate));
                if (locationCheck == null)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate - 1, rightCoordinate));
                }
            }
        }
        else
        {
            if (leftCoordinate == 1)
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 2, rightCoordinate));
                if (locationCheck == null)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 2, rightCoordinate));
                }
            }

            if ((leftCoordinate + 1 >= 0) && (rightCoordinate + 1 <= 7))
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1, rightCoordinate + 1));
                if (locationCheck != null)
                {
                    if (locationCheck.getPlayerNumber() != this.getPlayerNumber())
                    {
                        listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate + 1));
                    }
                }
            }
            if ((leftCoordinate + 1 <= 7) && (rightCoordinate - 1 >= 0))
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1, rightCoordinate - 1));
                if (locationCheck != null)
                {
                    if (locationCheck.getPlayerNumber() != this.getPlayerNumber())
                    {
                        listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate + 1));
                    }
                }
            }
            if (leftCoordinate + 1 >= 0)
            {
                Piece locationCheck = gameBoard.getPieceFromLocation(new Pair(leftCoordinate + 1, rightCoordinate));
                if (locationCheck == null)
                {
                    listOfAllPossibleMoves.add(new Pair(leftCoordinate + 1, rightCoordinate));
                }
            }
        }
        return listOfAllPossibleMoves;
    }

    /**
     * override method that implements the movement mechanics of the pawn piece
     * @param newLocation location to move
     * @param gameBoard board object which includes the game board set up
     * @param playerNumber enum which is the player's side
     * @return true if the piece moved successfully, false otherwise
     */
    @Override
    public boolean movePiece(Pair newLocation, Board gameBoard, PlayerSpecifier playerNumber)
    {
        boolean isPieceMoved = false;
        ArrayList<Pair> allPossibleMoves = this.possiblePieceMoves(gameBoard);
        for (Pair allPossibleMove : allPossibleMoves) {
            if (allPossibleMove.isIdenticalPair(newLocation)) {
                Piece pieceAtLocation = gameBoard.getPieceFromLocation(newLocation);
                if (pieceAtLocation != null) {
                    gameBoard.removeFromPieceList(pieceAtLocation, playerNumber);
                }
                gameBoard.putNull(this.currentLocation);
                gameBoard.putPiece(newLocation, this, playerNumber);
                isPieceMoved = true;
                this.currentLocation = newLocation;
                break;
            }
        }
        Pair pawnLocation = this.currentLocation;
        if (this.currentLocation.getLeft() == 0 || this.currentLocation.getLeft() == 7)
        {
            char newPiece = 'O';
            while (newPiece == 'O')
            {
                System.out.println("Choose new Piece: R-Rook, K-Knight, B-Bishop, Q-Queen");
                Scanner newPieceScanner = new Scanner(System.in);
                newPiece = newPieceScanner.next().charAt(0);
            }
            if (newPiece == 'R')
            {
                gameBoard.removeOldPiece(pawnLocation, this, playerNumber);
                gameBoard.addNewPiece(pawnLocation, new Rook(pawnLocation, playerNumber), playerNumber);
            }
            if (newPiece == 'K')
            {
                gameBoard.removeOldPiece(pawnLocation, this, playerNumber);
                gameBoard.addNewPiece(pawnLocation, new Knight(pawnLocation, playerNumber), playerNumber);
            }
            if (newPiece == 'B')
            {
                gameBoard.removeOldPiece(pawnLocation, this, playerNumber);
                gameBoard.addNewPiece(pawnLocation, new Bishop(pawnLocation, playerNumber), playerNumber);
            }
            if (newPiece == 'Q')
            {
                gameBoard.removeOldPiece(pawnLocation, this, playerNumber);
                gameBoard.addNewPiece(pawnLocation, new Queen(pawnLocation, playerNumber), playerNumber);
            }
        }
        return isPieceMoved;
    }
}
