import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

fun getProducerConfiguration() = Properties().apply {
    setProperty("bootstrap.servers", "127.0.0.1:9092")
    setProperty("key.serializer", StringSerializer::class.qualifiedName)
    setProperty("value.serializer", StringSerializer::class.qualifiedName)
    setProperty("acks", "1")
    setProperty("retries", "3")
}

fun getConsumerConfiguration() = Properties().apply {
    setProperty("bootstrap.servers", "127.0.0.1:9092")
    setProperty("key.deserializer", StringDeserializer::class.qualifiedName)
    setProperty("value.deserializer", StringDeserializer::class.qualifiedName)
    setProperty("group.id", "test")
    setProperty("enable.auto.commit", "true")
    setProperty("auto.offset.reset", "earliest")
}

