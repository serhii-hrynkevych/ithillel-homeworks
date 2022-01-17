import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main( String[] args ) throws Exception {
        int count = 0;
        String messageText = "Message from publisher N ";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        while (true) {
            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                String message = messageText + count;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                count = count + 1;
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException ignored)
                {}
            }
        }
    }

}
