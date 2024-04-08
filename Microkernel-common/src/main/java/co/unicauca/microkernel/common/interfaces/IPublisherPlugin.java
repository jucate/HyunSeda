/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.microkernel.common.interfaces;

import java.util.Properties;

/**
 *
 * @author jorge
 */
public interface IPublisherPlugin {

    /**
     *
     * @param msg Mensaje a ser publicado a trav�s de un servicio de mensajer�a
     */
    public void publish(String msg);

    public void setProperties(Properties publisherProperties);
}