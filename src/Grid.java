// Nom: Nathan Frenette
// Matricule: 20208608

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {
    public class Cell {
        public int value;
        public Cell left;
        public Cell right;
        public Cell top;
        public Cell bottom;

        public Cell(int value) {
            this.value = value;
            this.left = null;
            this.top = null;
            this.right = null;
            this.bottom = null;
        }
    }

    private Cell[][] grid;

    public Grid() {
        grid = new Cell[3][4];

        List<Integer> cellValues = new ArrayList<>();
        cellValues.add(1);
        cellValues.add(1);
        cellValues.add(1);
        cellValues.add(1);
        cellValues.add(5);
        cellValues.add(5);
        cellValues.add(10);
        cellValues.add(10);
        cellValues.add(10);
        cellValues.add(10);
        cellValues.add(25);
        Collections.shuffle(cellValues);

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 / 2 && j == 4 / 2) {
                    grid[i][j] = new Cell(-1);
                } else {
                    grid[i][j] = new Cell(cellValues.get(index));
                    index++;
                }
            }
        }
    }

    public boolean move(Cell box) {
        if ((box.left != null && box.left.value == -1) ||
                (box.right != null && box.right.value == -1) ||
                (box.top != null && box.top.value == -1) ||
                (box.bottom != null && box.bottom.value == -1)) {

            int temp = box.value;
            box.value = -1;
            if (box.left != null && box.left.value == -1) {
                box.left.value = temp;
                box.left.right = box;
                box.left = null;
            } else if (box.right != null && box.right.value == -1) {
                box.right.value = temp;
                box.right.left = box;
                box.right = null;
            } else if (box.top != null && box.top.value == -1) {
                box.top.value = temp;
                box.top.bottom = box;
                box.top = null;
            } else if (box.bottom != null && box.bottom.value == -1) {
                box.bottom.value = temp;
                box.bottom.top = box;
                box.bottom = null;
            }

            return true;
        }

        return false;
    }

    public boolean check_complete() {
        for (int i = 0; i < 4; i++) {
            if (grid[0][i].value != grid[2][i].value) {
                return false;
            }
        }

        return true;
    }

    public void solve_game() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Cell currentCell = this.grid[i][j];
                if (currentCell.value == -1) {
                    continue;
                }

                if (move(currentCell)) {
                    if (check_complete()) {
                        System.out.println("Puzzle solved");
                        return;
                    } else {
                        solve_game();
                        move(currentCell);
                    }
                }
            }
        }

        System.out.println("Cannot solve the puzzle");
    }

}
