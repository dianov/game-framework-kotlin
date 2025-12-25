package ru.sber.framework.game

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class TractorTest {
    @Test
    fun testShouldMoveForward() {
        val tractor = Tractor()
        tractor.move("F")
        assertEquals(0, tractor.positionX)
        assertEquals(1, tractor.positionY)
    }

    @Test
    fun testShouldTurn() {
        val tractor = Tractor()
        tractor.move("T")
        assertEquals(Orientation.EAST, tractor.orientation)
        tractor.move("T")
        assertEquals(Orientation.SOUTH, tractor.orientation)
        tractor.move("T")
        assertEquals(Orientation.WEST, tractor.orientation)
        tractor.move("T")
        assertEquals(Orientation.NORTH, tractor.orientation)
    }

    @Test
    fun testShouldTurnAndMoveInTheRightDirection() {
        val tractor = Tractor()
        tractor.move("T")
        tractor.move("F")
        assertEquals(1, tractor.positionX)
        assertEquals(0, tractor.positionY)
        tractor.move("T")
        tractor.move("F")
        assertEquals(1, tractor.positionX)
        assertEquals(-1, tractor.positionY)
        tractor.move("T")
        tractor.move("F")
        assertEquals(0, tractor.positionX)
        assertEquals(-1, tractor.positionY)
        tractor.move("T")
        tractor.move("F")
        assertEquals(0, tractor.positionX)
        assertEquals(0, tractor.positionY)
    }

    @Test
    fun testShouldThrowExceptionIfFallsOffPlateau() {
        val tractor = Tractor()
        tractor.move("F")
        tractor.move("F")
        tractor.move("F")
        tractor.move("F")
        tractor.move("F")
        assertThrows(TractorInDitchException::class.java, {
            tractor.move("F")
        })
    }
}
