import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main object for game
 */
public class Game {

    Board gameBoard;

    /**
     * Constructor for the game object, initiating new board with the correct pieces
     */
    public Game()
    {
        this.gameBoard = new Board();
    }

    /**
     * The method will check if the first player is having only a knight and a king and return true, otherwise
     * return false
     * @return boolean value of the condition
     */
    private boolean knightPlusKingInFirst()
    {
        ArrayList<Piece> firstPlayerPieces = this.gameBoard.getPlayerPieces(PlayerSpecifier.FIRST);
        if (firstPlayerPieces.size() == 2)
        {
            int countOfKnights = 0;
            int countOfKing = 0;
            for(Piece curPiece : firstPlayerPieces)
            {
                if (curPiece.getClass() == Knight.class)
                {
                    countOfKnights = countOfKnights + 1;
                }
                if (curPiece.getClass() == King.class)
                {
                    countOfKing = countOfKnights + 1;
                }
            }
            return countOfKnights == 1 && countOfKing == 1;
        }
        return false;
    }

    /**
     * The method will check if the second player is having only a knight and a king and return true, otherwise
     * return false
     * @return boolean value of the condition
     */
    private boolean knightPlusKingInSecond()
    {
        ArrayList<Piece> secondPlayerPieces = this.gameBoard.getPlayerPieces(PlayerSpecifier.SECOND);
        if (secondPlayerPieces.size() == 2)
        {
            int countOfKnights = 0;
            int countOfKing = 0;
            for(Piece curPiece : secondPlayerPieces)
            {
                if (curPiece.getClass() == Knight.class)
                {
                    countOfKnights = countOfKnights + 1;
                }
                if (curPiece.getClass() == King.class)
                {
                    countOfKing = countOfKing + 1;
                }
            }
            return countOfKnights == 1 && countOfKing == 1;
        }
        return false;
    }

    /**
     * The method will check if the first player is having only a bishop and a king and return true, otherwise
     * return false
     * @return boolean value of the condition
     */
    private boolean bishopPlusKingInFirst()
    {
        ArrayList<Piece> firstPlayerPieces = this.gameBoard.getPlayerPieces(PlayerSpecifier.FIRST);
        if (firstPlayerPieces.size() == 2)
        {
            int countOfBishops = 0;
            int countOfKing = 0;
            for(Piece curPiece : firstPlayerPieces)
            {
                if (curPiece.getClass() == Bishop.class)
                {
                    countOfBishops = countOfBishops + 1;
                }
                if (curPiece.getClass() == King.class)
                {
                    countOfKing = countOfKing + 1;
                }
            }
            return countOfBishops == 1 && countOfKing == 1;
        }
        return false;
    }

    /**
     * The method will check if the second player is having only a bishop and a king and return true, otherwise
     * return false
     * @return boolean value of the condition
     */
    private boolean bishopPlusKingInSecond()
    {
        ArrayList<Piece> secondPlayerPieces = this.gameBoard.getPlayerPieces(PlayerSpecifier.SECOND);
        if (secondPlayerPieces.size() == 2)
        {
            int countOfBishops = 0;
            int countOfKing = 0;
            for(Piece curPiece : secondPlayerPieces)
            {
                if (curPiece.getClass() == Bishop.class)
                {
                    countOfBishops = countOfBishops + 1;
                }
                if (curPiece.getClass() == King.class)
                {
                    countOfKing = countOfKing + 1;
                }
            }
            return countOfBishops == 1 && countOfKing == 1;
        }
        return false;
    }

    /**
     * The method will check if the first player is having only a king and return true, otherwise
     * return false
     * @return boolean value of the condition
     */
    private boolean onlyKingInFirst()
    {
        ArrayList<Piece> firstPlayerPieces = this.gameBoard.getPlayerPieces(PlayerSpecifier.FIRST);
        if (firstPlayerPieces.size() == 1)
        {
            int countOfKing = 0;
            for(Piece curPiece : firstPlayerPieces)
            {
                if (curPiece.getClass() == King.class)
                {
                    countOfKing = countOfKing + 1;
                }
            }
            return countOfKing == 1;
        }
        return false;
    }

    /**
     * The method will check if the second player is having only a king and return true, otherwise
     * return false
     * @return boolean value of the condition
     */
    private boolean onlyKingInSecond()
    {
        ArrayList<Piece> secondPlayerPieces = this.gameBoard.getPlayerPieces(PlayerSpecifier.SECOND);
        if (secondPlayerPieces.size() == 1)
        {
            int countOfKing = 0;
            for(Piece curPiece : secondPlayerPieces)
            {
                if (curPiece.getClass() == King.class)
                {
                    countOfKing = countOfKing + 1;
                }
            }
            return countOfKing == 1;
        }
        return false;
    }

    /**
     * Main gameplay function
     */
    public void gameRun()
    {
        PlayerSpecifier nowPlayingPlayerNumber = PlayerSpecifier.FIRST;
        boolean isGameOver = false;
        while (!isGameOver)
        {
            this.gameBoard.printBoardWithObjects();
            System.out.println("The " + nowPlayingPlayerNumber + " Player is Playing");
            ArrayList<Piece> currentPiecesArrayList = this.gameBoard.getPlayerPieces(nowPlayingPlayerNumber);
            int possibleMovesInCheck = 0;
            if (gameBoard.isCheck(nowPlayingPlayerNumber))
            {
                System.out.println("Check");
                for(Piece playingPiece : currentPiecesArrayList)
                {
                    ArrayList<Pair> curPiecePossibleMoves = playingPiece.possiblePieceMoves(this.gameBoard);
                    Pair pieceLastLocation = playingPiece.getCurrentLocation();
                    for(Pair curPossibleMove : curPiecePossibleMoves)
                    {
                        Piece newLocationPiece = playingPiece.tempMovePiece(curPossibleMove, this.gameBoard, nowPlayingPlayerNumber);
                        if (gameBoard.isCheck(nowPlayingPlayerNumber))
                        {
                            playingPiece.tempMovePiece(pieceLastLocation, this.gameBoard, nowPlayingPlayerNumber);
                        }
                        else
                        {
                            possibleMovesInCheck = possibleMovesInCheck + 1;
                            playingPiece.tempMovePiece(pieceLastLocation, this.gameBoard, nowPlayingPlayerNumber);
                        }
                        if (newLocationPiece != null)
                        {
                            if (nowPlayingPlayerNumber == PlayerSpecifier.FIRST)
                            {
                                newLocationPiece.tempMovePiece(curPossibleMove, this.gameBoard, PlayerSpecifier.SECOND);
                            }
                            else
                            {
                                newLocationPiece.tempMovePiece(curPossibleMove, this.gameBoard, PlayerSpecifier.FIRST);
                            }
                        }
                    }
                }
                if (possibleMovesInCheck == 0)
                {
                    System.out.println("Its CheckMate!");
                    break;
                }
            }
            boolean isTherePossibleMove = false;
            for (Piece curPiece : currentPiecesArrayList)
            {
                int amountOfPossibleMoves = curPiece.possiblePieceMoves(this.gameBoard).size();
                if (amountOfPossibleMoves != 0)
                {
                    isTherePossibleMove = true;
                }
            }
            if (!isTherePossibleMove)
            {
                System.out.println("Its a Draw!");
                break;
            }
            boolean onlyBishopAndKingInFirst = this.bishopPlusKingInFirst();
            boolean onlyBishopAndKingInSecond = this.bishopPlusKingInSecond();
            boolean onlyKnightAndKingInFirst = this.knightPlusKingInFirst();
            boolean onlyKnightAndKingInSecond = this.knightPlusKingInSecond();
            boolean onlyKingExistInFirst = this.onlyKingInFirst();
            boolean onlyKingExistInSecond = this.onlyKingInSecond();

            if ((onlyBishopAndKingInFirst || onlyKnightAndKingInFirst || onlyKingExistInFirst) &&
            (onlyBishopAndKingInSecond || onlyKnightAndKingInSecond || onlyKingExistInSecond))
            {
                System.out.println("Its a Draw!");
                break;
            }

            Scanner locationScanner = new Scanner(System.in);
            boolean validChoose = false;
            Piece chosenPiece = null;
            while (!validChoose)
            {
                System.out.println("Select X Location Of Your Piece");
                int pieceXLocation = locationScanner.nextInt();
                System.out.println("Select Y Location Of Your Piece");
                int pieceYLocation = locationScanner.nextInt();
                chosenPiece = this.gameBoard.getPieceFromLocation(pieceXLocation, pieceYLocation);
                if (currentPiecesArrayList.contains(chosenPiece))
                {
                    validChoose = true;
                }
                else
                {
                    System.out.println("You Chose Invalid Location, Please Choose Again");
                }
            }
            Pair lastLocation = chosenPiece.getCurrentLocation();
            System.out.println("Select X Location To Move");
            int pieceXMoveLocation = locationScanner.nextInt();
            System.out.println("Select Y Location To Move");
            int pieceYMoveLocation = locationScanner.nextInt();
            boolean isPieceMoved = chosenPiece.movePiece(new Pair(pieceXMoveLocation, pieceYMoveLocation),
                    this.gameBoard, nowPlayingPlayerNumber);
            boolean isStillCheck = false;
            if (this.gameBoard.isCheck(nowPlayingPlayerNumber))
            {
                isStillCheck = true;
                System.out.println("Move is not possible due to ongoing Check!");
                chosenPiece.tempMovePiece(lastLocation, this.gameBoard, nowPlayingPlayerNumber);
            }
            if (nowPlayingPlayerNumber == PlayerSpecifier.FIRST && isPieceMoved && !isStillCheck)
            {
                nowPlayingPlayerNumber = PlayerSpecifier.SECOND;
            }
            else if (nowPlayingPlayerNumber == PlayerSpecifier.SECOND && isPieceMoved && !isStillCheck)
            {
                nowPlayingPlayerNumber = PlayerSpecifier.FIRST;
            }
        }
    }
}
