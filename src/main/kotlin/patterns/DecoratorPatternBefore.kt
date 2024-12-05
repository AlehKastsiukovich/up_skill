package patterns

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





