package bst;

import java.util.Random;

public class BinarySearchTreeProgram {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bsti = new BinarySearchTree<>();
        BinarySearchTree<Car> bstCar = new BinarySearchTree<>((e1, e2) -> (((Comparable) e1.getReg()).compareTo(e2.getReg())));
        BSTVisualizer visualizer1 = new BSTVisualizer("Integer tree", 500, 500);
        BSTVisualizer visualizer2 = new BSTVisualizer("Balanced Integer tree", 450, 450);
        BSTVisualizer visualizer3 = new BSTVisualizer("Balanced Car tree", 400, 400);
        Random random = new Random();

        //Adds integers
        for (int i = 0; i < 20; i++) {
            bsti.add(i);
            //bsti.add(random.nextInt(100));
        }

        //Adds random cars
        for (int i = 0; i < 15; i++) {
            bstCar.add(new Car(random.nextInt(100) + 100));
        }

        //draws an unbalanced integer tree
        visualizer1.drawTree(bsti);

        //balances and draws the integer tree
        bsti.rebuild();
        visualizer2.drawTree(bsti);

        //balances and draws the car tree
        bstCar.rebuild();
        visualizer3.drawTree(bstCar);

    }
}
