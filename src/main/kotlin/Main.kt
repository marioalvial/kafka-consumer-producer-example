import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

fun main(args: Array<String>) {
    producer()
    consumer()
}

private fun producer() {
    val producer = KafkaProducer<String, String>(getProducerConfiguration())

    for (i in 0..10) {
        val record = ProducerRecord<String, String>("third_topic", "3", "message text $i")
        producer.send(record)
    }
    producer.flush()
    producer.close()
}

private fun consumer(){
    val consumer = KafkaConsumer<String, String>(getConsumerConfiguration())
    consumer.subscribe(listOf("third_topic"))

    while (true){
        val records: ConsumerRecords<String, String> = consumer.poll(100)
        records.forEach{
            println("Key: ${it.key()}")
            println("Value: ${it.value()}")
            println("Partition: ${it.partition()}")
            println("Offset: ${it.offset()}")
            println("Topic: ${it.topic()}")
            println("Timestamp: ${it.timestamp()}")
            print("========================================")
        }
    }
}