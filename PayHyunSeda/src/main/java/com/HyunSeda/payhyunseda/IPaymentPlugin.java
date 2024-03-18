package com.hyunseda.payhyunseda;
public interface IPaymentPlugin {
    boolean payProcessing(Payment payment);
}