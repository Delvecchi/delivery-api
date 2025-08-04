package com.deliverytech.delivery.projection;

import java.math.BigDecimal;

public interface RelatorioVendas {

	String getNomeRestaurante();

	BigDecimal getTotalVendas();

	Long getQuantidePedidos();

}
