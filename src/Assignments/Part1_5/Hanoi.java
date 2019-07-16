package Assignments.Part1_5;


import java.util.ArrayList;

public class Hanoi {
    /**
     * Towers of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective
     * of the puzzle is to move the entire stack to another rod, obeying the following simple rules (from
     * geeksforgeeks.com):
     * 1. Only one disk can be moved at a time.
     * 2. Each move consists of taking the upper disk from one of the stacks and placing it on top
     * of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
     * 3. No disk may be placed on top of a smaller disk.
     * Create a class to implement the Towers of Hanoi puzzle logic. You will need at least the
     *      * following methods:
     * ● void moveDisk(int startingRod, int destinationRod)
     * ● Array<Disk> disksAtRod(int rodIndex)
     * ● int numberOfRods()
     */



    public static class Disk {
        public int position;

        Disk(int value) {
            this.position = value;
        }

        public int getPosition() {
            return position;
        }
    }

    ArrayList<Disk> diskAtRod(int rodIndex)  {
        switch (rodIndex) {
            case 1:
                return rodOne;
            case 2:
                return rodTwo;
            case 3:
                return rodThree;
        }
        return null;
    }

    public Hanoi(int numDisk) {
        for (int i = numDisk; i > 0; i--) {
            Disk disk = new Disk(i);
            rodOne.add(0,disk);
        }
    }

    private ArrayList<Disk> rodOne = new ArrayList<>();
    private ArrayList<Disk> rodTwo = new ArrayList<>();
    private ArrayList<Disk> rodThree = new ArrayList<>();

    public ArrayList<Disk> getRodThree() {
        return rodThree;
    }

    public int numberOfRods() {
        return 3;
    }

    Disk topDisk(ArrayList<Disk> rod) {
        return rod.get(0);
    }

    public void solve() {
        solveHelper(rodOne.size(),rodOne,rodThree,rodTwo);
    }

    public void solveHelper(int n, ArrayList<Disk> first, ArrayList<Disk> third, ArrayList<Disk> second) {

        // assuming that blocks are numbered in ascending order (top = 1, bottom = n)

        if (n == 1) {
            moveDisk(first,third,topDisk(first));
            return;
        }

        solveHelper(n - 1,first,second,third);
        moveDisk(first,third,topDisk(first));
        solveHelper(n - 1,second,third,first);
    }


    public void moveDisk(ArrayList<Disk> startingRod, ArrayList<Disk> destinationRod, Disk disk) {
        destinationRod.add(0,disk);
        startingRod.remove(disk);
    }


    public static void main(String[] args) {
        Hanoi game = new Hanoi(3);
        game.solve();
    }
}
