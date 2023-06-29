package HW11

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Простая (2 балла)
 *
 * Рассчитать расстояние между двумя окружностями.
 * Расстояние между непересекающимися окружностями рассчитывается как
 * расстояние между их центрами минус сумма их радиусов.
 * Расстояние между пересекающимися окружностями считать равным 0.0.
 */

data class Circle(val center: Point, val radius: Double) {
    fun distance(other: Circle): Double {
        var result = sqrt((center.y - other.center.y).pow(2) + (center.x - other.center.x).pow(2)) - radius - other.radius
        return if (result > 0) result else 0.0
    }
}

data class Point(val x: Double, val y: Double)