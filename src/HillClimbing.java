import java.util.ArrayList;

class HillClimbing {
    public void run(Board board) {
        int maxP = board.getMaxPairs();
        Board currentBoard = board;
        boolean search=true;
        boolean LocalMax=false;
        while (search) {
            if (currentBoard.getSafePairs()==maxP){
                search=false;
                System.out.println(currentBoard);
                break;
            }
            else {
                for (int col=0; col<currentBoard.getLength(); col++) {
                    Board nextGen = generateNext(currentBoard,col);
                    if (nextGen.getSafePairs()>currentBoard.getSafePairs()) {
                        currentBoard = nextGen;
                        LocalMax = false;
                    }
                    else {
                        LocalMax = true;
                    }
                }
                if (LocalMax) {
                    currentBoard = new Board(currentBoard.getLength());
                }
            }
        }
    }   
    
    public Board generateNext(Board board,int col) {
        ArrayList<Board> children = new ArrayList<Board>();
        for (int i=0; i<board.getLength(); i++) {   
            if (board.getBoard()[col] != i) {
                int child[] = new int[board.getLength()];
                for (int j=0;j<child.length;j++) {
                    child[j] = board.getBoard()[j];
                }
                child[col] = i;
                children.add(new Board(child));
            }
        }
        Board bestGen = children.get(0);
        for (int j=0; j<children.size();j++) {
            if (children.get(j).getSafePairs()>bestGen.getSafePairs()) {
                bestGen = children.get(j);
            }
        }
        return bestGen;
    }
}