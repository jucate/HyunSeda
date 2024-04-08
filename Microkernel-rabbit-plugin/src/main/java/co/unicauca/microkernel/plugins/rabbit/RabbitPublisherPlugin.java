/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.microkernel.plugins.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import co.unicauca.microkernel.common.interfaces.IPublisherPlugin;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class RabbitPublisherPlugin implements IPublisherPlugin {

    private Properties properties;

    @Override
    public void publish(String msg) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(properties.getProperty("hostName"));
        try {
            com.rabbitmq.client.Connection connection = factory.newConnection();
            com.rabbitmq.client.Channel channel = connection.createChannel();
            channel.queueDeclare(properties.getProperty("queueName"), false, false, false, null);
            channel.basicPublish("", properties.getProperty("queueName"), null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + msg + "'");
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitPublisherPlugin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

