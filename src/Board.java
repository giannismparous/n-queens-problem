import java.util.Random;

class Board {
    private int b[];
    private int safePairs;
    private int maxPairs;

    public Board(int b[]) {
        this.b=b;
        this.safePairs=calc();
        this.maxPairs=GetMaxSafePairs(this.b.length);
        }

    public Board(int N) {
        this.b = new int[N];
        Random rand = new Random();
        for (int x=0;x<N;x++) {
            this.b[x]=rand.nextInt(N-1);
                }
            this.safePairs = calc();
            this.maxPairs=GetMaxSafePairs(N);
        }

    public int calc() {
        int safe=0;
        for (int i=0;i<this.b.length;i++) {
            for (int j=i+1;j<this.b.length;j++) {
                if ((this.b[i]!=this.b[j]) && (Math.abs(i-j) != Math.abs(b[i] - b[j]))) {
                    safe++;
                }
            }
        }
        return safe;
    }

    public int GetMaxSafePairs(int N) {
        int sum=0;
        for (int i=1;i<N;i++) {
            sum+=i;
        }
        return sum;
    }

    public int getLength(){
        return b.length;
    }

    public int getSafePairs(){
        return safePairs;
    }

    public int getMaxPairs(){
        return maxPairs;
    }

    public int[] getBoard() {
        return b;
    }

    @Override
	public String toString() {
		String s = "Queen Placements : ";
        for (int k=0; k<this.b.length;k++) {
            s += this.b[k] + 1;
            s += " ";
        }
        s += "\n";
        s += "Board Fitness : ";
        s += safePairs;
        s += "\n";
		for (int i = 0; i < b.length; i++) {
            for (int j=0; j< b.length;j++){
				if (b[j] == i) {
					s += " Q ";
				} else {
					s += " / ";
				}
		    }
            s += "\n";
        }
        if (safePairs==maxPairs) {
            s += "Correct Solution!";
            }
        else
        {
            s += "Incorrect Solution";
        }
		return s;
    }
}