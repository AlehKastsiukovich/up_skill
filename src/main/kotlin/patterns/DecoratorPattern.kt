package patterns

/**
 * The Decorator Pattern is a structural design pattern that allows you to dynamically add new behaviors or
 * responsibilities to an object without modifying its code or using inheritance. Instead, it wraps the object with a
 * "decorator" that implements the same interface and adds the desired functionality.
 *
 * Key Concepts:
 * 1. Composition over Inheritance: Instead of creating subclasses to extend behavior, decorators use composition by wrapping the original object.
 * 2. Transparency: The decorator and the original object share the same interface, so they can be used interchangeably.
 * 3. Flexibility: You can chain multiple decorators together to combine behaviors.
 */

interface TextProcessor {
    fun process(text: String): String
}

abstract class TextProcessDecorator(protected val processor: TextProcessor) : TextProcessor

class BaseTextProcessorProcessor : TextProcessor {
    override fun process(text: String): String = text
}

class ReversTextProcessor(processor: TextProcessor) : TextProcessDecorator(processor) {
    override fun process(text: String): String {
        val base = processor.process(text)
        return base.reversed()
    }
}

fun main() {
    val baseProcessor = BaseTextProcessorProcessor()
    val processor: TextProcessDecorator = ReversTextProcessor(baseProcessor)
    val result = processor.process("Hello world")
    println(result)
}





