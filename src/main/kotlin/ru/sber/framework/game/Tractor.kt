package ru.sber.framework.game

class Tractor {
    var position = intArrayOf(0, 0)
    var field = intArrayOf(5, 5)
    var orientation = Orientation.NORTH

    fun move(command: String) {
        if (command === "F") {
            moveForwards()
        } else if (command === "T") {
            turnClockwise()
        }
    }

    fun moveForwards() {
        if (orientation === Orientation.NORTH) {
            position = intArrayOf(position[0], position[1] + 1)
        } else if (orientation === Orientation.EAST) {
            position = intArrayOf(position[0] + 1, position[1])
        } else if (orientation === Orientation.SOUTH) {
            position = intArrayOf(position[0], position[1] - 1)
        } else if (orientation === Orientation.WEST) {
            position = intArrayOf(position[0] - 1, position[1])
        }
        if (position[0] > field[0] || position[1] > field[1]) {
            throw TractorInDitchException()
        }
    }

    fun turnClockwise() {
        if (orientation === Orientation.NORTH) {
            orientation = Orientation.EAST
        } else if (orientation === Orientation.EAST) {
            orientation = Orientation.SOUTH
        } else if (orientation === Orientation.SOUTH) {
            orientation = Orientation.WEST
        } else if (orientation === Orientation.WEST) {
            orientation = Orientation.NORTH
        }
    }

    val positionX: Int
        get() = position[0]

    val positionY: Int
        get() = position[1]

}