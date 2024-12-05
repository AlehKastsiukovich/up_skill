package patterns

import java.util.UUID

fun interface Logger {
    fun log(message: String)
}

val consoleLogger = Logger { println(it) }

fun Logger.withUniqueId() = Logger { log("${UUID.randomUUID()} $it")}
fun Logger.withThreadName() = Logger { log("$it (on ${Thread.currentThread().name} thread)")}

fun main() {
    val logger = consoleLogger.withThreadName().withUniqueId()
    logger.log("App Logger")
    //55369eb3-0d54-4de0-b7a6-d0aed205097b App Logger:  (on main thread)
}
