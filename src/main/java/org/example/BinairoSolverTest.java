package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinairoSolverTest {

    BinairoSolver binairoSolver;
    Game game;

    @BeforeEach
    void setup() {
        binairoSolver = new BinairoSolver();
    }

    @BeforeEach
    void setupGame() {
        game = new Game();
    }

    @Test
    void returnNonNullString() {
        assertEquals("", binairoSolver.solve(null));
    }

    @Test
    void ensure_opposite_number_between_two_equal_numbers() {

        assertEquals("010...", binairoSolver.solve("0.0..."));
        assertEquals("......", binairoSolver.solve("......"));
        assertEquals("101...", binairoSolver.solve("1.1..."));
        assertEquals("..101.", binairoSolver.solve("..1.1."));

    }

    @Test
    void ensure_pair_has_opposite_neighbour() {
        assertEquals("110...", binairoSolver.solve("11...."));
        assertEquals(".0110.", binairoSolver.solve("..11.."));
        assertEquals("001...", binairoSolver.solve("00...."));
        assertEquals("..1001", binairoSolver.solve("...00."));
    }

    @Test
    void ensure_invalid_length_exception() {
        assertThrows(IllegalArgumentException.class, () -> binairoSolver.solve("......."));
        assertThrows(IllegalArgumentException.class, () -> binairoSolver.solve("..."));
    }

    @Test
    void ensure_invalid_input_exception() {
        assertThrows(IllegalArgumentException.class, () -> binairoSolver.solve(".2215."));
    }

    @Test
    void ensure_leftover_empty_spaces_result_in_equal_size_of_number() {
        assertEquals("010110", binairoSolver.solve(".1011."));
        assertEquals("01.01.", binairoSolver.solve("01.01."));
        assertEquals("101001", binairoSolver.solve(".0.00."));
        assertEquals("010011", binairoSolver.solve("0.00.."));
        assertEquals("01....", binairoSolver.solve("01...."));
    }


    @Test
    void test_solver_for_board() {
        List<String> outputOfBoard1 = List.of("010011", "100101", "101010", "011010", "010101", "101100");
        List<String> randomSample = List.of("110100", "010011", "001011", "101100", "010110", "101001");

        assertEquals(outputOfBoard1, game.solveBoard(game.board1));
        assertEquals(randomSample, game.solveBoard(game.sample));
    }


}
