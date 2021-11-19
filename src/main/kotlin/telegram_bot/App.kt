package telegram_bot

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json

@Serializable(Serializer::class)
interface Example
@Serializable
data class StringExample(val data: String) : Example

object Serializer : KSerializer<Example> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): Example {
        val data = decoder.decodeString()
        return StringExample(data)
    }

    override fun serialize(encoder: Encoder, value: Example) {
        encoder.encodeString((value as StringExample).data)
    }

}

fun main() {
    // Uncomment next line to see issue
//    Example.serializer()
}
