import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Board gameBoard;

    public Game()
    {
        this.gameBoard = new Board();
    }
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
