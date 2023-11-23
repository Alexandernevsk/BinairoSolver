package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<String> board1 = new ArrayList<>(List.of("...0..", ".....1", "...0..", ".11...", "0...0.", "..1..."));
    List<String> sample = new ArrayList<>(List.of(
            ".1....",
            "0...11",
            "00..1.",
            "..1..0",
            "...1..",
            "1...0."));
    BinairoSolver binairoSolver = new BinairoSolver();

    public String solveColumn(int index, List<String> board) {
        String column = "";

        for (String s : board) {
            column += s.charAt(index);
        }

        return binairoSolver.solve(column);
    }

    public List<String> solveBoard(List<String> board) {
        BinairoSolver binairoSolver = new BinairoSolver();
        int index = 0;

        do {

            board.replaceAll(binairoSolver::solve);

            for (int columnIndex = 0; columnIndex < board.get(0).length(); columnIndex++) {
                String column = solveColumn(columnIndex, board);

                for (int rowIndex = 0; rowIndex < board.size(); rowIndex++) {
                    char[] rowArr = board.get(rowIndex).toCharArray();


                    if (column.charAt(rowIndex) != rowArr[columnIndex]) {
                        rowArr[columnIndex] = column.charAt(rowIndex);
                    }

                    board.set(rowIndex, new String(rowArr));
                }
            }

            index = (index < board.size() - 1) ? index + 1 : 0;

        } while (board.stream().anyMatch(space -> space.contains(".")));

        return board;
    }

    public static void main(String[] args) {
        Game game = new Game();
        List<String> sample = new ArrayList<>(List.of(
                "....0.",
                "1...00",
                ".0.1..",
                "..0...",
                "0....1",
                ".1.0.."
        ));

        System.out.println(sample);
        game.solveBoard(sample);
        System.out.println(sample);
    }
}
