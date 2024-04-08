/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.infra;

import co.com.hyunseda.market.dataAccess.PluginManager;
import co.unicauca.microkernel.common.interfaces.IPublisherPlugin;

/**
 *
 * @author jorge
 */
public class Publisher {

    public Publisher() {
    }

    public void publish(String msg) {
        PluginManager manager = PluginManager.getInstance();
        IPublisherPlugin publisher = manager.getPublisherPlugin("publisherTech");
        publisher.publish(msg);
    }
}