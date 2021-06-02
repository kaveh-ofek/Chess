import java.util.ArrayList;
import java.util.Scanner;

public class Pawn extends Piece{

    public Pawn(Pair locationToInsert, PlayerSpecifier givenPlayerNumber)
    {
        this.typeOfPiece = PieceType.PAWN;
        this.currentLocation = locationToInsert;
        this.playerNumber = givenPlayerNumber;
    }

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
        if (playerNumber == PlayerSpecifier.FIRST)
        {
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
        }
        return isPieceMoved;
    }
}
