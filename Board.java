import java.util.*;

/**
 * The board class will contain the current state of pieces in the board
 */
public class Board {
    private final Piece[][] gameBoard;
    private final ArrayList<Piece> firstPlayerPieces;
    private final ArrayList<Piece> secondPlayerPieces;
    public static int counter;

    /**
     * Simple constructor for a board initiated with pieces
     */
    public Board()
    {
        this.gameBoard = new Piece[8][8];
        this.firstPlayerPieces = new ArrayList<>();
        this.secondPlayerPieces = new ArrayList<>();
        counter = 0;

        fillWithNulls();

        firstPlayerPieceInit();
        secondPlayerPieceInit();

        //firstPlayerOnlyPawnInit();
        //secondPlayerOnlyPawnInit();

    }

    /**
     * The method will put nulls in the board as an empty place sign
     */
    private void fillWithNulls()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                this.gameBoard[i][j] = null;
            }
        }
    }

    /**
     * used for debug - initiate the board with a single pawn and a king for first player
     */
    private void firstPlayerOnlyPawnInit()
    {
        Pawn newPawn = new Pawn(new Pair(6, 4), PlayerSpecifier.FIRST);
        this.gameBoard[6][4] = newPawn;
        this.firstPlayerPieces.add(newPawn);

        King player1King = new King(new Pair(7, 4), PlayerSpecifier.FIRST);
        this.gameBoard[7][4] = player1King;
        this.firstPlayerPieces.add(player1King);
    }

    /**
     * used for debug - initiate the board with a single pawn and a king for first player
     */
    private void secondPlayerOnlyPawnInit()
    {
        Pawn newPawn = new Pawn(new Pair(1, 3), PlayerSpecifier.SECOND);
        this.gameBoard[1][3] = newPawn;
        this.secondPlayerPieces.add(newPawn);

        King player2King = new King(new Pair(0, 4), PlayerSpecifier.SECOND);
        this.gameBoard[0][4] = player2King;
        this.secondPlayerPieces.add(player2King);
    }

    /**
     * The method will initiate the starting position for the black pieces
     */
    private void secondPlayerPieceInit()
    {
        for(int i = 0; i < 8; i++)
        {
            Pawn newPawn = new Pawn(new Pair(1, i), PlayerSpecifier.SECOND);
            this.gameBoard[1][i] = newPawn;
            this.secondPlayerPieces.add(newPawn);
        }

        Rook player2LeftRook = new Rook(new Pair(0, 0), PlayerSpecifier.SECOND);
        Rook player2RightRook = new Rook(new Pair(0, 7), PlayerSpecifier.SECOND);
        this.gameBoard[0][0] = player2LeftRook;
        this.gameBoard[0][7] = player2RightRook;
        this.secondPlayerPieces.add(player2LeftRook);
        this.secondPlayerPieces.add(player2RightRook);

        Knight player2LeftKnight = new Knight(new Pair(0, 1), PlayerSpecifier.SECOND);
        Knight player2RightKnight = new Knight(new Pair(0, 6), PlayerSpecifier.SECOND);
        this.gameBoard[0][1] = player2LeftKnight;
        this.gameBoard[0][6] = player2RightKnight;
        this.secondPlayerPieces.add(player2LeftKnight);
        this.secondPlayerPieces.add(player2RightKnight);

        Bishop player2LeftBishop = new Bishop(new Pair(0, 2), PlayerSpecifier.SECOND);
        Bishop player2RightBishop = new Bishop(new Pair(0, 5), PlayerSpecifier.SECOND);
        this.gameBoard[0][2] = player2LeftBishop;
        this.gameBoard[0][5] = player2RightBishop;
        this.secondPlayerPieces.add(player2LeftBishop);
        this.secondPlayerPieces.add(player2RightBishop);

        King player2King = new King(new Pair(0, 4), PlayerSpecifier.SECOND);
        this.gameBoard[0][4] = player2King;
        this.secondPlayerPieces.add(player2King);

        Queen player2Queen = new Queen(new Pair(0, 3), PlayerSpecifier.SECOND);
        this.gameBoard[0][3] = player2Queen;
        this.secondPlayerPieces.add(player2Queen);
    }

    /**
     * The method will initiate the starting position for the white pieces
     */
    private void firstPlayerPieceInit()
    {
        for(int i = 0; i < 8; i++)
        {
            Pawn newPawn = new Pawn(new Pair(6, i), PlayerSpecifier.FIRST);
            this.gameBoard[6][i] = newPawn;
            this.firstPlayerPieces.add(newPawn);
        }

        Rook player1LeftRook = new Rook(new Pair(7, 0), PlayerSpecifier.FIRST);
        Rook player1RightRook = new Rook(new Pair(7, 7), PlayerSpecifier.FIRST);
        this.gameBoard[7][0] = player1LeftRook;
        this.gameBoard[7][7] = player1RightRook;
        this.firstPlayerPieces.add(player1LeftRook);
        this.firstPlayerPieces.add(player1RightRook);

        Knight player1LeftKnight = new Knight(new Pair(7, 1), PlayerSpecifier.FIRST);
        Knight player1RightKnight = new Knight(new Pair(7, 6), PlayerSpecifier.FIRST);
        this.gameBoard[7][1] = player1LeftKnight;
        this.gameBoard[7][6] = player1RightKnight;
        this.firstPlayerPieces.add(player1LeftKnight);
        this.firstPlayerPieces.add(player1RightKnight);

        Bishop player1LeftBishop = new Bishop(new Pair(7, 2), PlayerSpecifier.FIRST);
        Bishop player1RightBishop = new Bishop(new Pair(7, 5), PlayerSpecifier.FIRST);
        this.gameBoard[7][2] = player1LeftBishop;
        this.gameBoard[7][5] = player1RightBishop;
        this.firstPlayerPieces.add(player1LeftBishop);
        this.firstPlayerPieces.add(player1RightBishop);

        King player1King = new King(new Pair(7, 4), PlayerSpecifier.FIRST);
        this.gameBoard[7][4] = player1King;
        this.firstPlayerPieces.add(player1King);

        Queen player1Queen = new Queen(new Pair(7, 3), PlayerSpecifier.FIRST);
        this.gameBoard[7][3] = player1Queen;
        this.firstPlayerPieces.add(player1Queen);
    }

    /**
     * The method will return the piece exist in the given location, if theres no piece the method will return
     * null
     * @param givenLocation location of the piece to look for
     * @return the located piece
     */
    public Piece getPieceFromLocation(Pair givenLocation)
    {
        int leftCoordinate = givenLocation.getLeft();
        int rightCoordinate = givenLocation.getRight();
        if (this.gameBoard[leftCoordinate][rightCoordinate] != null)
        {
            return this.gameBoard[leftCoordinate][rightCoordinate];
        }
        else
            return null;
    }

    /**
     * The method will return the piece exist in the given location, if theres no piece the method will return
     * null
     * @param leftCoordinate x location of the piece to look for
     * @param rightCoordinate y location of the piece to look for
     * @return
     */
    public Piece getPieceFromLocation(int leftCoordinate, int rightCoordinate)
    {
        if (leftCoordinate < 0 || leftCoordinate > 7 || rightCoordinate < 0 || rightCoordinate > 7)
        {
            return null;
        }
        if (this.gameBoard[leftCoordinate][rightCoordinate] != null)
        {
            return this.gameBoard[leftCoordinate][rightCoordinate];
        }
        else
            return null;
    }

    /**
     * used for debug - print the current state of the board
     */
    public void printBoardWithObjects()
    {
        for (int i = 0; i < 8; i++)
        {
            System.out.println("");
            for (int j = 0; j < 8; j++)
            {
                System.out.print(this.gameBoard[i][j] + " ");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    /**
     * the method will put null in the given location
     * @param givenLocation x,y coordinates
     */
    public void putNull(Pair givenLocation)
    {
        int leftCoordinate = givenLocation.getLeft();
        int rightCoordinate = givenLocation.getRight();
        this.gameBoard[leftCoordinate][rightCoordinate] = null;
    }

    /**
     * The method will put a given piece at a given location
     * @param givenLocation location to place
     * @param givenPiece piece
     * @param playerNumber white or black
     */
    public void putPiece(Pair givenLocation, Piece givenPiece, PlayerSpecifier playerNumber)
    {
        int leftCoordinate = givenLocation.getLeft();
        int rightCoordinate = givenLocation.getRight();
        this.gameBoard[leftCoordinate][rightCoordinate] = givenPiece;
    }

    /**
     * The method will remove a piece from the board
     * @param givenPiece piece to remove
     * @param playerNumber white or black
     */
    public void removeFromPieceList(Piece givenPiece, PlayerSpecifier playerNumber)
    {
        if (playerNumber == PlayerSpecifier.FIRST)
        {
            this.secondPlayerPieces.remove(givenPiece);
        }
        else
        {
            this.firstPlayerPieces.remove(givenPiece);
        }
    }

    /**
     * The method will add a new piece to the board according to chosen player
     * @param givenLocation location to place
     * @param givenPiece piece
     * @param playerNumber black or white
     */
    public void addNewPiece(Pair givenLocation, Piece givenPiece, PlayerSpecifier playerNumber)
    {
        int leftCoordinate = givenLocation.getLeft();
        int rightCoordinate = givenLocation.getRight();
        this.gameBoard[leftCoordinate][rightCoordinate] = givenPiece;
        if (playerNumber == PlayerSpecifier.FIRST)
        {
            this.firstPlayerPieces.add(givenPiece);
        }
        else
        {
            this.secondPlayerPieces.add(givenPiece);
        }
    }

    /**
     * The method will remove a piece from the board according to chosen player
     * @param givenLocation location to remove
     * @param oldPiece piece
     * @param playerNumber black or white
     */
    public void removeOldPiece(Pair givenLocation, Piece oldPiece, PlayerSpecifier playerNumber)
    {
        int leftCoordinate = givenLocation.getLeft();
        int rightCoordinate = givenLocation.getRight();
        this.gameBoard[leftCoordinate][rightCoordinate] = null;
        if (playerNumber == PlayerSpecifier.FIRST)
        {
            this.firstPlayerPieces.remove(oldPiece);
        }
        else
        {
            this.secondPlayerPieces.remove(oldPiece);
        }
    }

    /**
     * The method will return the array list of pieces of given player
     * @param playerNumber black or white
     * @return array list contains all the pieces of the player
     */
    public ArrayList<Piece> getPlayerPieces(PlayerSpecifier playerNumber)
    {
        if (playerNumber == PlayerSpecifier.FIRST)
        {
            return this.firstPlayerPieces;
        }
        else
        {
            return this.secondPlayerPieces;
        }
    }

    /**
     * The method will check if the given player is at "Check" state
     * @param nowPlayingPlayerNumber black or white
     * @return boolean value
     */
    public boolean isCheck(PlayerSpecifier nowPlayingPlayerNumber)
    {
        Pair kingLocation = null;
        ArrayList<Piece> playerPiecesArray = getPlayerPieces(nowPlayingPlayerNumber);
        for (Piece curPiece : playerPiecesArray)
        {
            if (curPiece.getClass() == King.class)
            {
                kingLocation = curPiece.getCurrentLocation();
                break;
            }
        }
        ArrayList<Piece> enemyPiecesArray;
        if (nowPlayingPlayerNumber == PlayerSpecifier.FIRST)
        {
            enemyPiecesArray = this.secondPlayerPieces;
        }
        else
        {
            enemyPiecesArray = this.firstPlayerPieces;
        }
        for (Piece enemyPiece : enemyPiecesArray)
        {
            ArrayList<Pair> currentEnemyPiecePossibleMoves = enemyPiece.possiblePieceMoves(this);
            for (Pair possibleMoveLocation : currentEnemyPiecePossibleMoves)
            {
                if (possibleMoveLocation.isIdenticalPair(kingLocation))
                {
                    return true;
                }
            }
        }
        return false;
    }



}
